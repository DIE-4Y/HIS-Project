<script setup>
import { onMounted, ref } from 'vue';
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common'
import { getAllDiseaseService, addMedicalRecordDiseaseService } from '@/apis/physician.js';
import { ElMessage } from 'element-plus';


const register = ref({})        // 病人基本信息
const diseaseList = ref([])     // 分页查询展示疾病列表
const total = ref(0)            // 疾病总数
const diseaseIdList = ref([])   // 疾病id列表
const registerDiseaseList = ref([]) // 用户疾病列表
const dialogVisible = ref(false); // 控制对话框显示状态

const medicalRecord = ref({     // 病历信息
    registerId: '',
    readme: '',
    present: '',
    presentTreat: '',
    history: '',
    allergy: '',
    physique: '',
    proposal: '',
    careful: '',
    diagnosis: '',
    cure: ''
})

// 疾病信息分页查询
const pageInfo = ref({
    id: null,
    pageNumber: 1,
    pageSize: 5,
    diseaseName: ''
})

// 实现获取所有疾病的方法
const showPage = async () => {
    let result = await getAllDiseaseService(pageInfo.value)
    diseaseList.value = result.data.rows
    total.value = result.data.total
}

// 初始化上方展示的病人信息
onMounted(() => {
    register.value = getLocalStorage('register')
    showPage()
    medicalRecord.value.registerId = register.value.id
})

// 添加病历和疾病id信息
const addMedicalRecordDisease = async () => {
    let result = await addMedicalRecordDiseaseService(medicalRecord.value, diseaseIdList.value)
    if (result.code === 200) {
        ElMessage.success(result.msg ? result.msg : "病历和疾病信息添加成功")
        location.reload(true)
    }
}

// 表单增加 选项
const handleEdit = (index, row, action) => {
    if (action === 'add') {
        // 向 diseaseIdList 添加疾病id
        if (!diseaseIdList.value.includes(row.id)) {
            diseaseIdList.value.push(row.id);
            registerDiseaseList.value.push(row);
        }
    }
}

const clearMedicalRecord = () => {
    registerId = '',
        readme = '',
        present = '',
        presentTreat = '',
        history = '',
        allergy = '',
        physique = '',
        proposal = '',
        careful = '',
        diagnosis = '',
        cure = ''
}

// 控制对话框的显示和隐藏
const openDialog = () => {
    dialogVisible.value = true;
};

const closeDialog = () => {
    dialogVisible.value = false;
};

// 疾病全选
const selectAllDiseases = () => {
    registerDiseaseList.value.forEach(item => item.selected = true);
};

