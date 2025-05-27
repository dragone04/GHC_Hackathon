<template>
  <div class="container mt-4">
    <h2>Data Table</h2>
    <table class="table table-striped">
      <thead>
        <tr>
          <th >Transnum</th>
          <th >amount</th>
          <th >transdate</th>
          <th>transtTime</th>
          <th>category name</th>
          <th>Costumer Name</th>
          <th>Costumer Last</th>
          <th>City</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in items" :key="item.id">
          <td>{{ item.transNum }}</td>
          <td>{{ item.amount }}</td>
          <td>{{ item.transdate }}</td>
          <td>{{ item.transTime }}</td>
          <td>{{ item.category.categoryName }}</td>
          <td>{{ item.customer.first }}</td>
          <td>{{ item.customer.last }}</td>
          <td>{{ item.customer.city.cityName }}</td>
          <td>
            <button class="btn btn-warning btn-sm" @click="editItem(item.id)">Edit</button>
          </td>
          <td><button class="btn btn-danger btn-sm" @click="deleteItem(item.id)">Delete</button></td>
        </tr>
      </tbody>
    </table>
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
      sortOrder: 'asc'
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
    getData () {
      axios.get('http://localhost:8080/transaction/getAll')
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
    editItem(id) {
      console.log('Editing item with id:', id);
      this.$router.push({ name: 'RowDetail', params: { id } });
    },
    deleteItem(id) {
      this.items = this.items.filter(item => item.id !== id);
    }
  }
};
</script>

<style scoped>
.table th {
  cursor: pointer;
}
</style>