<template>
  <div id="app">
    <Interview/>
  </div>
</template>

<script>
import Interview from './components/Interview.vue'

export default {
  name: 'app',
  components: {
    Interview
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
