<script setup>
import { onMounted, ref } from 'vue';
import { getAllRegisterByStateService, getAllDrugByRegisterIdService, updatePrescriptionStateService } from '@/apis/drugstore.js';
import { ElMessage } from 'element-plus';

const registerList = ref([]); // 病人信息列表
const registerDetail = ref({}); // 病人详细信息
const total = ref(0); // 已接诊状态的总人数
const drugList = ref([]); // 对应人员药品列表

// 分页信息
const pageInfo = ref({
    caseNumber: '',
    realName: '',
    pageNumber: 1,
    pageSize: 5
});

onMounted(() => {
    showPage();
});

// 获取所有状态为已接诊人员的病人
const showPage = async () => {
    let result = await getAllRegisterByStateService(pageInfo.value.caseNumber, pageInfo.value.realName, pageInfo.value.pageNumber, pageInfo.value.pageSize);
    if (result.code === 200) {
        registerList.value = result.data.rows;
        total.value = result.data.total;
    }
};

// 表格查看药品
const handleEdit = async (index, row, action) => {
    if (action === 'update') {
        registerDetail.value = row;
        let result = await getAllDrugByRegisterIdService(row.id);
        drugList.value = result.data;
    }
};

// 发药
const handleClick = async (index, row, action) => {
    if (action === 'update') {
        const prescription = {
            registerId: registerDetail.value.id,
            drugId: row.drugId
        };
        let result = await updatePrescriptionStateService(prescription);
        if (result.code === 200) {
            ElMessage.success("开药成功");
            // 从药物列表中移除对应的行
            const drugIndex = drugList.value.indexOf(row);
            if (drugIndex !== -1) {
                drugList.value.splice(drugIndex, 1);
            }
        }
    }
};
</script>

<template>
    <div>
        <el-divider />
        <h3>发药</h3>
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
        <el-table-column label="编号" prop="auto">
            <template #default="scope">
                {{ scope.$index + 1 }}
            </template>
        </el-table-column>
        <el-table-column label="患者姓名" prop="realName" />
        <el-table-column label="患者病历号" prop="caseNumber" />
        <el-table-column label="患者年龄" prop="age" />
        <el-table-column label="患者性别" prop="gender" />
        <el-table-column label="操作" prop="status" align="right">
            <template #default="scope">
                <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'update')">
                    显示药品
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <div class="demo-pagination-block" style="margin-top: 2%;">
        <el-pagination v-model:current-page="pageInfo.pageNumber" v-model:page-size="pageInfo.pageSize"
            :disabled="disabled" :background="background" :page-sizes="[3, 5, 10, 20, 40]"
            layout="total, sizes, prev, pager, next, jumper" :total="total" @current-change="showPage"
            @change="showPage" />
        <el-divider />
    </div>

    <div style="margin-top: 2%;">
        <el-table :data="drugList" style="width: 100%">
            <el-table-column label="编号" prop="auto">
                <template #default="scope">
                    {{ scope.$index + 1 }}
                </template>
            </el-table-column>
            <el-table-column label="药品编码" prop="drugCode" />
            <el-table-column label="药品名称" prop="drugName" />
            <el-table-column label="药品规格" prop="drugFormat" />
            <el-table-column label="包装单位" prop="drugUnit" />
            <el-table-column label="生产厂家" prop="manufacturer" />
            <el-table-column label="单价" prop="drugPrice" />
            <el-table-column label="药品数量" prop="drugNumber" />
            <el-table-column label="操作" align="right">
                <template #default="scope">
                    <el-button size="small" @click="handleClick(scope.$index, scope.row, 'update')">
                        发药
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<style scoped></style>