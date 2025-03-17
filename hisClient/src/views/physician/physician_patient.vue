<script setup>
import { getLocalStorage, setLocalStorage } from '../../common'
import { getAllCountService, getAllRegister,updateVisitStateService } from '@/apis/rejistration.js'
import { onMounted, ref } from 'vue';
import { useRouter } from "vue-router";
import { ElMessage } from 'element-plus';

let emp = getLocalStorage("emp");
let router = useRouter();

// 分页信息
const pageInfo = ref({
    empId: 0,
    pageNumber: 1,
    pageSize: 5,
    caseNumber: '',
    realName: ''
})

const alreadyCount = ref(0)// 已看人数
const totalCount = ref(0)//排队人数
const registerList = ref([])//所有患者列表
const total = ref(0)//患者总人数

// 实现查询已看诊人数方法
const getAllCount = async () => {
    let result = await getAllCountService(emp.id, 3)
    alreadyCount.value = result.data
}
// 获取排队人数方法
const getTotalCount = async () => {
    let result = await getAllCountService(emp.id, 1)
    totalCount.value = result.data
}
// 分页查询所有病人 实现模糊查询
const showPage = async () => {
    let result = await getAllRegister(pageInfo.value)
    registerList.value = result.data.rows
    total.value = result.data.total
}

// 加载调用获取看诊人数和排队人数方法
onMounted(() => {
    pageInfo.value.empId = emp.id
    getAllCount()
    getTotalCount()
    showPage()
})

// 修改visit状态为已接诊


// 跳转到病历首页
const handleEdit = (index, row, action) => {
    if (action === 'create') {
        // 修改visitState为已接诊
        updateVisitStateService(row.caseNumber, row.realName)
        // 保存当前行的病人数据到 localStorage
        setLocalStorage('register', row)
        // 使用 router.push 跳转到指定的路由
        router.push('/home_medical_record');
    } else if (action === 'call') {
        // 叫号逻辑
        ElMessage.info(`叫号: ${row.realName}`);
    } else if (action === 'skip') {
        // 跳过逻辑
        ElMessage.info(`跳过: ${row.realName}`);
    }

};

</script>


<template>
    <el-tag class="ml-2" color="#d1edc4">
        今日已看{{ alreadyCount }}人
    </el-tag>
    <el-tag class="ml-2" color="#f8e3c5">
        当前有{{ totalCount }}人在排队
    </el-tag>
    <el-divider />
    <h3>患者叫号</h3>
    <el-divider />
    <el-input v-model="pageInfo.caseNumber" placeholder="请输入患者病历号" style="width: 200px;margin-right: 20px;"></el-input>
    <el-input v-model="pageInfo.realName" placeholder="请输入患者姓名" style="width: 200px; margin-right: 20px;"></el-input>
    <el-button type="primary" @click="showPage">查询</el-button>
    <el-divider />
    <el-table :data="registerList" style="width: 60%">
        <el-table-column label="编号" prop="id" />
        <el-table-column label="患者姓名" prop="realName" />
        <el-table-column label="患者病历号" prop="caseNumber" />
        <el-table-column align="right">
            <template #default="scope">
                <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'create')">
                    创建病历
                </el-button>
                <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'call')">
                    叫号
                </el-button>
                <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'skip')">
                    跳过
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

<style scoped>
.ml-2 {
    margin-right: 30px;
    color: #777;
}
</style>