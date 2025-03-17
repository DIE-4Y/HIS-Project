<script setup>
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common';
import { onMounted, ref } from 'vue';
import { updateDiagnosisAndCureService } from '@/apis/physician'
import { ElMessage } from 'element-plus';

const register = ref({}) // 病人信息
const outputInfo = ref({
  diagnosis: '',    // 诊断结果
  cure: ''          // 处理意见
})

onMounted(() => {
  register.value = getLocalStorage('register')
})

// 确认提交
const submitConfirm = async () => {
  let medicalRecord = {
    registerId: register.value.id,
    diagnosis: outputInfo.value.diagnosis,
    cure: outputInfo.value.cure
  }
  let result = await updateDiagnosisAndCureService(medicalRecord)
  if (result.code === 200) {
    console.log(medicalRecord)
    ElMessage.success("提交成功")
    location.reload(true)
  }
}

// 重置输入
const clearInput = () => {
  outputInfo.value.diagnosis = ''
  outputInfo.value.cure = ''
}
</script>

<template>
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
  <div>
    <el-divider />
    <h3>门诊确诊</h3>
    <el-divider />
  </div>
  <div>
    <h4 style="margin-bottom: 2%;">确诊结果输入</h4>
    <el-form :model="outputInfo" label-width="120px">
      <el-form-item label="诊断结果">
        <el-input v-model="outputInfo.diagnosis" :rows="2" type="textarea" placeholder="请输入诊断结果" />
      </el-form-item>

      <el-form-item label="处理意见">
        <el-input v-model="outputInfo.cure" :rows="2" type="textarea" placeholder="请输入处理意见" />
      </el-form-item>
    </el-form>
  </div>
  <div>
    <el-button type="primary" @click="submitConfirm">确认提交</el-button>
    <el-button type="primary" @click="clearInput">重置输入</el-button>
  </div>
</template>

<style scoped></style>