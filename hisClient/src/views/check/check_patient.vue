<script setup>
import { onMounted, ref } from 'vue';
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../common'
import { findMedicalTechnologyByCaseNumberService, getAllEmpByTypeService, getAllDeptByTypeService, startCheckService, getAllEmpByDeptIdService } from '@/apis/check.js';
import { ElMessage } from 'element-plus';

const register = ref({}) //检查病人信息
const items = ref([]) //检验项目
const selectedItems = ref([]); // 已选择的检查项目名称
const deptType = ref("检查")
const empList = ref([]) // 员工列表
const deptList = ref([])// 部门列表
// 部门信息
const deptInfo = ref({
  "id": null,
  "deptCode": "",
  "deptName": "",
  "deptType": "",
  "delmark": null
})
// 员工信息
const empInfo = ref({
  "id": null,
  "realname": "",
  "password": "",
  "deptmentId": null,
  "registLevelId": null,
  "schedulingId": null,
  "delmark": null,
  "role": null,
  "permitList": null,
  "token": null
})

onMounted(() => {
  register.value = getLocalStorage('register')
  findMedicalTechnologyByCaseNumber()
  getAllEmpByType()
  getAllDeptByType()
})

// 根据部门类型获取所有员工
const getAllEmpByType = async () => {
  let result = await getAllEmpByTypeService(deptType.value)
  empList.value = result.data
}

// 根据部门类型获取所有部门
const getAllDeptByType = async () => {
  let result = await getAllDeptByTypeService(deptType.value)
  deptList.value = result.data
}

// 根据部门id获取所对应的员工
const getAllEmpByDeptId = async () => {
  console.log(deptInfo.value)
  let result = await getAllEmpByDeptIdService(deptInfo.value.id)
  empList.value = result.data
}

// 获取检验项目
const findMedicalTechnologyByCaseNumber = async () => {
  let result = await findMedicalTechnologyByCaseNumberService(register.value.caseNumber)
  items.value = result.data
}

// 开始检查按钮
const startCheck = async () => {
  const startCheckSubmit = {
    registerId: register.value.id,
    deptId: empInfo.value.id,
    empId: empInfo.value.id,
    medicalTechnologyIdList: selectedItems.value.map(item => item.id)
  }
  let result = await startCheckService(startCheckSubmit)
  if (result.code === 200) {
    ElMessage.success("开始检查")
  }
}

// 处理表格行点击事件
const handleRowClick = (row) => {
  // 检查是否已经选择过该项目
  const index = selectedItems.value.findIndex((item) => item.techName === row.techName);
  if (index === -1) {
    // 如果未选择过，添加到已选择列表
    selectedItems.value.push(row);
  } else {
    // 如果已经选择过，从列表中移除
    selectedItems.value.splice(index, 1);
  }
};

// 重置医生
const clearEmp = () => {
  empInfo.value.id = null,
  empInfo.value.realname = "",
  empInfo.value.password = "",
  empInfo.value.deptmentId = null,
  empInfo.value.registLevelId = null,
  empInfo.value.schedulingId = null,
  empInfo.value.delmark = null,
  empInfo.value.role = null,
  empInfo.value.permitList = null,
  empInfo.value.token = null
}
</script>


<template>
  <div>
    <span>患者信息</span>
    <el-tag class="ml-2" color="#adf">
      姓名：{{ register.realName }}
    </el-tag>
    <el-tag class="ml-2" color="#adf">
      病历号：{{ register.caseNumber }}
    </el-tag>
    <el-tag class="ml-2" color="#adf">
      年龄：{{ register.age }}
    </el-tag>
    <el-tag class="ml-2" color="#adf">
      性别：{{ register.gender }}
    </el-tag>
  </div>
  <div>
    <el-divider />
    <h3>患者录入</h3>
    <el-divider />
  </div>
  <div>
    <el-table :data="items" style="width: 100%" @row-click="handleRowClick">
      <el-table-column label="编号" prop=auto>
        <template #default="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="检查编码" prop="techCode"></el-table-column>
      <el-table-column label="检查名称" prop="techName"></el-table-column>
      <el-table-column label="检查规格" prop="techFormat"></el-table-column>
      <el-table-column label="单价" prop="techPrice"></el-table-column>
      <el-table-column label="费用分类" prop="priceType"></el-table-column>
    </el-table>
  </div>
  <div style="margin-top: 2%;">
    <h6>已选择的检查项目：</h6>
    <ul>
      <li v-for="item in selectedItems" :key="item.techName">
        {{ item.techName }}
      </li>
    </ul>
    <el-divider />
  </div>
  <div style="margin-top: 2%;">
    <div>
      <span>
        <h3>确认检查科室和检查医生</h3>
      </span>
    </div style="margin-bottom: 2%">
    <el-descriptions class="margin-top" border>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <location />
            </el-icon>
            科室选择
          </div>
        </template>
        <el-select v-model="deptInfo.id" placeholder="请选择" style="width: 240px" key="deptList"
          @change="getAllEmpByDeptId">
          <el-option v-for="dept in deptList" :key="dept.id" :value="dept.id" :label="dept.deptName" />
        </el-select>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <User />
            </el-icon>
            医生选择
          </div>
        </template>
        <el-select v-model="empInfo.id" placeholder="请选择" style="width: 240px" key="empList">
          <el-option v-for="emp in empList" :key="emp.realname" :label="emp.realname" :value="emp.id" />
        </el-select>
      </el-descriptions-item>
    </el-descriptions>
  </div style="margin-bottom: 2%">
  <div>
    <el-button type="primary" @click="startCheck">开始检查</el-button>
    <el-button type="primary" @click="clearEmp">重置医生</el-button>
  </div>

</template>

<style scoped></style>