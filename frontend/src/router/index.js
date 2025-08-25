// src/router/index.js
import { createRouter, createWebHashHistory } from 'vue-router'; // Vue 3
// 或 import VueRouter from 'vue-router'; // Vue 2
import LoginView from '../components/Login.vue'
import Management from "../components/Management.vue";

const routes = [
        { path: '/', component: LoginView },  // 直接用 LoginView 作为首页
        { path: '/login', component: LoginView },
        { path: '/management', component: Management }
    ]
;

// Vue 3 配置
const router = createRouter({
    history: createWebHashHistory(),
    routes
});

export default router;