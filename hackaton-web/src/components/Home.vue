<template>
  <div class="container mt-5">
    <h1>Welcome to the Home Page</h1>
    <div class="d-flex justify-content-around">
      <router-link to="/data" class="btn btn-primary">Data</router-link>
      <router-link to="/graph" class="btn btn-secondary">Graph</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style scoped>
.container {
  text-align: center;
}
</style>