// 疾病移除
const removeSelectedDiseases = () => {
    // 找到所有选中的疾病项
    const selectedDiseaseIds = registerDiseaseList.value.filter(item => item.selected).map(item => item.id);
    registerDiseaseList.value = registerDiseaseList.value.filter(item => !item.selected);
    // 从diseaseIdList中移除ID
    diseaseIdList.value = diseaseIdList.value.filter(id => !selectedDiseaseIds.includes(id));
};
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
    <h3>病例首页</h3>
    <el-divider />

    <el-form :model="medicalRecord" label-width="120px">
        <el-form-item label="主诉">
            <el-input v-model="medicalRecord.readme" :rows="2" type="textarea" placeholder="请输入主诉" />
        </el-form-item>
        <el-form-item label="现病史">
            <el-input v-model="medicalRecord.present" :rows="2" type="textarea" placeholder="请输入现病史" />
        </el-form-item>

        <el-form-item label="现病治疗情况">
            <el-input v-model="medicalRecord.presentTreat" :rows="2" type="textarea" placeholder="请输入现病治疗情况" />
        </el-form-item>

        <el-form-item label="既往史">
            <el-input v-model="medicalRecord.history" :rows="2" type="textarea" placeholder="请输入既往史" />
        </el-form-item>

        <el-form-item label="过敏史">
            <el-input v-model="medicalRecord.allergy" :rows="2" type="textarea" placeholder="请输入过敏史" />
        </el-form-item>

        <el-form-item label="体格检查">
            <el-input v-model="medicalRecord.physique" :rows="2" type="textarea" placeholder="请输入体格检查" />
        </el-form-item>

        <el-form-item label="诊断">
            <div
                style="margin-bottom: 10px; display: flex; align-items: center;flex-direction:row; justify-content:space-between;">
                <div>
                    <el-radio-group>
                        <el-radio size="large" @click="selectAllDiseases"></el-radio>
                    </el-radio-group>
                </div>
                <div>
                    <el-button @click="openDialog" type="primary" size="small">增加</el-button>
                    <el-button @click="removeSelectedDiseases" type="danger" size="small">删除</el-button>
                </div>
            </div>
            <el-table :data="registerDiseaseList" style="width: 100%">
                <el-table-column label="选择" width="80">
                    <template #default="scope">
                        <el-checkbox v-model="scope.row.selected"></el-checkbox>
                    </template>
                </el-table-column>
                <el-table-column label="编号" prop="id" />
                <el-table-column label="疾病名称" prop="diseaseName" />
                <el-table-column label="国际ICD编码" prop="diseaseICD" />
                <el-table-column label="疾病类型" prop="diseaseCategory" />
            </el-table>
            <el-dialog v-model="dialogVisible" title="新增疾病信息" width="80%" :before-close="closeDialog">
                <el-divider />
                <el-input v-model="pageInfo.id" placeholder="请输入疾病编号"
                    style="width: 200px;margin-right: 20px;"></el-input>
                <el-input v-model="pageInfo.diseaseName" placeholder="请输入疾病名称"
                    style="width: 200px; margin-right: 20px;"></el-input>
                <el-button type="primary" @click="showPage">查询</el-button>
                <el-divider />
                <el-table :data="diseaseList" style="width: 100%">
                    <el-table-column label="编号" prop="id" />
                    <el-table-column label="疾病名称" prop="diseaseName" />
                    <el-table-column label="国际ICD编码" prop="diseaseICD" />
                    <el-table-column label="疾病类型" prop="diseaseCategory" />
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
        </el-form-item>

        <el-form-item label="检查检验建议">
            <el-input v-model="medicalRecord.proposal" :rows="2" type="textarea" placeholder="请输入检查/检验检建议" />
        </el-form-item>

        <el-form-item label="注意事项">
            <el-input v-model="medicalRecord.careful" :rows="2" type="textarea" placeholder="请输入注意事项" />
        </el-form-item>
    </el-form>
    <el-button type="primary" @click="addMedicalRecordDisease">保存</el-button>
    <el-button type="primary" @click="clearMedicalRecord">清空</el-button>
</template>


<style scoped>
.outer-div {
    display: flex;
    /* 使用 Flexbox 布局 */
    align-items: center;
    /* 垂直居中 */
    justify-content: flex-start;
    /* 水平起始对齐 */
    background-color: #f9f9f9;
    /* 背景颜色 */
    border: 1px solid #ddd;
    /* 边框 */
    border-radius: 8px;
    /* 圆角边框 */
    padding: 10px;
    /* 内边距 */
    margin-bottom: 20px;
    /* 外边距 */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    /* 阴影效果 */
}

.inner-left-div {
    font-weight: bold;
    /* 加粗字体 */
    margin-right: 10px;
    /* 与右侧输入框的间距 */
    color: #333;
    /* 字体颜色 */
    width: 10%;
}

.inner-right-div {
    flex-grow: 1;
    /* 占据剩余空间 */
}

.el-textarea__inner {
    width: 100%;
    /* 输入框宽度 */
    border: 1px solid #ccc;
    /* 输入框边框 */
    border-radius: 4px;
    /* 输入框圆角 */
    padding: 8px;
    /* 输入框内边距 */
    font-size: 14px;
    /* 字体大小 */
    color: #666;
    /* 字体颜色 */
    background-color: #fff;
    /* 背景颜色 */
    box-sizing: border-box;
    /* 确保宽度不会因为内边距而变化 */
}

/* 鼠标悬停时的样式 */
.outer-div:hover {
    border-color: #409eff;
    /* 鼠标悬停时的边框颜色 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    /* 鼠标悬停时的阴影效果 */
}
</style>