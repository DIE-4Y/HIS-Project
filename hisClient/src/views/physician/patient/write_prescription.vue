<script setup>
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common';
import { onMounted, ref, computed } from 'vue';
import { getAllDrugService, insertPrescriptionService } from '@/apis/physician';
import { ElMessage } from 'element-plus';

const register = ref({}); // 病人信息
const drugList = ref([]); // 药品列表
const selectedMedicines = ref([]); // 选中的药品
const dialogVisible = ref(false); // 是否显示添加药品对话框
const tableData = ref([]); // 表格数据
const totalFee = computed(() => { // 计算总价值
  return tableData.value.reduce((sum, item) => {
    return sum + item.drugPrice * item.drugNumber;
  }, 0).toFixed(2);
});
const pageInfo = ref({   // 分页数据
  total: 0,
  drugName: '',
  drugCode: '',
  pageSize: 5,
  pageNumber: 1
});

// 处理选中事件
const handleSelectionChange = (selection) => {
  selectedMedicines.value = selection;
};

// 删除选中的药品
const deleteSelected = () => {
  if (selectedMedicines.value.length === 0) {
    ElMessage.warning('请至少选择一项药品');
    return;
  }
  selectedMedicines.value.forEach(item => {
    const index = tableData.value.indexOf(item);
    if (index !== -1) {
      tableData.value.splice(index, 1);
    }
  });
  ElMessage.success('删除成功');
};

// 打开添加药品对话框
const addMedicine = () => {
  showPage();
  dialogVisible.value = true;
};

// 分页查询
const showPage = async () => {
  let result = await getAllDrugService(pageInfo.value.drugName, pageInfo.value.drugCode, pageInfo.value.pageSize, pageInfo.value.pageNumber);
  drugList.value = result.data.rows;
  pageInfo.value.total = result.data.total;
};

onMounted(() => {
  register.value = getLocalStorage('register');
});

// 确认提交
const submitConfirm = async () => {
  // 构造处方列表数据
  const prescriptionList = tableData.value.map(item => ({
    registerId: register.value.id, // 挂号ID，假设从register中获取
    drugId: item.drugId, // 药品ID，直接从tableData中获取
    drugUsage: item.drugUsage, // 用法用量
    drugNumber: item.drugNumber // 数量
  }));

  try {
    // 调用插入处方的服务
    const result = await insertPrescriptionService(prescriptionList);
    ElMessage.success('处方开立成功');
  } catch (error) {
    ElMessage.error('处方开立失败');
  }
};

// 重置输入
const clearInput = () => {
  tableData.value = [];
};

// 将选中的药品添加到页面表格中
const handleAdd = () => {
  if (selectedMedicines.value.length === 0) {
    ElMessage.warning('请至少选择一项药品');
    return;
  }
  selectedMedicines.value.forEach(medicine => {
    const medicineData = {
      drugId: medicine.id, // 添加药品ID
      drugCode: medicine.drugCode,
      drugName: medicine.drugName,
      drugFormat: medicine.drugFormat,
      drugPrice: medicine.drugPrice,
      drugUsage: '',
      drugNumber: 1,
    };
    tableData.value.push(medicineData);
  });
  dialogVisible.value = false;
  ElMessage.success('添加成功');
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
  <div>
    <el-divider />
    <h3>开设处方</h3>
    <el-divider />
  </div>
  <div>
    <el-tag style="width: 10%;  padding: 20px;  border: 1px solid #dcdf;  border-radius: 8px;  background-color: #aef;"
      color="#67C23E">处方金额：{{ totalFee }}元</el-tag>
    <el-table :data="tableData" style="width: 100%" :header-cell-style="{ background: '#f8f8f9', color: '#000' }"
      @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="药品名称" prop="drugName" width="200">
        <template #default="scope">
          <div style="display: flex; align-items: center;">
            <el-icon>
              <ArrowRight />
            </el-icon>
            <span style="margin-left: 5px;">{{ scope.row.drugName }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="药品规格" prop="drugFormat"></el-table-column>
      <el-table-column label="单价" prop="drugPrice" width="100"></el-table-column>
      <el-table-column label="用法用量" width="250">
        <template #default="scope">
          <el-input type="textarea" :rows="1" placeholder="输入用法用量，使用频次等信息" v-model="scope.row.drugUsage"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="数量" width="180">
        <template #default="scope">
          <el-input-number v-model="scope.row.drugNumber" :min="1" :max="10"></el-input-number>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120">
        <template #header>
          <div style="display: flex; justify-content: center;">
            <el-button link type="primary" @click="deleteSelected">删除</el-button>
            <el-button link type="primary" @click="addMedicine">增加</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="dialogVisible" title="添加药品" width="60%" custom-class="add-medicine-dialog">
      <div style="margin-bottom: 20px;">
        <el-form :inline="true" :model="pageInfo" class="demo-form-inline">
          <el-form-item label="药品名称">
            <el-input v-model="pageInfo.drugName" placeholder="请输入药品名称" clearable></el-input>
          </el-form-item>
          <el-form-item label="拼音助记码">
            <el-input v-model="pageInfo.drugCode" placeholder="请输入药品拼音助记码" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="showPage">搜索</el-button>
          </el-form-item>
        </el-form>
      </div>
      <el-table :data="drugList" @selection-change="handleSelectionChange" style="width: 100%">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="drugCode" label="药品编码" width="120"></el-table-column>
        <el-table-column prop="drugName" label="药品名称"></el-table-column>
        <el-table-column prop="drugFormat" label="药品规格"></el-table-column>
        <el-table-column prop="drugPrice" label="药品单价" width="100"></el-table-column>
        <el-table-column prop="drugUnit" label="包装单位" width="100"></el-table-column>
        <el-table-column prop="manufacturer" label="生产厂家"></el-table-column>
      </el-table>
      <el-pagination v-model:current-page="pageInfo.pageNumber" v-model:page-size="pageInfo.pageSize"
        :disabled="disabled" :background="background" :page-sizes="[3, 5, 10, 20, 40]"
        layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total" @current-change="showPage"
        @change="showPage" />
      <template #footer>
        <div style="display: flex; justify-content: flex-end;">
          <el-button @click="dialogVisible = false">关闭</el-button>
          <el-button type="primary" @click="handleAdd">添加</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
  <div style="margin-top: 2%;">
    <el-button type="primary" @click="submitConfirm">开立处方</el-button>
    <el-button type="primary" @click="clearInput">重置处方</el-button>
  </div>
</template>

<style scoped></style>