<template>
  <div class="row-detail">
    <h2>Row Details</h2>
    <div v-if="rowData">
      <table class="table table-bordered">
          <tr >
            <td>Name</td>
            <td><input :value="rowData[rowId].name" class="form-control" ></td>
          </tr>
          <tr>
            <td>Description</td>
            <td><input :value="rowData[rowId].description" class="form-control" ></td>
          </tr> 
          <tr>
            <td>Price</td>
            <td><input :value="rowData[rowId].price" class="form-control" > </td>
          </tr> 
      </table>
      <button class="btn btn-primary" @click="editRow">Edit</button>
      <button class="btn btn-danger" @click="deleteRow">Delete</button>
    </div>
    <div v-else>
      <p>Loading...</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'RowDetail',
  props: {
    rowId: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      rowData: [],
      rowId: null
    };
  },
  created() {
    const rowId = Number(this.$route.params.id);
    console.log(this.$route.params.id);
    console.log('RowDetail component created with rowId:', rowId);
    this.rowId = rowId;
    this.getData(rowId);
  },
  methods: {
    getData (rowId) {
      axios.get('/data/tabella.json')
        .then(response => {
          this.rowData = response.data.data;
          
          console.log(this.items);
        })
        .catch(error => {
          console.error(error);
        });
    },
    fetchRowData() {
      // Fetch the row data from the external JSON file based on rowId
      fetch('/src/data/tabella.json')
        .then(response => response.json())
        .then(data => {
          this.rowData = data.find(row => row.id === this.rowId);
        });
    },
    editRow() {
      // Logic for editing the row
      console.log('Edit row:', this.rowData);
    },
    deleteRow() {
      // Logic for deleting the row
      console.log('Delete row:', this.rowData);
    }
  }
};
</script>

<style scoped>
.row-detail {
  margin: 20px;
}
</style>