<template>
  <el-divider />
  <h3>窗口挂号</h3>
  <el-divider />
  <el-button type="primary" @click="addRegister">挂号</el-button>
  <el-button type="primary" @click="clear">清空</el-button>
  <!-- 基本信息 -->
  <el-descriptions class="margin-top" title="基本信息" :column="3" border>
    <!-- 病例号 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <user />
          </el-icon>
          病历号
        </div>
      </template>
      <el-input v-model="register.caseNumber" style="width: 240px" placeholder="请输入" disabled="true" />
    </el-descriptions-item>
    <!-- 姓名框 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <user />
          </el-icon>
          姓名
        </div>
      </template>
      <el-input v-model="register.realName" style="width: 240px" placeholder="请输入姓名" />
    </el-descriptions-item>
    <!-- 性别 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          性别
        </div>
      </template>
      <el-select v-model="register.gender" placeholder="请选择" style="width: 240px">
        <el-option v-for="gender in genderList" key="gender" :key="gender.value" :label="gender.label"
          :value="gender.value" />
      </el-select>
    </el-descriptions-item>
    <!-- 年龄 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <Calendar />
          </el-icon>
          年龄
        </div>
      </template>
      <!-- 数字 -->
      <el-input v-model="register.age" style="width: 120px" placeholder="0" />
      <!-- 年 岁 -->
      <el-select v-model="register.ageType" placeholder="请选择" style="width: 120px">
        <el-option v-for="ageType in ageTypeList" key="ageType" :key="ageType.value" :value="ageType.value"
          :label="ageType.label" />
      </el-select>
      <el-descriptions-item>
      </el-descriptions-item>
    </el-descriptions-item>
    <!-- 出生日期 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <Calendar />
          </el-icon>
          出生日期
        </div>
      </template>
      <div class="demo-date-picker">
        <el-date-picker v-model="register.birthday" type="date" placeholder="请选择日期" :size="size" style="width: 240px;"
          key="birthday" />
      </div>
    </el-descriptions-item>
    <!-- 身份证号 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <iphone />
          </el-icon>
          身份证号
        </div>
      </template>
      <el-input v-model="register.cardNumber" style="width: 240px" placeholder="请输入身份证号" maxlength="18" />
    </el-descriptions-item>
    <!-- 地址 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          地址
        </div>
      </template>
      <el-input v-model="register.homeAddress" placeholder="请输入地址" maxlength="64" />
    </el-descriptions-item>
  </el-descriptions>

  <!-- 挂号信息 -->
  <el-descriptions class="margin-top" title="基本信息" :column="3" border>
    <!-- 结算类型 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <tickets />
          </el-icon>
          结算类型
        </div>
      </template>
      <el-select v-model="register.settleCategoryId" placeholder="请选择" style="width: 240px" key="chargeCategory">
        <el-option v-for="item in settleList" :key="item.id" :label="item.settleName" :value="item.id" />
      </el-select>
    </el-descriptions-item>
    <!-- 看诊日期 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <Calendar />
          </el-icon>
          看诊日期
        </div>
      </template>
      <div class="demo-date-picker">
        <el-date-picker v-model="register.visitDate" type="date" placeholder="Pick a day" :size="size"
          disabled="true" />
      </div>
    </el-descriptions-item>
    <!-- 午别 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          午别
        </div>
      </template>
      <el-select v-model="register.noon" placeholder="请选择" style="width: 240px" disabled>
      </el-select>
    </el-descriptions-item>
    <!-- 挂号科室 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          挂号科室
        </div>
      </template>
      <el-select v-model="register.deptmentId" placeholder="请选择" @change="getWorkEmp" style="width: 240px" key="dept">
        <el-option v-for="dept in deptList" :key="dept.id" :label="dept.deptName" :value="dept.id" />
      </el-select>
    </el-descriptions-item>
    <!-- 号别 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          号别
        </div>
      </template>
      <el-select v-model="register.registLevelId" placeholder="请选择" style="width: 240px" @change="getWorkEmp"
        key="numberLevel">
        <el-option v-for="registLevel in registLevelList" :key="registLevel.id" :label="registLevel.registName"
          :value="registLevel.id" />
      </el-select>
    </el-descriptions-item>
    <!-- 看诊医生 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          看诊医生
        </div>
      </template>
      <el-select v-model="register.employeeId" placeholder="请选择" style="width: 240px" key="doctor">
        <el-option v-for="emp in empList" :key="emp.realname" :label="emp.realname" :value="emp.id" />
      </el-select>
    </el-descriptions-item>
    <!-- 初始号额 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <user />
          </el-icon>
          初始号额
        </div>
      </template>
      <el-input v-model="quota" style="width: 240px" placeholder="请输入" disabled />
    </el-descriptions-item>
    <!-- 已用号额 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <user />
          </el-icon>
          已用号额
        </div>
      </template>
      <el-input v-model="usedQuota" style="width: 240px" placeholder="请输入" disabled />
    </el-descriptions-item>
    <!-- 病历本： -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <iphone />
          </el-icon>
          病历本
        </div>
      </template>
      <el-switch v-model="register.isBook" @change="changeMedicalrecords" />
    </el-descriptions-item>
    <!-- 应收金额 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <tickets />
          </el-icon>
          应收金额
        </div>
      </template>
      <el-input v-model="register.registMoney" style="width: 240px" placeholder="请输入" disabled />
    </el-descriptions-item>
    <!-- 收费方式 -->
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <money />
          </el-icon>
          收费方式
        </div>
      </template>
      <el-select v-model="register.registMethod" key="charge" placeholder="请选择" style="width: 240px">
        <el-option v-for="charge in chargeList" :key="charge.value" :value="charge.value" :label="charge.lable" />
      </el-select>
    </el-descriptions-item>
  </el-descriptions>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { ElMessage } from 'element-plus';

