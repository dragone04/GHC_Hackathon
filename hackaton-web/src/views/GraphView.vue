<template>
  <div>
    <h2>Monthly Expenses</h2>
    <input type="date" v-model="dateFrom" />
    <input type="date" v-model="dateTo" />
    <button @click="fetchData">Show Chart</button>
    <canvas ref="barChart"></canvas>
  </div>
</template>

<script>
import axios from 'axios';
import Chart from 'chart.js/auto';

export default {
  data() {
    return {
      dateFrom: '',
      dateTo: '',
      chart: null,
      chartData: [],
      chartLabels: [],
    };
  },
  methods: {
    async fetchData() {
      const customerId = localStorage.getItem('id');
      if (!customerId || !this.dateFrom || !this.dateTo) return;

      try {
        const response = await axios.get(
          `http://localhost:8080/transaction/sumAmountByYearAndMonthAndCustomerAndDateRange/${customerId}/${this.dateFrom}/${this.dateTo}`
        );
        // Example response: [{ year: 1978, month: 3, totalAmount: 220.11 }, ...]
        this.chartLabels = response.data.map(
          item => `${item.year}-${String(item.month).padStart(2, '0')}`
        );
        this.chartData = response.data.map(item => item.totalAmount);
        this.renderChart();
      } catch (error) {
        console.error(error);
      }
    },
    renderChart() {
      if (this.chart) this.chart.destroy();
      const ctx = this.$refs.barChart.getContext('2d');
      this.chart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: this.chartLabels,
          datasets: [{
            label: 'Monthly Expenses',
            data: this.chartData,
            backgroundColor: 'rgba(54, 162, 235, 0.6)',
          }]
        },
        options: {
          responsive: true,
          maintainAspectRatio: true,
          scales: {
            y: { beginAtZero: true }
          }
        }
      });
    }
  }
};
</script>


<style scoped>
.chart-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: #fff;
  padding: 2rem;
  box-sizing: border-box;
  z-index: 1000;
}
.chart-container canvas {
  width: 100% !important;
  height: 80vh !important;
  display: block;
}
</style>