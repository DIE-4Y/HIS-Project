<template>
    <div class="login-outer">
        <el-form status-icon :rules="rules" label-width="auto" class="login-form">
            <h2 class="login-title">登录</h2>
            <el-form-item label="用户名">
                <el-input v-model="loginInform.realname" type="" prefix-icon="User" autocomplete="off" />
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginInform.password" type="password" prefix-icon="Lock" autocomplete="off" />
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="login">登录</el-button>
                <el-button type="info" @click="clear">重置</el-button>

            </el-form-item>
            <div style="display: flex; justify-content: flex-end;">
                <el-button type="success">注册</el-button>
            </div>
        </el-form>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { ElMessage } from 'element-plus';
import { useRouter } from 'vue-router';
import { setLocalStorage } from '../../common'
const router = useRouter();

// 员工信息
const loginInform = ref({
    realname: '',
    password: '',
})

// 实现登录功能
import { useTokenStore } from '@/store/token.js'
import { empLoginService } from '@/apis/rejistration.js'
const tokenStore = useTokenStore();
const login = async () => {
    let result = await empLoginService(loginInform.value)
    //把登录用户的信息存储到LocalStroage
    setLocalStorage('emp', result.data)
    tokenStore.setToken(result.data.token);
    console.log(tokenStore.token);
    ElMessage.success('登录成功')
    router.push('/');
}

// 重置功能
const clear = () => {
    emp.value.realname = '',
        emp.value.password = ''
}

</script>

<style scoped>
.login-outer {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    /* 水平居中 */
    align-items: center;
    /* 垂直居中 */
}

.login-title {
    height: 130px;
    line-height: 130px;
    font-size: 32px;
    font-weight: 800;
    text-align: center;
    animation-delay: 0.3s;
    color: red;
}

.login-form {
    background-color: #f0f0f0;
    width: 600px;
    height: 400px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    box-sizing: border-box;
    /* 保证 padding 不影响盒子大小 */
}
</style>