<script setup>
import { onMounted, ref } from 'vue';
import { ElMessage } from 'element-plus';
import { getAllMedicalTechnologyService, updateCheckRequestService } from '@/apis/rejistration.js';


const totalFee = ref(0) //总的费用
const medicalTechnology = ref([]);  //未交费医疗项目
const patientInfo = ref({ //前端搜索病人信息
    caseNumber: '',
    realName: '',
    cardNumber: '',
    age: '',
    gender: ''
});

const registerInfo = ref([]) // 后端传来的病人信息

onMounted(()=>{
    getAllMedicalTechnology()
})

// 获取所有未交费项目
const getAllMedicalTechnology = async () => {
    let result = await getAllMedicalTechnologyService(patientInfo.value.caseNumber, patientInfo.value.realName)
    if (result.code === 400) {
        ElMessage.error("没有需要缴费的信息")
    } else {
        patientInfo.value.realName = result.data[0].realName
        patientInfo.value.cardNumber = result.data[0].cardNumber
        patientInfo.value.cardNumber = result.data[0].cardNumber
        patientInfo.value.age = result.data[0].age
        patientInfo.value.gender = result.data[0].gender
        registerInfo.value = result.data
    }
}

// 计算所有选中金额
const calculateSelectedFee = () => {
    const total = registerInfo.value.reduce((total, item) => {
        return total + (item.selected ? item.techPrice : 0);
    }, 0);
    totalFee.value = total;
}


// 缴费结算
const updateCheckRequest = async () => {
    console.log(registerInfo.value)
    const checkRequestIdList = registerInfo.value.filter(item => item.selected).map(item => item.checkRequestId);
    console.log(checkRequestIdList)
    let result = await updateCheckRequestService(checkRequestIdList);
    registerInfo.value = registerInfo.value.filter(item => !checkRequestIdList.includes(item.checkRequestId));
    calculateSelectedFee()
    if (result.code === 400) {
        ElMessage.error(result.msg || "未知错误");
    }
}

</script>



<template>
    <el-divider />
    <h3>窗口收费</h3>
    <el-divider />
    <div>
        <div>
            <span>
                <el-icon>
                    <tickets />
                </el-icon>病历号
            </span>
            <el-input style="width: 20%; margin-right: 2%" v-model="patientInfo.caseNumber"
                placeholder="请输入病历号"></el-input>
            <span>
                <el-icon>
                    <User />
                </el-icon>患者名
            </span>
            <el-input style="width: 20%; margin-right: 2%;" v-model="patientInfo.realName"
                placeholder="请输入患者名"></el-input>
            <el-button type="primary" @click="getAllMedicalTechnology">搜索</el-button>
        </div>
        <el-divider />
        <!-- 患者信息确认 -->
        <div>
            <h3 style="margin-bottom: 1%;">患者信息确认</h3>
            <el-tag size="large">患者名：{{ patientInfo.realName }}</el-tag>
            <el-tag size="large">身份证号：{{ patientInfo.cardNumber }}</el-tag>
            <el-tag size="large">年龄：{{ patientInfo.age }}</el-tag>
            <el-tag size="large">性别：{{ patientInfo.gender }}</el-tag>
        </div>
        <div style="margin-top: 1%;">
            <el-tag
                style="font-size: 16px; width: 10%; padding: 1.2%; border: 1px solid #dcdf; border-radius: 8px; background-color: #409EFF; color: white">项目金额：{{
                    totalFee }}</el-tag>
            <el-button type="primary" @click="updateCheckRequest">收费结算</el-button>
        </div>

        <!-- 项目列表 -->
        <el-table :data="registerInfo" style="width: 100%">
            <el-table-column label="选择" width="80">
                <template #default="scope">
                    <el-checkbox v-model="scope.row.selected" @change="calculateSelectedFee"></el-checkbox>
                </template>
            </el-table-column>
            <el-table-column label="项目名称" prop="techName"></el-table-column>
            <el-table-column label="单价" prop="techPrice"></el-table-column>
            <el-table-column label="类型" prop="techType"></el-table-column>
            <el-table-column label="规格" prop="techFormat"></el-table-column>
            <el-table-column label="数量" prop="number"></el-table-column>
            <el-table-column label="开立时间" prop="creationTime"></el-table-column>
        </el-table>

    </div>
</template>

<style scoped>
.el-tag {
    margin-right: 10px;
}
</style>