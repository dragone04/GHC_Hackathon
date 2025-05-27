<template>
  <div class="container">
    <h2 class="text-center mt-5">Login</h2>
    <form @submit.prevent="handleLogin" class="mt-4">
      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" id="username" v-model="username" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" id="password" v-model="password" class="form-control" required />
      </div>
      <button type="submit" class="btn btn-primary" v-on:click="test">Login</button>
    </form>
    <div v-if="errorMessage" class="alert alert-danger mt-3">{{ errorMessage }}</div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      errorMessage: ''
    };
  },
  methods: {
    test () {
      console.log('test');
        const users = [
      {
        "username": "user1",
        "id": 13,
        "password": "password1"
      },
      {
        "username": "user2",
        "id":14,
        "password": "password2"
      }
    ];        
      
        const user = users.find(user => user.username === this.username);
        console.log(user)
        if (user) {
          localStorage.setItem('id', user.id);
          this.$router.push({ name: 'home' });
        } else {
          this.errorMessage = 'Invalid username or password';
        }
      console.log('test');
    },


  }
};
</script>

<style scoped>
.container {
  max-width: 400px;
  margin: auto;
}
</style>