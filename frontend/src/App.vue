<template>
  <router-view />
</template>


<script setup>
import HelloWorld from './components/HelloWorld.vue'
import Login from "./components/Login.vue"
import Management from "./components/Management.vue";

</script>


<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}

/* 全局样式 */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Segoe UI', sans-serif;
  background: linear-gradient(120deg, #1e3c72, #2a5298);
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}
</style>
