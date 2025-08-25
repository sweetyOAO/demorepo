import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3000,
    host: true
  },
  base: './', // 相对路径
  build: {
    outDir: '../cordova/www', // 构建输出到Cordova的www目录
    emptyOutDir: true
  },
  resolve: {
    alias: {
      '@': '/src'
    }
  }
})
