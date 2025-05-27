import csv
import mysql.connector

db_config = {
    'host': 'localhost',
    'user': 'root',
    'password': 'my-secret-pw',
    'database': 'ghc_hack',
    'autocommit': True
}
def get_or_create_customer(cursor, first, last, gender, dob, city_id, job_id):
    """Get customer_id if exists, else insert and return new id."""
    cursor.execute(
        "SELECT customer_id FROM customer WHERE first=%s AND last=%s AND gender=%s AND dob=%s AND city_id=%s AND job_id=%s",
        (first, last, gender, dob, city_id, job_id)
    )
    row = cursor.fetchone()
    if row:
        return row[0]
    cursor.execute(
        "INSERT INTO customer (first, last, gender, dob, city_id, job_id) VALUES (%s, %s, %s, %s, %s, %s)",
        (first, last, gender, dob, city_id, job_id)
    )
    return cursor.lastrowid
def main():
    conn = mysql.connector.connect(**db_config)
    cursor = conn.cursor()
    cursor.execute("DELETE FROM transaction")
    cursor.execute("DELETE FROM customer")
    cursor.execute("DELETE FROM category")
    cursor.execute("DELETE FROM city")
    cursor.execute("DELETE FROM job")
    print("First scan start")
    categories = set()
    cities = set()
    jobs = set()
    with open('data/italian_credit_card_transactions_subset.csv', newline='', encoding='utf-8') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            categories.add(row['category'])
            cities.add(row['city'])
            jobs.add(row['job'])
    print("First scan end")
    print("Insert cat, city, jobs")
    cursor.executemany(
        "INSERT INTO category (category_name) VALUES (%s)",
        [(cat,) for cat in categories]
    )
    cursor.executemany(
        "INSERT INTO city (city_name) VALUES (%s)",
        [(city,) for city in cities]
    )
    cursor.executemany(
        "INSERT INTO job (job_name) VALUES (%s)",
        [(job,) for job in jobs]
    )
    print("cat, city, jobs inserted")
    print("Look up start")
    cursor.execute("SELECT category_id, category_name FROM category")
    category_map = {name: cid for cid, name in cursor.fetchall()}
    cursor.execute("SELECT city_id, city_name FROM city")
    city_map = {name: cid for cid, name in cursor.fetchall()}
    cursor.execute("SELECT job_id, job_name FROM job")
    job_map = {name: jid for jid, name in cursor.fetchall()}
    print("Look up end")
    print("Second scan start")
    with open('data/italian_credit_card_transactions_subset.csv', newline='', encoding='utf-8') as csvfile:
        reader = csv.DictReader(csvfile)
        for i, row in enumerate(reader):
            print("Processing row:", i + 1)
            category_id = category_map[row['category']]
            city_id = city_map[row['city']]
            job_id = job_map[row['job']]
            # Get or create customer
            customer_id = get_or_create_customer(
                cursor,
                row['first'],
                row['last'],
                row['gender'],
                row['dob'],
                city_id,
                job_id
            )
            # Insert transaction
            cursor.execute(
                "INSERT IGNORE INTO transaction (trans_num, amount, trans_date, trans_time, category_id, customer_id) "
                "VALUES (%s, %s, %s, %s, %s, %s)",
                (
                    row['trans_num'],
                    row['amount'],
                    row['trans_date'],
                    row['trans_time'],
                    category_id,
                    customer_id
                )
            )
    cursor.close()
    conn.close()
if __name__ == '__main__':
    main()