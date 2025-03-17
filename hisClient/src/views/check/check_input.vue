<script setup>
import { onMounted, ref } from 'vue';
import { getAllMedicalTechnologyService, findByCaseNumberAndNameService, getAllEmpByDeptIdService, getAllDeptByTypeService, getAllEmpByTypeService, updateInputCheckService } from '@/apis/check.js';
import { ElMessage } from 'element-plus';

const deptType = ref("检查")
const registerList = ref([]) //已检查人员列表
const medicalTechnologyList = ref([]) //选中人员已检查项目列表
const empList = ref([]) // 员工列表
const deptList = ref([])// 部门列表
const selectedItems = ref([]) // 已选择的检查项目名称
const checkResult = ref('') // 检查结果
const total = ref(0)

// 患者信息分页查询
const pageInfo = ref({
  caseNumber: null,
  realName: '',
  pageNumber: 1,
  pageSize: 5,
})

// 选中病人信息
const registerInfo = ref({})
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

// 病人查询信息
const searchInfo = ref({
  caseNumber: '',
  realname: ''
})

onMounted(() => {
  showPage()
  getAllEmpByType()
  getAllDeptByType()
})

// 模糊查询病人信息
const showPage = async () => {
  let result = await findByCaseNumberAndNameService(pageInfo.value.caseNumber, pageInfo.value.realName, pageInfo.value.pageSize, pageInfo.value.pageNumber, "执行完成")
  total.value = result.data.total
  registerList.value = result.data.rows
}

// 表单选项
const handleEdit = async (index, row) => {
  let result = await getAllMedicalTechnologyService(row.caseNumber, row.realName)
  if (result.code === 200) {
    registerInfo.value = row
    medicalTechnologyList.value = result.data
    selectedItems.value = []
  }
}

// 已选择项目
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
  let result = await getAllEmpByDeptIdService(deptInfo.value.id)
  empList.value = result.data
}

// 修改检查结果
const updateInputCheck = async () => {
  let medicalTechnologyIdList = selectedItems.value.map(item => item.id)
  let result = await updateInputCheckService(registerInfo.value.id, empInfo.value.id, medicalTechnologyIdList, checkResult.value)
  if (result.code === 200) {
    ElMessage.success("提交成功")
    location.reload(true)
  }
}

// 重置输入
const clearInput = () => {
  checkResult.value = ''
}
</script>

<template>
  <div>
    <h3>检查结果录入</h3>
    <el-divider />
  </div>
  <div>
    <span>
      <el-icon>
        <tickets />
      </el-icon>病历号
    </span>
    <el-input v-model="pageInfo.caseNumber" style="width: 20%; margin-right: 2%" placeholder="请输入病历号"></el-input>
    <span>
      <el-icon>
        <User />
      </el-icon>患者名
    </span>
    <el-input v-model="pageInfo.realName" style="width: 20%; margin-right: 2%;" placeholder="请输入患者名"></el-input>
    <el-button type="primary" @click="showPage">搜索</el-button>
    <el-divider />
  </div>
  <div class="demo-pagination-block">
    <el-table :data="registerList" style="width: 100%" @row-click="handleRowClick">
      <el-table-column label="编号" prop=auto>
        <template #default="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="患者姓名" prop="realName"></el-table-column>
      <el-table-column label="患者病历号" prop="caseNumber"></el-table-column>
      <el-table-column label="患者年龄" prop="age"></el-table-column>
      <el-table-column label="患者性别" prop="gender"></el-table-column>
      <el-table-column align="right">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'check')">已完成检查</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination v-model:current-page="pageInfo.pageNumber" v-model:page-size="pageInfo.pageSize" :disabled="disabled"
      :background="background" :page-sizes="[3, 5, 10, 20, 40]" layout="total, sizes, prev, pager, next, jumper"
      :total="total" @current-change="showPage" @change="showPage" />
  </div>
  <div>
    <el-divider />
    <el-table :data="medicalTechnologyList" style="width: 100%" @row-click="handleRowClick">
      <el-table-column label="编号" prop=auto>
        <template #default="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="检查编码" prop="techCode"></el-table-column>
      <el-table-column label="检查名称" prop="techName"></el-table-column>
      <el-table-column label="检查时间" prop="techFormat"></el-table-column>
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
    <el-descriptions class="margin-top" column="2" border>
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
    <div>
      <span>
        <h3>输入检查结果</h3>
      </span>
    </div style="margin-bottom: 2%">
    <el-descriptions class="margin-top" column="1" border>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            检查结果
          </div>
        </template>
        <el-input v-model="checkResult" :rows="2" type="textarea" placeholder="请输入检查结果" />
      </el-descriptions-item>
    </el-descriptions>
  </div>
  <div>
    <el-button type="primary" @click="updateInputCheck">结果提交</el-button>
    <el-button type="primary" @click="clearInput">重置输入</el-button>
  </div>
</template>

<style scoped></style>