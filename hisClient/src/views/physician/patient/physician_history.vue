<script setup>
import { onMounted, ref } from 'vue';
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common'
import { getAllRegisterService } from '@/apis/physician.js'
import { useRouter } from "vue-router";

const registerList = ref([])// 病人信息列表
const emp = ref({})// 医生信息
const total = ref(0)// 已接诊状态的总人数
// 分页信息
const pageInfo = ref({
    caseNumber: '',
    realName: '',
    pageNumber: 1,
    pageSize: 5
})

onMounted(() => {
    emp.value = getLocalStorage('emp')
    getAllRegister()
})

// 获取所有状态为已接诊人员的病人
const getAllRegister = async () => {
    let result = await getAllRegisterService(emp.value.id, pageInfo.value.pageNumber, pageInfo.value.pageSize, pageInfo.value.caseNumber, pageInfo.value.realName)
    if (result.code === 200) {
        total.value = result.data.total
        registerList.value = result.data.rows
    }
}

// 更新病历表
let router = useRouter();
const handleEdit = (index, row, action) => {
    if (action === 'update') {
        setLocalStorage('register', row)
        router.push('/check_results');
    }

}
</script>

<template>
    <div>
        <el-divider />
        <h3>在诊患者</h3>
        <el-divider />
    </div>
    <div>
        <el-input v-model="pageInfo.caseNumber" placeholder="请输入患者病历号"
            style="width: 200px;margin-right: 20px;"></el-input>
        <el-input v-model="pageInfo.realName" placeholder="请输入患者姓名"
            style="width: 200px; margin-right: 20px;"></el-input>
        <el-button type="primary" @click="showPage">查询</el-button>
    </div>
    <el-table :data="registerList" style="width: 100%">
        <el-table-column label="编号" prop=auto>
            <template #default="scope">
                {{ scope.$index + 1 }}
            </template>
        </el-table-column>
        <el-table-column label="患者姓名" prop="realName" />
        <el-table-column label="患者病历号" prop="caseNumber" />
        <el-table-column label="身份证号" prop="cardNumber" />
        <el-table-column label="患者状态" prop="status">
            <template #default="scope">
                <span v-if="scope.row.visitState === 1">已挂号</span>
                <span v-else-if="scope.row.visitState === 2">已接诊</span>
                <span v-else>未知状态</span>
            </template>
        </el-table-column>
        <el-table-column label="挂号时间" prop="visitDate" />
        <el-table-column label="操作" prop="status" align="right">
            <template #default="scope">
                <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'update')">
                    更新病历
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
        <el-pagination v-model:current-page="pageInfo.pageNumber" v-model:page-size="pageInfo.pageSize"
            :disabled="disabled" :background="background" :page-sizes="[3, 5, 10, 20, 40]"
            layout="total, sizes, prev, pager, next, jumper" :total="total" @current-change="showPage"
            @change="showPage" />
    </div>
</template>

<style scoped></style>