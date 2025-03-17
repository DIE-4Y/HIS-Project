import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

import path from 'path';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'), // 设置 @ 指向 src 目录
    },
  },
  server: { //请求代理
    proxy: {
      '/api': {// 获取路径中包含/api的请求
        target: 'http://localhost:8080', // 目标地址
        changeOrigin: true,
        rewrite: (path => path.replace(/^\/api/, '')), // 请求路径更换
      }
    }
  }
});
