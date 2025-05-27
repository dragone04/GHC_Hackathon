<template>
  <div class="container mt-4">
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">Transnum</th>
          <th scope="col">amount</th>
          <th scope="col">transdate</th>
          <th scope="col">transtTime</th>
          <th scope="col">category name</th>
          <th scope="col">Costumer Name</th>
          <th scope="col">Costumer Last</th>
          <th scope="col">City</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item, index in items" :key="item.id">
          <th scope="row" >{{ item.transNum }}</th>
          <td >{{ item.amount }}</td>
          <td >{{ item.transDate }}</td>
          <td >{{ item.transTime }}</td>
          <td >{{ item.category.categoryName }}</td>
          <td >{{ item.customer.first }}</td>
          <td >{{ item.customer.last }}</td>
          <td>{{ item.customer.city.cityName }}</td>
          <td>
            <button class="btn btn-warning btn-sm" @click="editItem(item.transNum)">Edit</button>
          </td>
          <td><button class="btn btn-danger btn-sm" @click="deleteItem(item.transNum)">Delete</button></td>
        </tr>
      </tbody>
    </table>
    <div v-if="edit == true">
      <table class="table table-bordered">
        <tr>
          <td>amount</td>
          <td><input v-model="amount" class="form-control"></td>
        </tr>
        <tr>
          <td>transDate</td>
          <td><input v-model="transDate" class="form-control"></td>
        </tr>
        <tr>
          <td>transTime</td>
          <td><input v-model="transTime" class="form-control"> </td>
        </tr>
      </table>
      <button class="btn btn-danger btn-sm" @click="update()">Update</button>
    </div>
  </div>
</template>

<script>
//import data from '../data/tabella.json';
import axios from 'axios';
export default {
  data() {
    return {
      items: [],
      sortKey: '',
      sortOrder: 'asc',
      edit: false,
      amount: '',
      transDate: '',
      transTime: '',
      idUpdate: null,
      global: {},
    };
  },
  mounted() {
    console.log('DataTable component mounted');
    this.getData();
  },

  computed: {
    sortedData() {
      return this.items.sort((a, b) => {
        const modifier = this.sortOrder === 'asc' ? 1 : -1;
        if (a[this.sortKey] < b[this.sortKey]) return -1 * modifier;
        if (a[this.sortKey] > b[this.sortKey]) return 1 * modifier;
        return 0;
      });
    }
  },
  methods: {
    getData() {
      axios.get('http://localhost:8080/transaction/getAll/' + localStorage.getItem('id'))
        .then(response => {
          this.items = response.data;
          console.log(response.data);
          console.log(this.items);
        })
        .catch(error => {
          console.error(error);
        });
    },
    sortData(key) {
      this.sortOrder = this.sortKey === key && this.sortOrder === 'asc' ? 'desc' : 'asc';
      this.sortKey = key;
    },
    update() {
      console.log('Amount:', this.amount);
      this.global.amount = this.amount;
      this.global.transDate = this.transDate;
      this.global.transTime = this.transTime;
      axios.put('http://localhost:8080/transaction/' + this.idUpdate,
        this.global
      )
        .then(response => {
          this.getData(); // Refresh the data after update
          this.edit = false; // Hide the edit form after update
        })
        .catch(error => {
          console.error(error);
        });

    },
    editItem(id) {
      axios.get('http://localhost:8080/transaction/' + id)
        .then(response => {
          this.global = response.data;
          this.amount = response.data.amount;
          this.transDate = response.data.transDate;
          this.transTime = response.data.transTime;
        })
        .catch(error => {
          console.error(error);
        });
      this.idUpdate = id;
      this.edit = true;
    },
    deleteItem(id) {
      axios.delete('http://localhost:8080/transaction/' + id)
        .then(response => {
          this.getData(); // Refresh the data after deletion
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};
</script>

<style scoped>
.table th {
  cursor: pointer;
}
</style>