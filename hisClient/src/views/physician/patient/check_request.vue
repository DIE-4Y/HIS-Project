<script setup>
import { onMounted, ref } from 'vue';
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common'
import { getAllMedicalTechnologyService, addCheckRequestService } from '@/apis/physician.js'
import { ElMessage } from 'element-plus';

const register = ref({})                    // 病人基本信息
const medicalTechnologyList = ref([])       // 分页查询展示检查项目列表
const total = ref(0)                        // 检查项目总数
const medicalTechnologyIdList = ref([])     // 检查项目id列表
const registerMedicalTechnologyList = ref([]) // 用户检查项目列表
const dialogVisible = ref(false);           // 控制对话框显示状态
const itemsFee = ref(0)             // 检查项目费用
const emp = ref({})

// 体检信息
const checkRequest = ref({
    registerId: '',
    checkInfo: '',
    checkPosition: '',
    checkRemark: '',
    medicalTechnologyId: '',
    inputcheckEmployeeId: ''
})

// 检查信息分页查询
const pageInfo = ref({
    id: null,
    name: '',
    pageNumber: 1,
    pageSize: 5
})

// 实例化获取所有检查项目
const showPage = async () => {
    let result = await getAllMedicalTechnologyService(pageInfo.value)
    medicalTechnologyList.value = result.data.rows
    total.value = result.data.total
}

// 初始化上方展示的病人信息
onMounted(() => {
    register.value = getLocalStorage('register')
    emp.value = getLocalStorage('emp')
    showPage()
    checkRequest.value.registerId = register.value.id
    checkRequest.value.inputcheckEmployeeId = emp.value.id
})

// 表单增加 选项
const handleEdit = (index, row, action) => {
    if (action === 'add') {
        // 向 diseaseIdList 添加疾病id
        if (!medicalTechnologyIdList.value.includes(row.id)) {
            medicalTechnologyIdList.value.push(row.id);
            registerMedicalTechnologyList.value.push(row);
            itemsFee.value += row.techPrice
        }
    }
}

// 控制对话框的显示和隐藏
const openDialog = () => {
    dialogVisible.value = true;
};

const closeDialog = () => {
    dialogVisible.value = false;
};

// 体检项目全选
const selectAllmedicalTechnologys = () => {
    registerMedicalTechnologyList.value.forEach(item => item.selected = true);
};

// 检查项目移除
const removeSelectedmedicalTechnologys = () => {
    // 找到所有选中的检查项目项
    const selectedMedicalTechnologyIds = registerMedicalTechnologyList.value.filter(item => item.selected).map(item => item.id);
    registerMedicalTechnologyList.value = registerMedicalTechnologyList.value.filter(item => !item.selected);
    // medicalTechnologyIdList中移除这些ID
    medicalTechnologyIdList.value = medicalTechnologyIdList.value.filter(id => !selectedMedicalTechnologyIds.includes(id));

    // 计算itemsFee
    const itemFee = registerMedicalTechnologyList.value.reduce((total, item) => {
        return total + item.techPrice;
    }, 0);
    itemsFee.value = itemFee;
};

