package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.CategoryTransactionSummary;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.entity.YearMonthTransactionSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface TransactionRepository extends CrudRepository<Transaction, String> {

    Iterable<Transaction> findTransactionByCustomerCustomerId(Integer customerId);

    //add a new methhod to find transactions by customerId and between and equal a date range on trans_date
    Iterable<Transaction> findTransactionByCustomerCustomerIdAndTransDateBetween(Integer customerId, LocalDate startDate, LocalDate endDate);


    @Query("SELECT new it.nexi.hackathon.entity.CategoryTransactionSummary(t.category.categoryName, SUM(t.amount)) " +
            "FROM Transaction t " +
            "WHERE t.customer.customerId = :customerId " +
            "AND t.transDate >= :startDate AND t.transDate <= :endDate " +
            "GROUP BY t.category.categoryName")
    List<CategoryTransactionSummary> sumAmountByCategoryAndCustomerAndDateRange(
            @Param("customerId") Integer customerId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );


    @Query("SELECT new it.nexi.hackathon.entity.YearMonthTransactionSummary(YEAR(t.transDate), MONTH(t.transDate), SUM(t.amount)) " +
            "FROM Transaction t " +
            "WHERE t.customer.customerId = :customerId " +
            "AND t.transDate >= :startDate AND t.transDate <= :endDate " +
            "GROUP BY YEAR(t.transDate), MONTH(t.transDate) " +
            "ORDER BY YEAR(t.transDate), MONTH(t.transDate)")
    List<YearMonthTransactionSummary> sumAmountByYearAndMonthAndCustomerAndDateRange(
            @Param("customerId") Integer customerId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}