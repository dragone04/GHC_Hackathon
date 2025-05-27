<template>
  <div class="home">
    <h1>Welcome to the Home Page</h1>


      <router-link to="/data" class="btn btn-primary"><img src="@/assets/data_icon.png" width="200" height="200"></router-link><br/><br/>
      <router-link to="/graph" class="btn btn-secondary "><img src="@/assets/graph.png" width="200" height="200" style=""></router-link>
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
.btn-rounded {
  border-radius: 50%;
} 
</style>