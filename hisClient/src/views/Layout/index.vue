<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { getLocalStorage, removeLocalStorage } from '../../common'

//获得路由对象
let router = useRouter();
//获得menu数组
const menuList = ref([]);
const emp = getLocalStorage("emp") || {};

//在页面初始化时，加载menuList数据
onMounted(() => {
  if (emp != null) {
    menuList.value = emp.permitList;
  }
})

//退出
import { useTokenStore } from '@/store/token.js'
const logout = () => {
  //删除登录用户的信息
  removeLocalStorage("emp");
  const tokenStore = useTokenStore();
  removeLocalStorage("register")
  router.push("/login")
}
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div class="header-left">
          <h3>东软云医院HIS系统</h3>
        </div>
        <div class="header-right">
          <img src="/logo.png" />
          <el-dropdown>
            <span class="el-dropdown-link">
              {{ emp.realname }}
              <el-icon class="el-icon--right">
                <arrow-down />
              </el-icon>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu :default-active="1" class="el-menu-demo" :unique-opened="true" :router="true">
            <el-sub-menu :index="index" v-for="menu, index in menuList" :key="index" v-show="!menu.hidden">
              <template #title>
                <el-icon>
                  <component :is="menu.permitIcon"></component>
                </el-icon>
                {{ menu.permitName }}
              </template>
              <el-menu-item :index="child.permitPath" v-for="child, index in menu.children" :key="index">{{
                child.permitName
                }}</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.el-header {
  background-color: #409eff;

  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #fff;
}

.header-left {
  margin-left: 50px;
}

.header-right {
  margin-right: 50px;
  display: flex;
  align-items: center;
}

.el-container {
  height: 700px;
}

.el-aside {
  background-color: #eee;
}

.el-dropdown-link {
  color: #fff;
  margin-left: 50px;
  outline: none;
}
</style>
