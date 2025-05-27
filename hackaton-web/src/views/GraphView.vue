<template>
  <div class="graph-view">
    <h1>Graph View</h1>
    <Graph />
  </div>
</template>

<script>
import Graph from '../components/Graph.vue';

export default {
  name: 'GraphView',
  components: {
    Graph
  }
};
</script>

<style scoped>
.graph-view {
  padding: 20px;
}
</style>