# 登录功能

```java
请求地址：/login/employeeLogin
请求方式：post
请求参数：data: {
                realname，//员工姓名
            	password  //员工密码
			}
接收参数：Map<String,String> map
成功：
	"status"：200
	"msg"："ok"
	"data"：emp //返回查找到的员工信息
失败："status"：400
	 "msg"："姓名或密码错误！"
```

# 挂号模块

## 查询所有部门信息

```java
请求地址：/registration/findAllDepartment
请求方式：get
成功：
	"status"：200
	"msg"："ok"
	"data"：deptlist 
```

## 查询所有部门名称及对应的id

```java
请求地址：/registration/findAllDepartmentname
请求方式：get
成功：
	"status"：200
	"msg"："ok"
	"data"：namelist
```

## 查询当前值班医生

```java
请求地址：/registration/findAllDutyEmployee
请求方式：get
请求参数：params:{
			deptName, //科室姓名
			registName, //科室级别
    		dateofvisit //当前系统时间
		}
成功：
	"status"：200
	"msg"："ok"
	"data"：emp
```

## 修改检查申请表的状态

```java
请求地址：/registration/updateCheckremarkbyId
请求方式：get
请求参数：params:{
			id, //检查申请表的id
			checkState //状态
		}
成功：
	"status"：200
	"msg"："ok"
```

## 添加挂号人员信息

```java
请求地址：/registration/addRegister
请求方式：post
请求参数：data:{
			register //挂号信息对象
		}
成功：
	"status"：200
	"msg"："ok"
    "data"：1
失败：
    "status"：200
	"msg"："ok"
    "data"：0
```

## 根据医生模糊查询病人挂号信息

```java
请求地址：/registration/findAllRegistersByEmployee
请求方式：get
请求参数：params:{
			currentPage, //当前第几页
    		pageSize, //每页多少条数据
    		employeeId, //医生id
    		registerId, //挂号人员id
    		realName //挂号人员姓名
		}
成功：
	"status"：200
	"msg"："ok"
    "data"：pageBean
```

## 根据挂号编号和姓名查询挂号信息

```java
请求地址：/registration/findRegisterByIdAndName
请求方式：get
请求参数：params:{
			caseNumber,//患者编号
    		name //患者姓名
		}
成功：
	"status"：200
	"msg"："ok"
    "data"：register//患者挂号信息对象
```

## 查询最大编号

```java
请求地址：/registration/findMaxCaseNumber
请求方式：get
成功：
	"status"：200
	"msg"："ok"
    "data"：stirng //最大编号
```

## 根据医生id查询当前挂号人数

```java
请求地址：/registration/findCountByEmployee
请求方式：get
请求参数：params:{
    		employeeId, //医生id
		}
成功：
	"status"：200
	"msg"："ok"
    "data"：int
```

## 根据id修改检查申请表的状态

```java
请求地址：/registration/updateCheckremarkbyId
请求方式：get
请求参数：params:{
    		id, 
    		checkState
		}
成功：
	"status"：200
	"msg"："ok"
```

## 根据患者id和状态查询处方和对应的药品

```
请求地址：/registration/findAlOpenPrescription
请求方式：get
请求参数：params:{
    		RegisterId, 
    		state
		}
成功：
	"status"：200
	"msg"："ok"
	“data”：List<Prescription> 
```

## 根据处方id修改对应的状态

```
请求地址：/registration/UpdatePrescriptionState
请求方式：get
请求参数：params:{
    		id, 
    		state
		}
成功：
	"status"：200
	"msg"："ok"
```

## 去重查询查询号别名称

```
请求地址：/registration/findAllregistName
请求方式：get
成功：
	"status"：200
	"msg"："ok"
	"data":List<String>
```

## 查询所有号别信息

```
请求地址：/registration/findAllRegistLevel
请求方式：get
成功：
	"status"：200
	"msg"："ok"
	“data”：List<String>
```

## 查询所有的缴费方式

```
请求地址：/registration/findAllSettleName
请求方式：get
成功：
	"status"：200
	"msg"："ok"
	“data”：List<SettleCategory> 
```

# 门诊医生模块

## 添加检查信息

```
请求地址：/Physician/CheckRequest/addCheckRequest
请求方式：post
请求参数：
	data:{
		checkRequest
	}
成功：
	"status"：200
	"msg"："ok"
```

## 根据患者id查询当前已出结果的项目

```
请求地址：/Physician/CheckRequest/findGivenResultCheckRequestByRegister
请求方式：get
请求参数：
	params:{
		registerId
	}
成功：
	"status"：200
	"msg"："ok"
	“data”：List<CheckRequest>
```

## 根据疾病名称实现模糊查询

```
请求地址：/Physician/CheckRequest/findAllDiseaseByname
请求方式：get
请求参数：
	params:{
		diseaseName
	}
成功：
	"status"：200
	"msg"："ok"
	“data”：List<Disease>
```

## 添加病人病历信息

```
请求地址：/Physician/MedicalRecord/addMedicalRecord
请求方式：post
请求参数：
	data:{
		medicalRecord
	}
成功：
	"status"：200
	"msg"："ok"
	“data”：Integer
```

## 更新病人病历信息