let deptList = ref([])          //员工对象列表
let settleList = ref([])        //挂号级别列表
let registLevelList = ref([])   //号别对象列表
let empList = ref([])           //看诊医生
let quota = ref()               //初始号额
let usedQuota = ref(0)          //已用号额
let chargeManner = ref()        //收费方式

//接收挂号信息的对象
let register = ref({
  caseNumber: '',
  realName: '',
  gender: '',
  cardNumber: '',
  birthday: '',
  age: '',
  ageType: '',
  homeAddress: '',
  visitDate: '',
  noon: '',
  deptmentId: '',
  employeeId: '',
  registLevelId: '',
  settleCategoryId: '',
  isBook: false,
  registMethod: '',
  registMoney: 0
})

// 清空所有
const clear = () => {
  register.value.caseNumber = '',
    register.value.realName = '',
    register.value.gender = '',
    register.value.cardNumber = '',
    register.value.birthday = '',
    register.value.age = '',
    register.value.ageType = '',
    register.value.homeAddress = '',
    register.value.visitDate = '',
    register.value.noon = '',
    register.value.deptmentId = '',
    register.value.employeeId = '',
    register.value.registLevelId = '',
    register.value.settleCategoryId = '',
    register.value.isBook = false,
    register.value.registMethod = '',
    register.value.registMoney = 0
}
import { findAllDepartmentService, findAllSettleNameService, findAllRegistLevelService, findMaxCaseNumberService } from '@/apis/rejistration';
// 挂载完成时自动向服务器发发送请求
onMounted(async () => {
  let result1 = await findAllDepartmentService();
  deptList.value = result1.data;
  let result2 = await findAllSettleNameService();
  settleList.value = result2.data
  let result3 = await findAllRegistLevelService();
  registLevelList.value = result3.data;
  let result4 = await findMaxCaseNumberService();
  register.value.caseNumber = result4.data;

  //显示看诊日期和午别
  let date = new Date();
  register.value.visitDate = date;
  let hours = date.getHours();
  register.value.noon = hours < 12 ? "上午" : "下午";

})

import { findAllDutyEmployeeService } from '@/apis/rejistration';
// 挂号类别改变 修改对应信息
const getWorkEmp = async () => {
  if (register.value.deptmentId) {
    // 只发送日期
    const dateTime = register.value.visitDate.toISOString().slice(0, 10)
    // const dateTime = register.value.visitDate.toISOString().slice(0, 10)
    // 发送请求获取所有在职医生的信息
    let result = await findAllDutyEmployeeService(register.value.deptmentId, register.value.registLevelId, dateTime, register.value.noon);
    empList.value = result.data;
  }
  // 获取对应号额和付费金额
  const registLevel = registLevelList.value.find((item) => register.value.registLevelId == item.id)
  quota.value = registLevel.registQuota
  register.value.registMoney = registLevel.registFee
  if (register.value.isBook) {
    register.value.registMoney += 1
  }
}

//选择病历本
function changeMedicalrecords() {
  if (register.value.isBook) {
    register.value.registMoney += 1
  } else {
    register.value.registMoney -= 1
  }
}

// 添加患者挂号信息
import { addRegisterService } from '@/apis/rejistration';
const addRegister = async () => {
  if (register.value.realName != '' && register.value.age != '' && register.value.birthday != '' && register.value.cardNumber != ''
    && register.value.homeAddress != '' && register.value.settleCategoryId != '' && register.value.deptmentId != '' && register.value.registLevelId != ''
    && register.value.employeeId != '' && register.value.registMethod != '') {
    let result = await addRegisterService(register.value);
    if (result.code === 200) {
      ElMessage.success("挂号成功");
      location.reload(true)
    }
  }
  else {
    ElMessage.error("请填写完整信息")
  }
}


// 性别选项
let genderList = ref([
  {
    value: "男",
    label: "男",
  },
  {
    value: "女",
    label: "女",
  },
]);

let ageTypeList = ref([
  {
    value: "岁",
    label: "岁",
  },
  {
    value: "天",
    label: "天",
  },
]);

// 收费方式
let chargeList = ref([
  {
    lable: "银行卡",
    value: "银行卡"
  },
  {
    lable: "医保卡",
    value: "医保卡"
  },
  {
    lable: "现金",
    value: "现金"
  },
  {
    lable: "微信",
    value: "微信"
  },
  {
    lable: "支付宝",
    value: "支付宝"
  },
])

</script>
<!-- =====================js结尾=========================== -->


<style scoped>
.margin-top {
  margin-top: 20px;
}
</style>