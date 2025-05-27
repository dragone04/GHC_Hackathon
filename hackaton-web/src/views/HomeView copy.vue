<template>
  <div class="home">
    <h1>Welcome to the Home Page</h1>
    <div class="btn-group" role="group" aria-label="Basic example">
      <router-link to="/data" class="btn btn-primary">Data</router-link>
      <router-link to="/graph" class="btn btn-secondary">Graph</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
}
</script>

<style scoped>
.home {
  text-align: center;
  margin-top: 50px;
}
.btn-group {
  margin-top: 20px;
}
</style>