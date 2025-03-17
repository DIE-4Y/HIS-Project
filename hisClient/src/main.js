import { createApp } from 'vue';
import App from './App.vue';
import './style.css'
import { locale } from 'element-plus/dist/locale/zh-cn.js'

// 导入 router
import router from './router';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import { createPinia } from 'pinia';
import {createPersistedState} from 'pinia-persistedstate-plugin';
const app = createApp(App);
// 应用emlementplus
app.use(ElementPlus, { locale });
// 使用 router
app.use(router);
// 挂载
app.mount('#app');
// 使用持久化插件
const persist = createPersistedState();
// 使用pinia
const pinia = createPinia();
pinia.use(persist);
app.use(pinia);
// 加载Element图标库
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}