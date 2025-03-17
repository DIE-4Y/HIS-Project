<script setup>
import { getLocalStorage, setLocalStorage, removeLocalStorage } from '../../../common';
import { getAllMedicalTechnologyServiceChecked, getAllMedicalTechnologyDetailService } from '@/apis/physician.js';
import { onMounted, ref } from 'vue';

const register = ref({}) // 病人信息
const items = ref([]) // 检验项目
const selectedItems = ref([]); // 已选择的检查项目名称
const itemDetail = ref({}) // 检验项目详细信息

onMounted(() => {
  register.value = getLocalStorage('register')
  getAllMedicalTechnology()
})

// 根据所有caseNumber查找所有已出结果检查项目
const getAllMedicalTechnology = async () => {
  let result = await getAllMedicalTechnologyServiceChecked(register.value.caseNumber)
  if (result.code === 200) {
    items.value = result.data
  }
}

// 处理表格行点击事件
const handleRowClick = async (row, column, event) => {
  // 根据病人id查询已出结果的详细信息
  let result = await getAllMedicalTechnologyDetailService(register.value.id, row.id)
  console.log(result.data)
  itemDetail.value = result.data
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
    <h3>检查结果</h3>
    <el-divider />
  </div>
  <div style="margin-top: 2%;">
    <el-table :data="items" style="width: 100%" @row-click="handleRowClick">
      <el-table-column label="编号" prop="auto">
        <template #default="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="检查编码" prop="techCode"></el-table-column>
      <el-table-column label="检查名称" prop="techName"></el-table-column>
      <el-table-column label="检查规格" prop="techFormat"></el-table-column>
      <el-table-column label="单价" prop="techPrice"></el-table-column>
      <el-table-column label="状态" prop="status"><span>已出结果</span></el-table-column>
      <el-table-column label="费用分类" prop="priceType"></el-table-column>
    </el-table>
  </div>
  <div style="margin-top: 3%;">
    <h3>检查结果详情</h3>
    <el-divider />
    <el-descriptions class="margin-top" column="1" border>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            开立时间
          </div>
        </template>
        <span>{{ itemDetail.creationTime }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            检查医生
          </div>
        </template>
        <span>{{ itemDetail.realName }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            检查部位
          </div>
        </template>
        <span>{{ itemDetail.checkPosition }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            目的要求
          </div>
        </template>
        <span>{{ itemDetail.checkInfo }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            医嘱备注
          </div>
        </template>
        <span>{{ itemDetail.checkRemark }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            检查结果
          </div>
        </template>
        <span>{{ itemDetail.checkResult }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            检查时间
          </div>
        </template>
        <span>{{ itemDetail.checkTime }}</span>
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<style scoped>
.cell-item {
  font-weight: bold;
}
</style>