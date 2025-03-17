<script setup>
import { onMounted, ref } from 'vue';
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../common'
import { getAllCheckedCountService, getAllPeopleInLineService, findByCaseNumberAndNameService } from '@/apis/check.js';
import { useRouter } from "vue-router";

//获得路由对象
let router = useRouter();
const checkedCount = ref(0) // 已看诊人数
const inLineCount = ref(0)  // 待看诊人数
const peopleInLine = ref([])// 待看诊人员
const emp = ref({})       // 员工信息
const registerInfo = ref({
  'caseNumber': '',
  'name': ''
})

onMounted(() => {
  emp.value = getLocalStorage('emp')
  getAllCheckedCount()
  getAllPeopleInLine()
})

// 获取所有已看诊人数
const getAllCheckedCount = async () => {
  let result = await getAllCheckedCountService()
  checkedCount.value = result.data
}

// 获取所有待看诊人数和人员
const getAllPeopleInLine = async () => {
  let result = await getAllPeopleInLineService()
  inLineCount.value = result.data.total
  peopleInLine.value = result.data.rows
}

// 模糊查询获取所有待看诊人员
const findByCaseNumberAndName = async () => {
  let state="已缴费"
  let result = await findByCaseNumberAndNameService(registerInfo.value.caseNumber, registerInfo.value.name, state)
  peopleInLine.value = result.data
}

// 表单选项
const handleEdit = (index, row, action) => {
  if (action === 'check') {
    setLocalStorage('register', row)
    router.push('/check_patient')
  }
  if (action === 'skip') {
  }
  if (action === 'call') {
  }
}

</script>

<template>
  <div>
    <el-tag class="ml-2" color="#adf">
      今日已检查{{ checkedCount }}人
    </el-tag>
    <el-tag class="ml-2" color="#fda">
      当前有{{ inLineCount }}人在排队
    </el-tag>
  </div>
  <div>
    <el-divider />
    检查申请
    <el-divider />
  </div>
  <div>
    <span>
      <el-icon>
        <tickets />
      </el-icon>病历号
    </span>
    <el-input v-model="registerInfo.caseNumber" style="width: 20%; margin-right: 2%" placeholder="请输入病历号"></el-input>
    <span>
      <el-icon>
        <User />
      </el-icon>患者名
    </span>
    <el-input v-model="registerInfo.name" style="width: 20%; margin-right: 2%;" placeholder="请输入患者名"></el-input>
    <el-button type="primary" @click="findByCaseNumberAndName">搜索</el-button>
    <el-divider />
  </div>
  <div>
    <el-table :data="peopleInLine" style="width: 100%">
      <el-table-column label="编号" prop=auto>
        <template #default="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="姓名" prop="realName"></el-table-column>
      <el-table-column label="患者病历号" prop="caseNumber"></el-table-column>
      <el-table-column align="right" label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'check')">进行检查</el-button>
          <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'skip')">跳过</el-button>
          <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'call')">叫号</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped></style>