// 添加检查信息
const addCheckRequest = async () => {
    const requestData = {
        registerId: checkRequest.value.registerId,
        checkInfo: checkRequest.value.checkInfo,
        checkPosition: checkRequest.value.checkPosition,
        checkRemark: checkRequest.value.checkRemark,
        medicalTechnologyId: medicalTechnologyIdList.value[0],
        inputcheckEmployeeId: checkRequest.value.inputcheckEmployeeId
    };
    checkRequest.value.medicalTechnologyId = medicalTechnologyIdList.value[0]
    let result = await addCheckRequestService(requestData)
    if (result.code === 200) {
        ElMessage.success(result.msg ? result.msg : "检查信息添加成功")
        location.reload(true)
    }
}
// 重置检查信息
const clearCheckRequest = () => {
    checkRequest.value.checkInfo = '',
        checkRequest.value.checkPosition = '',
        checkRequest.value.checkRemark = '',
        checkRequest.value.inputcheckEmployeeId = '',
        checkRequest.value.medicalTechnologyId = '',
        checkRequest.value.registerId = ''
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
    <el-divider />
    <h3>检查申请</h3>
    <el-divider />

    <el-tag style="width: 10%;  padding: 20px;  border: 1px solid #dcdf;  border-radius: 8px;  background-color: #aef;"
        color="#67C23E">项目金额：{{ itemsFee }}</el-tag>
    <div>
        <div
            style="margin-bottom: 10px; display: flex; align-items: center;flex-direction:row; justify-content:space-between;">
            <div>
                <el-radio-group>
                    <el-radio size="large" @click="selectAllmedicalTechnologys"></el-radio>
                </el-radio-group>
            </div>
            <div>
                <el-button @click="openDialog" type="primary" size="small">增加</el-button>
                <el-button @click="removeSelectedmedicalTechnologys" type="danger" size="small">删除</el-button>
            </div>
        </div>
        <el-table :data="registerMedicalTechnologyList" style="width: 100%">
            <el-table-column label="选择" width="80">
                <template #default="scope">
                    <el-checkbox v-model="scope.row.selected"></el-checkbox>
                </template>
            </el-table-column>
            <el-table-column label="检查编号" prop="id" />
            <el-table-column label="检查名称" prop="techName" />
            <el-table-column label="检查规格" prop="techFormat" />
            <el-table-column label="单价" prop="techPrice" />
            <el-table-column label="费用分类" prop="priceType" />
        </el-table>
        <el-dialog v-model="dialogVisible" title="新增检查项目信息" width="80%" :before-close="closeDialog">
            <el-divider />
            <el-input v-model="pageInfo.id" placeholder="请输入检查项目编号" style="width: 200px;margin-right: 20px;"></el-input>
            <el-input v-model="pageInfo.name" placeholder="请输入检查项目名称"
                style="width: 200px; margin-right: 20px;"></el-input>
            <el-button type="primary" @click="showPage">查询</el-button>
            <el-divider />
            <el-table :data="medicalTechnologyList" style="width: 100%">
                <el-table-column label="检查编号" prop="id" />
                <el-table-column label="检查名称" prop="techName" />
                <el-table-column label="检查规格" prop="techFormat" />
                <el-table-column label="单价" prop="techPrice" />
                <el-table-column label="费用分类" prop="priceType" />
                <el-table-column align="right">
                    <template #default="scope">
                        <el-button size="small" @click="handleEdit(scope.$index, scope.row, 'add')">选择</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination v-model:current-page="pageInfo.pageNumber" v-model:page-size="pageInfo.pageSize"
                :disabled="disabled" :background="background" :page-sizes="[3, 5, 10, 20, 40]"
                layout="total, sizes, prev, pager, next, jumper" :total="total" @current-change="showPage"
                @change="showPage" />
        </el-dialog>
    </div>

    <el-divider />
    <h3>医嘱</h3>
    <el-divider />
    <el-form :model="checkRequest" label-width="120px">
        <el-form-item label="目的要求">
            <el-input v-model="checkRequest.checkInfo" :rows="2" type="textarea" placeholder="请输入目的要求" />
        </el-form-item>
        <el-form-item label="检验部位">
            <el-input v-model="checkRequest.checkPosition" :rows="2" type="textarea" placeholder="请输入检验部位" />
        </el-form-item>
        <el-form-item label="备注">
            <el-input v-model="checkRequest.checkRemark" :rows="2" type="textarea" placeholder="请输入备注" />
        </el-form-item>
    </el-form>
    <el-button type="primary" @click="addCheckRequest">提交申请</el-button>
    <el-button type="primary" @click="clearCheckRequest">清空表格</el-button>
</template>

<style scoped></style>