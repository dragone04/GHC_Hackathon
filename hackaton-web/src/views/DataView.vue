<template>
  <div class="container mt-5">
    <h1>Data Table</h1>
    <DataTable />
  </div>
</template>

<script>
import DataTable from '../components/DataTable.vue';

export default {
  name: 'DataView',
  components: {
    DataTable
  }
};
</script>

<style scoped>
.container {
  max-width: 800px;
}
</style>