```
请求地址：/Physician/MedicalRecord/updateMedicalRecordById
请求方式：post
请求参数：
	data:{
		medicalRecord
	}
成功：
	"status"：200
	"msg"："ok"
```

## 添加病历id和疾病id

```
请求地址：/Physician/MedicalRecordDisease/addMedicalRecordDisease
请求方式：get
请求参数：
	params:{
		medicalRecordId,
		diseaseId
	}
成功：
	"status"：200
	"msg"："ok"
```

## 根据病历id查询关联疾病

```
请求地址：/Physician/MedicalRecordDisease/updateMedicalRecordById
请求方式：get
请求参数：
	params:{
		medicalRecordId
	}
成功：
	"status"：200
	"msg"："ok"
	"data"：List<MedicalRecordDisease>
```

## 根据名称和编号模糊查询检查项目

```
请求地址：/Physician/MedicalTechnology/findMedicalTechnologyByIdAndName
请求方式：get
请求参数：
	params:{
		codeId,
		name,
		techType
	}
成功：
	"status"：200
	"msg"："ok"
	"data"：List<MedicalTechnology>
```

## 添加处方信息

```
请求地址：/Physician/Prescription/addPrescription
请求方式：post
请求参数：
	data:{
		 prescriptionList，
	}
成功：
	"status"：200
	"msg"："ok"
```

## 根据医生id查询今日已看诊人数

```
请求地址：/Physician/Register/findAlreadyCountByEmployee
请求方式：get
请求参数：
	params:{
		 employeeId
	}
成功：
	"status"：200
	"msg"："ok"
	"data":int
```

## 根据挂号id修改当前挂号状态

```
请求地址：/Physician/Register/updatevisitStateById
请求方式：get
请求参数：
	params:{
		 Iid,
         visitState
	}
成功：
	"status"：200
	"msg"："ok"
```

## 根据患者姓名和编号查询已经医生接诊的挂号信息

```
请求地址：/Physician/Register/findAllRegisterReceivedByNameAndcaseId
请求方式：post
请求参数：
	data:{
		 registerName,
         registerCaseNumber,
         pageSize,
         currentPage,
         visitState,
         employeeId
	}
成功：
	"status"：200
	"msg"："ok"
	"data"：PageInfo<Register>
```

# 检查医生模块

## 根据id修改检查申请表状态为执行完成

```
请求地址：/Check/CheckRequest/updateCheckremarkToExecutebyId
请求方式：post
请求参数：
	data:{
		 checkRequest
	}
成功：
	"status"：200
	"msg"："ok"
```



## 根据医生Id和部门id查询当天已检查人数

```
请求地址：/Check/CheckRequest/findFinishAllExaminationCount
请求方式：get
请求参数：
	params:{
		  employeeId,
​		  deptmentId
​	}
成功：
​	"status"：200
​	"msg"："ok"
​	"data"：Integer
```

## 根据科室类型查询科室信息

```
请求地址：/Check/Department/findDepartmentByType
请求方式：get
请求参数：
	params:{
		 deptType
	}
成功：
	"status"：200
	"msg"："ok"
	"data":List<Department>
```

## 根据科室id查询当前值班医生

```
请求地址：/Check/Employee/findAllEmployeeByDepId
请求方式：get
请求参数：
	params:{
		 deptmentId
	}
成功：
	"status"：200
	"msg"："ok"
	"data":List<Employee>
```

## 根据患者挂号id和部门并且已缴费查询项目

```
请求地址：/Check/MedicalTechnology/findAlreadyPayByRegisterIdAndDepId
请求方式：get
请求参数：
	params:{
		 registerId,
		 state,
		 deptmentId
	}
成功：
	"status"：200
	"msg"："ok"
	"data":List<MedicalTechnology>
```

## 根据患者挂号编号和姓名及项目部门查询已经执行完成的项目

```
请求地址：/Check/MedicalTechnology/findAlExamineMedicalTechnologyBydeptmentIdAndCaseNumber
请求方式：get
请求参数：
	params:{
		caseNumber,
		caseName,
		deptmentId
	}
成功：
	"status"：200
	"msg"："ok"
	"data":List<CheckRequest>
```

## 根据患者编号和姓名查询已缴费的检查项目

```
请求地址：/Check/Register/findPaidItemsRegister
请求方式：get
请求参数：
	params:{
		registerName,
		registerCaseNumber,
		pageSize,
		currentPage,
		deptmentId
	}
成功：
	"status"：200
	"msg"："ok"
	"data":PageInfo<Register>
```

# 药房管理模块

## 查询药品已缴费的患者信息

```
请求地址：/drugstore/registerfindAlPayRegisterBycaseNumberAndName
请求方式：get
请求参数：
	params:{
		state,
		caseNumber,
		realName,
		pageSize,
		currentPage
	}
成功：
	"status"：200
	"msg"："ok"
	"data":PageInfo<Register> 
```

## 根据名称和助记码进行模糊查询药品

```
请求地址：/physician/DrugInfo/findDrugBYDrugNameAndDrugCode
请求方式：get
请求参数：
	params:{
		drugName,
		mnemonicCode
	}
成功：
	"status"：200
	"msg"："ok"
	"data":List<DrugInfo>
```

