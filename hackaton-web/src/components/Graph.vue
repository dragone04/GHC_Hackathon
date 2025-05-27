<template>
  <div class="graph-container">
    <h2>Data Visualization</h2>
    <canvas id="myChart"></canvas>
  </div>
</template>

<script>
import { onMounted } from 'vue';
import Chart from 'chart.js/auto';

export default {
  name: 'Graph',
  setup() {
    onMounted(() => {
      const ctx = document.getElementById('myChart').getContext('2d');
      const myChart = new Chart(ctx, {
        type: 'line', // Change this to the desired chart type
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'], // Example labels
          datasets: [{
            label: 'Sample Data',
            data: [65, 59, 80, 81, 56, 55, 40], // Example data
            borderColor: 'rgba(75, 192, 192, 1)',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });
    });
  }
}
</script>

<style scoped>
.graph-container {
  width: 80%;
  margin: auto;
}
</style>