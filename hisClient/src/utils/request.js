//导入axios
import axios from 'axios';
import { ElMessage } from 'element-plus';
import { useRouter } from "vue-router";

//定义公共前缀 自动拼接 不用再使用axios
// const baseURL = 'http://localhost:8080';
const baseURL = '/api';
const instance = axios.create({ baseURL });
const router = useRouter();
import { useTokenStore } from '@/store/token.js'
// 请求拦截器
instance.interceptors.request.use(
    (config) => {
        // 添加token
        const tokenStore = useTokenStore();
        // 判断是否有token
        if (tokenStore.token) {
            config.headers.Token  = tokenStore.token;
        }
        return config;
    },
    (err) => {
        //请求错误的回调
        Promise.reject(err);
    }
)
//响应拦截器 本身为异步
instance.interceptors.response.use(
    result => {
        if (result.data.code === 200) {
            return result.data;
        }
        //失败操作
        ElMessage.error(result.data.msg ? result.data.msg : '服务异常')
        //异步转为失败
        return Promise.reject(result.data)
    },
    err => {
        ElMessage.error(err.data.msg ? err.data.msg : '服务异常')
        return Promise.reject(err); //失败请求转化成异常被捕获
    }
)
export default instance;