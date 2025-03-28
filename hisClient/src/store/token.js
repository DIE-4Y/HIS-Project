import { defineStore } from "pinia";
import { ref } from "vue";

export const useTokenStore = defineStore('token', () => {
    // 定义状态内容
    const token = ref('');
    const setToken = (newToken) => {
        token.value = newToken;
    }
    const removeToken = () => {
        token.value = '';
    }
    return { token, setToken, removeToken };
}, {
    persist: true //持久化存储
})