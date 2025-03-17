# 1、项目开发

## 1.1 项目开发流程整体说明：

- 可行性研究

- - 工作负荷：列出现有系统所承担的工作及工作量
  - 费用开支：列出由于运行现有系统所引起的费用开支
  - 技术条件方面的可能性
  - 可选择的其他系统方案
  - 投资及效益分析
  - 法律方面的可行性
  - 。。。

- 需求分析：

- - 项目功能，项目模块
  - 对性能的规定
  - 数据管理能力要求

- 系统设计：指导开发代码的具体做法，对团队合作、代码测试、后期维护有非常重要的作用。
- 系统实现：编码实现项目功能
- 系统测试：决定项目的健壮性，功能的完善程度
- 系统维护：项目后期完善，二次开发

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1649580185872-4344ca92-a588-4a57-96a9-97f012abfc54.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_62%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

- 迭代开发

- - 根据业务复杂度，项目可以进行多次迭代开发
  - 先启迭代

- - - 重点确认需求部分
    - 少量代码，以项目框架搭建为主

- - 精化迭代

- - - 重点是分析与设计部分，修改优化和完善需求部分
    - 进入代码阶段
    - 少量测试

- - 构造迭代

- - - 重点是编码部分，修改优化和完善需求、设计部分
    - 测试部分也是重点
    - 进入部署阶段，本次迭代后期，部署也是重点部分
    - 根据业务规模和实际情况，可能会进行多次构造迭代

- - 移交迭代

- - - 重点是部署部分，少量测试和代码优化

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652946921745-6da90b00-ac5d-4e57-92bc-bec57c005e43.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_27%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

## 1.2 项目背景

​     在医院的管理方面，计算机技术发挥了重要的作用。为了方便医院管理，简化流程，医院管理系统已经在各大医院中得到应用。而**HIS（门诊管理）系统作为医院管理系统的一个子系统**，其重要程度远远胜过医院管理系统中的一些其他子系统。

​      通常，医院门诊流量大，手续较繁锁。在传统的手工方式下，医护人员要做大量的重复工作，而这些工作往往是一些必要的信息记录工作。在传统方式下，这些工作的进行不仅效率非常低，而且经常出现差错。记录信息的纸质文件不仅不方便管理，影响工作效率，还造成了很多就诊病人得不到合理有效的就诊服务，甚至影响医疗质量。

​     正是因为这样，门诊管理系统的优势得以显现。门诊管理系统不仅可以使门诊的各个部门高度紧密的协作，而且简化了门诊就医的流程。它将原本的纸质病历变成电子病历，很多操作都是通过系统自动完成，比如病历中患者基本信息的填写。这使得患者就医的时间得到压缩，医生需要做的工作得到减少。而且电子病历更易存取，方便管理，更加安全。

​      门诊管理系统不仅可以提搞服务效率和质量，使病人和医生情绪能够得以放松，还使得门诊工作可以高效有序的运转。

## 1.3 开发目标

​     项目的总体目标是为医院的门诊开发一套信息化门诊系统，能满足医院从病人挂号到诊断到缴费的一整套流程的业务需要，为门诊医生和门诊相关的医院工作人员提供便利，**实现挂号、看病与缴费的系统化流程。**

## 1.4 需求调研

对业务相关人进行调研，确定工作流程。本部分的语言更偏重业务描述。

| 调研目的                   | 业务功能                                                     | 调研人       | XXX、XX |
| -------------------------- | ------------------------------------------------------------ | ------------ | ------- |
| 调研时间（日期、起止时间） | 202X-3-20 至202X-3-28                                        | 调研地点     | XXX医院 |
| 调研对象                   | 业务人员                                                     | 调研部门     | 门诊    |
| 调研问题                   | 回答问题                                                     | 备注         |         |
| 挂号窗口的功能             | 对到医院的患者，进行现场挂号、退号、收费（包括各种药品、检查、检验等收费）、退费，以及患者费用的查询。 | 窗口挂号人员 |         |
| 医生坐诊工作管理           | 医生填写患者病历，根据问诊情况初步判断患者病情，根据初步判断开设检查和检验项目；根据患者的检查和检验结果，完成病情确诊；根据患者确诊病情，进行开药或者开立处置（例如：洗胃等），进行治疗 | 门诊医生     |         |
| 药房管理                   | 药品的入库、信息维护等工作；根据患者缴费情况，发药，并录入系统；如果患者退药，将退回的药品入库；查看药品的交易记录 | 药局管理人员 |         |
| 检查科室工作管理           | 根据系统中，医生开出的检查申请，对患者进行检查操作；患者信息录入系统；将完成的检查结果，录入到系统中对应患者名下，提供给医生进行诊断参考；对历史检查结果进行管理； | 检查科医生   |         |
| 检验科室工作管理           | 根据系统中，医生开出的检验申请，对患者进行检验操作；患者信息录入系统；将完成的检验结果，录入到系统中对应患者名下，提供给医生进行诊断参考；对历史检验结果进行管理； | 检验科医生   |         |
| 处置科室工作管理           | 根据系统中，医生开出的处置申请，对患者进行处置操作；患者信息录入系统；将完成的处置结果，录入到系统中对应患者名下，提供给医生进行诊断参考；对历史处置结果进行管理； | 处置科医生   |         |



## 1.5 项目技术

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653283266757-2f6aa095-9e02-4c35-8f23-973d3434c811.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

**前端**

1. **Vue开发前端开发框架**

优势：

- 数据绑定：vue会根据对应的元素进行数据的实时绑定，进行网页及应用的数据渲染 。
- 组件式开发：通过vue的模块封装，它可以将一个web开发中设计的各种模块进行拆分，变成单独的组件，然后通过数据绑定，调用对应模版组件，同时传入参数。

1. **Element UI**

​     ElementUI是一款功能强大的组件工具，体现出非常强大的一致性，在使用过程中有清晰的反馈，而且效率高，可控性强。在本次项目中，大部分组件都是由ElementUI实现的

优势：

- 样式多样，能够轻松的使页面更加美观。
- 文档清晰，使用方便。

**后端**

1. **Springboot+SpringMVC+Spring综合使用**

​    SpringBoot用来简化Spring应用的初始搭建以及开发过程，可以使开发人员不再需要定义样板化的配置，它默认配置了很多框架的使用方式，使Spring的应用更加简便。

​    Spring MVC是一种基于java的框架，实现了Web MVC设计模式的请求驱动类型的轻量框架，能够使编写出更干净、更可管理、并且更易于测试的代码

​      Spring框架是一个开放源代码的JavaEE应用程序框架，它在大小与开销方面都是轻量的，可以通过一种称作控制反转的技术促进低耦合，并且提供了面向切面变成的支持，包含并管理了应用对象的配置和生命周期，可以将简单的组件配置组合成复杂的应用

优势：

- 搭建项目快，几秒钟就可以搭建完成；支持声明式事务处理
- 让测试变的简单
- 让配置变的简单
- 内嵌容器
- 方便监控

1. **MyBatis**

使用XML描述或注释对象与存储过程或SQL语句耦合，使关系数据库与面向对象应用结合起来更加容易

优势：

- 简单易学
- 灵活：Mybatis不会对应用程序或者数据库的现有设计强加任何影响。
- 解除sql与程序代码的耦合

1. **maven**

通过使用maven快速且高频地自动构建项目的所有源码，和实现项目版本依赖。

**数据库**

1. **MySQL**

优势：

- Mysql性能卓越，服务稳定，很少出现宕机。
- 开放源代码，自主性，使用成本低
- 历史悠久，社区用户非常活跃，遇到问题可以寻求帮助。
- 软件体积小，安装使用简单，并且易于维护

**版本控制**

1. **Git**

一个团队或一个项目组可以在上面建立一个库，通过密匙加入其访问和修改，可以将项目上传在库中，供可查看的人查看，大大减少团队合作一个项目的复杂度

优势：

- 离线工作。
- 适合分布式开发，强调个体。
- 公共服务器压力和数据量都不会太大。
- 速度快、灵活。

# 2、需求分析

**一般性需求**

- 完整正确的门诊流程，为用户提供良好的使用体验
- 完全基于浏览器的操作模式，安装简单、操作方便，具有良好的系统扩充能力。
- 灵活的模块需求设计，可根据实训项目周期灵活裁剪。

**功能性需求**

（1）挂号管理：主要用户是窗口挂号人员，主要包含的功能有现场挂号与退号、收费与退费、患者收费信息的查询与管理、发票信息的查看与重打补打、门诊收费的日结记录与日结查询。

（2）坐诊管理：主要用户为坐诊医生，涉及病案管理、处方药模板管理、处置管理等

（3）检查/检验管理：主要用户为检验科医师，涉及检验/检查申请记录查看、检验详情查看、检查结果录入等。

（4）患者药物信息管理：主要用户为药师，涉及药库信息管理、发药管理、退药管理、发退药信息查看。

## 2.1 功能分解

根据需求调研，分解业务功能如下

| 角色     | 备注                                                         |
| -------- | ------------------------------------------------------------ |
| 挂号窗口 | 使用者是窗口挂号人员，主要包含的功能有现场挂号与退号、收费与退费、患者收费信息的查询与管理。 |
| 门诊医生 | 使用者为门诊医生，涉及患者诊疗、开立检查检验项目，开立处方药治疗、开立处置治疗等 |
| 检查医生 | 使用者为检查科医师，涉及检查申请记录查看、检查详情查看、检查结果录入等（医生给患者根据病历要求患者进行的检查项：一般无比对标准，如B超）。 |
| 检验医生 | 使用者为检验科医师，涉及检验申请记录查看、检验详情查看、检验结果录入等。（医生给患者根据病历要求患者进行的检验项：一般有比对标准，如血常规） |
| 处置医生 | 使用者为处置科室医师，涉及处置申请记录查看、处置详情查看、处置结果录入等。（医生给患者根据病历要求患者进行的处置项：一般有治疗作用，如洗胃） |
| 药房管理 | 使用者为药师，涉及药库信息管理、发药管理、退药管理、发退药信息查看。 |

## 2.2 用例图

根据功能分解，确定项目整体角色和用例如下：

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652604533092-aa42b3bc-b526-426c-8afa-738be1dbfb24.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_34%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

## 2.3 流程图

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652920495211-150ab48e-bdc5-4928-886b-ee98629bb8bf.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1655078110627-fd40f6cf-3e84-4f1d-907d-c1676a357629.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)





## 2.4 原型设计：用户角色和菜单

经过分析，本项目设计6个角色，对应整体菜单如下：

### 2.4.1 整体菜单

root权限：可以查看所有功能，但是不要进行业务操作，本权限不是业务角色

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652607833390-aaa45094-05cc-42be-b381-30d2a6a558c1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_11%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 2.4.2 详细菜单

根据权限，有6个不同的角色，32个业务功能，不同角色对应不同的业务功能菜单如下：

| **角色名称** | **功能菜单**                                                 |
| ------------ | ------------------------------------------------------------ |
| 挂号收费员   | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652945785845-98fda00d-c330-44e0-b04b-d05fad5082da.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |
| 门诊医生     | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652945806315-916ce11f-4da4-4dd9-8e68-bfab6ae28d2f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |
| 检查医生     | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652945819503-9c902d43-037c-43d5-905d-9a4121089d71.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |
| 检验医生     | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652945992025-6de69471-7471-4a56-bd49-3e65ad4c3397.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |
| 药房管理员   | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652946003463-862bb068-e7f1-444e-a96f-c29eef98d794.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |
| 处置医生     | ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652946014465-f27a6b8e-2365-4f96-b2c7-7049f7b99b02.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10) |

# 3、系统设计

## 3.1 原型设计：主线流程

本部分使用原型工具Axure RP进行页面绘制，配合文档说明，确认每个界面功能。

### 

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652930790160-cceeaff1-b619-4ba6-9991-50fca66dbb83.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.1.1 挂号收费：窗口挂号

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922854268-548c1ed7-b9e0-4181-a260-762bc9befa16.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652861035273-64000800-e5c1-4aa8-a1fa-04c1e2428a2b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 挂号收费员点击“窗口挂号”菜单；

2. 系统进入现场挂号页面，自动生成“病历号”；

3. 系统默认显示“看诊日期”为当前日期，午别为当前午别，该信息不可修改；

4. 挂号收费员询问患者挂号级别、挂号科室；

5. 挂号收费员根据患者要求，选择对应的“挂号级别”、“挂号科室”；

6. 系统根据挂号级别显示挂号费；

7. 系统根据挂号级别、挂号科室，读取相应科室、相应挂号级别、当前日期、当前午别的出诊医生；

8. 挂号收费员询问患者是否选择挂号医生；

9. 挂号收费员根据患者要求，选择对应的“医生”；

10. 挂号收费员录入患者基本信息，包括：患者姓名、性别、出生日期、年龄、结算类别、身份证号、家庭住址、是否要病历本；

\11. 挂号收费员在录入信息完毕后，单击“挂号”按钮，完成患者挂号；

### 3.1.2 门诊医生：患者查看

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922862209-02c7b092-7ddf-4421-bcfa-88b79a22a7d9.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652861322100-1ef87a9b-cc36-4d4d-86e9-c6c1473672ed.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生登录后，点击导航栏的“患者查看”；

2. 系统进入患者查看页面，顶部显示已经看诊人数和排队人数；
3. 显示登录医生对应挂号的患者列表，根据挂号时间排序分页显示；
4. 门诊医生可以输入患者的病历号或姓名，进行“查询”；
5. 系统显示符合条件的患者列表；
6. 门诊医生点击患者姓名后面的“创建病例“，开始看诊；

### 3.1.3 门诊医生：病历首页

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922874950-7515a275-d8d1-4a0a-af69-8f1bf8c00a0a.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652861742190-3e4a67f6-af59-4945-bd5f-80c04164d165.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生点击导航栏的“病历首页”，对”患者查看“页面选择的患者病例进行填写。页面顶部会显示医生选择的患者基本信息。

  2.门诊医生根据询问患者，在病历首页中填写：主诉、现病史、现病治疗情况、既往史、过敏史、体格检查；

3. 门诊医生进行初步诊断，选择患者疾病；

  4.门诊医生填写检查\检验建议；

  5.门诊医生填写完成后，点击保存完成患者病例首页的填写；

### 3.1.4 门诊医生：检查申请

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922884337-1b3e40e9-68df-4816-8f14-5d4b47f6b783.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652862319132-e1f09939-7e10-433f-befe-382e0b92d1fa.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生点击“检查申请”

2. 系统进入检查申请页面，在病历首页页面部分，显示该患者基本信息；

3. 门诊医生点击新增项目；

4. 系统弹出新增检查项目页面列表，页面包括检查编码、检查名称、检查规格、单价，门诊医生可以按检查编码和检查名称执行查询；

5. 门诊医生在查询结果中，选中要新增的检查项目前面的复选框，所有项目选中之后，点击“添加”按钮；

6. 系统在检查申请页面，填入医生已经选择的项目；

7. 门诊医生输入检查目的要求、检查部位、备注等；

8. 门诊医生点击“申请提交”；

### 3.1.5 挂号收费：收费

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922894120-a4ca7fa8-ea1e-4655-bd57-284145d46e4d.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652862438468-63432bbe-6c58-4f2a-b6f6-0b941f996727.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 挂号收费员点击“收费”；

2. 系统进入患者收费页面；

3. 挂号收费员输入患者的“病历号”后点击”搜索“按钮； 

4. 系统查询出该患者的基本信息；

5. 挂号收费员确认患者姓名是否正确；

6. 系统查询出该患者本次看诊的待缴费项目，并按项目开立时间时间降序排序；

7. 挂号收费员确认患者本次缴纳哪些项目，选中相应项目前面的复选框；

8. 系统自动计算出本次的缴费金额；

9. 挂号收费员点击“收费结算”按钮，完成收费；

### 3.1.6 检查管理：检查申请

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922901644-051bee11-4a8d-4e36-a574-2fd4e2372530.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652862723774-12497676-11ec-4c75-84e4-07e74d1e6adf.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_43%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 检查医生登录后，点击导航栏的“检查申请”；

2. 系统进入检查申请查看页面，顶部显示已经检查人数和排队人数；
3. 显示等待检查的患者列表；
4. 门诊医生可以输入患者的病历号或姓名，进行“查询”；
5. 系统显示符合条件的患者列表；
6. 门诊医生点击患者姓名后面的“进行检查“，检查登记完成；

### 3.1.7 检查管理：患者录入

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922909497-1f8d661d-048f-4fb8-94f0-80e25403a402.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652862938233-22c38c74-2117-42b3-b434-7ca695976792.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 检查医生点击导航栏的“患者录入”，对”检查申请“页面选择的患者的检查项目进行科室和医生的分配。页面顶部会显示医生选择的患者基本信息。
2. 系统会显示选择的患者所有等待检查的项目；

3. 检查医生点击对应项目后，表格下方会显示 已选择的检查项目名称；
4. 检查医生选择录入自己的科室和姓名，确认检查医生信息；
5. 检查医生点击“开始检查”，患者检查录入完成；

### 3.1.8 检查管理：检查结果录入

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922922424-ca1cbe50-95e9-4754-8279-f2a5224e793b.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652863234574-9a529b90-2699-4713-9ed3-306d4ad0a05a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 检查医生点击导航栏的“检查结果录入”。页面显示患者信息；检查医生可以根据患者病历号和患者姓名，进行搜索患者。
2. 检查医生点击患者信息后端的“已完成检查”按钮，会显示该患者所有已经完成的检查项目；
3. 检查医生点击对应项目后，表格下方会显示 已选择的检查项目名称；
4. 检查医生选择录入自己的科室和姓名，确认结果录入医生信息；
5. 检查医生录入检查结果；
6. 检查医生点击“结果提交”完成检查结果录入

### 3.1.9 门诊医生：看诊记录

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652863597903-785493ab-fa4b-4e05-9e25-1c1dd9e9ebab.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生点击导航栏的“看诊记录”；

2. 系统进入患者继续看诊选择页面；
3. 显示登录医生对应已经看诊的患者列表；
4.  门诊医生可以输入患者的病历号或姓名，进行“查询”；
5. 系统显示符合条件的患者列表；
6. 门诊医生点击患者姓名后面的“更新病例“，开始对已出检查结果的患者继续看诊；

### 3.1.10 门诊医生：查看检查结果

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922950045-77482d16-1187-40a0-af4a-68ea077ee670.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652863779862-2fc45786-3bad-4624-b03d-0abd8ce19297.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生点击导航栏的“检查结果”，对”看诊记录“页面选择的患者的检查结果进行查看。页面顶部会显示医生选择的患者基本信息。
2. 系统会显示选择的患者的已经出结果的检查项目；

3. 门诊医生选择检查项目，会看到检查的结果；

### 3.1.11 门诊医生：门诊确诊

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652864000763-225d8470-f25c-4734-8826-c1bf759c87af.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 门诊医生点击导航栏的“门诊确诊”，对”看诊记录“页面选择的患者录入诊断结果和处理意见。

2. 门诊医生选择“确诊提交”，完成患者的病历确诊部分内容填写；

### 3.1.12 门诊医生：开设处方

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652922979932-54dd556b-5df6-48db-94e0-fcfe1820d4f9.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652864126136-a4e45e3f-6f2d-4af2-815f-e1e748366683.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652864175199-239b0456-71ff-4c63-9ca4-3ca1bd425fec.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652864626534-c271bae7-63a1-4c6f-b556-4da28c929508.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1、 门诊医生点击导航栏的“开设处方”，进入处方界面，点击“增加”。

2、 系统弹出“搜索药品界面”

3、 门诊医生输入药品信息（药品编码、药品名称等）后，点击“查询”按钮，查询药品信息

4、 系统显示符合条件的药品列表

5、 门诊医生选择所需药品，点击确定，添加药品到处方中

6、 关闭药品选择对话框，界面显示医生已经选择的药品内容。

7、 门诊医生对药品输入：用法、用量、频次、使用天数、用药嘱托等医嘱信息；输入药品数量

8、 门诊医生可以多次添加药品或删除药品；添加完药品后，门诊医生点击开立处方，完成处方开立。

9、 在主界面中，会有处方金额合计，根据数量改变会自动改变

10、点击每个药品，下拉列表显示药品的详细信息（药品编码、包装单位、生产厂家、药剂类型等）

### 3.1.13 药房管理：药房发药

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652923219028-d357db97-0e65-486c-bdfc-d6ddc80ecf5a.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652923204790-d3777a91-c4ff-4007-b835-b069f1230b33.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1、 发药员点击导航栏的“药房发药”链接。

2、 系统查询并在左侧显示待发药患者列表界面，查询条件包括：病历号、患者姓名；默认状态为“未发”（其他状态：已发、已退、全部）

3、 发药员输入查询信息，点击“查询”

4、 系统显示符合条件的患者列表

5、 发药员选择对应患者

6、 系统显示出该患者的待发药品信息，显示在界面上

7、 发药员点击“发药”按钮。

8、 完毕后会提示发药成功的信息。

9、 发药员给患者药品



## 3.2 原型设计：其他功能：

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/955151/1652930956711-ac8f1e7b-33ac-477c-a60e-3efb7ade6101.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.1、门诊挂号：退费

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931337609-90951d24-79b4-4c31-82d6-f0d2dab0f3f8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.2、门诊挂号：退号

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931374061-aca7e57e-6c29-4b2f-a5e8-4dcd79d80880.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.3、门诊挂号：费用记录查询

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931405131-f8350994-a9e9-4db1-ac26-d5134795d637.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.4、门诊医生：开立检验

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931466429-a631bc8e-0040-40b0-935a-6f644eaa1d30.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.5、门诊医生：开立处置

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931485802-5097b2d3-cfb5-4ad9-bf82-d33ac2750c1d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.6、检查医生：检查管理

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931526154-5e773ead-5be8-40c9-933f-efaee68b7d02.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.7、检验医生：患者叫号

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931548770-8b68cbbc-91db-401e-bf3e-3b3b91a24f53.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.8、检验医生：执行检验

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931580672-52a4be79-b08a-44bf-8857-e2cc23aa6da9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.9、检验医生：录入检验结果

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931594109-962b6275-f304-4e71-a7ce-4bba42c01562.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.10、检验医生：检验管理

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931607094-c870c031-84ed-40ab-b689-5b904e3287c6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.11、药库管理：退药

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931621395-41d4369d-02a0-4463-964a-160b4c334467.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.12、药库管理：药品管理

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931661869-7ddc0f11-4ca0-4e8e-94de-20b4bc585beb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.13、药库管理：交易记录

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931681429-46131a71-dc3c-479c-98fd-7be90d13a618.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.14、处置医生：患者叫号

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931695364-6c592178-85e7-43f8-ad58-6d83b29a011b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.15、处置医生：执行处置

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931706613-100f7cc5-e154-42fb-bbdb-d0012368b328.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.16、处置医生：录入处置结果

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931719919-e70eda78-c640-4dd6-ab8f-2962cb1dcc17.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.2.17、处置医生：处置管理

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652931733417-42a9cf04-86ea-4f14-80d3-984f2bf84ca4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

## 3.3 表设计

### 3.3.1 实体设计：ER图

根据界面功能，确认实体（ER图）

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1652919616256-c16d1e4c-e8cf-4c2c-b5ea-9da7abd86fb9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_34%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.3.2 表设计

根据ER图和界面原型，确认表字段和关联情况

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653296545520-757edac5-8743-408b-8061-ca99bd2d4504.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_42%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)





### 3.3.3 表设计文档

#### 数据表整体设计

| **序号** | **表中文名**       | **表英文名**           | **表功能说明**                                              |
| -------- | ------------------ | ---------------------- | ----------------------------------------------------------- |
| 1        | 医院员工表         | employee               | 保存医院的员工信息（主要是医生）                            |
| 2        | 科室表             | department             | 医生所在的科室，如：骨外科                                  |
| 3        | 挂号级别表         | regist_level           | 保存医生挂号等级（例如：专家号、普通号、主任医生号）        |
| 4        | 结算类别表         | settle_category        | 存放患者的结算类别信息，如：自费、医保、新农合等            |
| 5        | 排班表             | scheduling             | 医生是否出诊（按照星期进行排班，如：周三下午、周五上午出诊) |
| 6        | 患者历次挂号信息表 | register               | 存储患者历次挂号信息                                        |
| 7        | 检查申请表         | check_request          | 检查申请                                                    |
| 8        | 检验申请表         | inspection_request     | 检验申请                                                    |
| 9        | 处置申请表         | disposal_request       | 处置申请                                                    |
| 10       | 医技项目表         | medical_technology     | 医疗技术项目，包括检查、检验、处置等项目                    |
| 11       | 患者病历表         | medical_record         | 医生对患者填写的病例                                        |
| 12       | 病历首页疾病关联表 | medical_record_disease | 病例和疾病关联表                                            |
| 13       | 疾病表             | disease                | 保存疾病信息                                                |
| 14       | 处方表             | prescription           | 医生开立处方信息                                            |
| 15       | 药品信息表         | drug_info              | 保存药品信息                                                |

#### 1、医院员工表：employee

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**                |
| ---------- | ---------------- | ------------ | -------- | ---------- | ----------------------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型              |
| 所在科室id | deptment_id      | INT(9)       | 外键     |            | 指向*department(*id*)*  |
| 挂号级别id | regist_level_id  | INT(9)       | 外键     |            | 指向*regist_level (ID)* |
| 排班id     | scheduling_id    | INT(9)       | 外键     |            |                         |
| 真实姓名   | realname         | VARCHAR(64)  |          |            |                         |
| 密码       | password         | VARCHAR(64)  |          |            |                         |
| 生效标记   | delmark          | INT(1)       |          | 1          | 1-生效0-已删除          |

#### 2、科室表：department 

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**       |
| ---------- | ---------------- | ------------ | -------- | ---------- | -------------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型     |
| 科室编码   | dept_code        | VARCHAR(64)  |          |            | 如：SJNK       |
| 科室名称   | dept_name        | VARCHAR(64)  |          |            | 如：神经内科   |
| 科室类型   | dept_type        | VARCHAR(64)  |          |            |                |
| 生效标记   | delmark          | INT(1)       |          | 1          | 1-正常0-已删除 |

#### 3、挂号级别表：regist_level 

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**       |
| ---------- | ---------------- | ------------ | -------- | ---------- | -------------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型     |
| 号别编码   | regist_code      | VARCHAR(64)  |          |            |                |
| 号别名称   | regist_name      | VARCHAR(64)  |          |            |                |
| 挂号费     | regist_fee       | DECIMAL(8,2) |          |            |                |
| 挂号限额   | regist_quota     | INT(5)       |          |            |                |
| 显示顺序号 | sequence_no      | INT(3)       |          |            |                |
| 生效标记   | delmark          | INT(1)       |          | 1          | 1-正常0-已删除 |

#### 4、结算类别表：settle_category

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**       |
| ---------- | ---------------- | ------------ | -------- | ---------- | -------------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型     |
| 类别编码   | settle_code      | VARCHAR(64)  |          |            |                |
| 类别名称   | settle_name      | VARCHAR(64)  |          |            |                |
| 显示顺序号 | sequence_no      | INT(3)       |          |            |                |
| 生效标记   | delmark          | INT(1)       |          | 1          | 1-正常0-已删除 |

#### 5、排班表： scheduling

| **字段名**   | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**       |
| ------------ | ---------------- | ------------ | -------- | ---------- | -------------- |
| ID           | id               | INT(9)       | 主键     |            | 自增长类型     |
| 排班规则名称 | rule_name        | VARCHAR(64)  |          |            |                |
| 星期规则     | week_rule        | VARCHAR(14)  |          |            |                |
| 生效标记     | delmark          | INT(1)       |          | 1          | 1-正常0-已删除 |

#### 6、患者历次挂号信息表：register

| **字段名**     | **字段****编码**   | **数据类型** | **键值** | **默认值** | **注释**                             |
| -------------- | ------------------ | ------------ | -------- | ---------- | ------------------------------------ |
| ID             | id                 | INT(9)       | 主键     |            | 自增长类型                           |
| 病历号         | case_number        | VARCHAR(64)  |          |            |                                      |
| 姓名           | real_name          | VARCHAR(64)  |          |            |                                      |
| 性别           | gender             | VARCHAR(6)   |          |            | 男/女                                |
| 身份证号       | card_number        | VARCHAR(18)  |          |            |                                      |
| 出生日期       | birthdate          | DATE         |          |            |                                      |
| 年龄           | age                | INT(3)       |          |            |                                      |
| 年龄类型       | age_type           | VARCHAR(6)   |          |            | 年/天                                |
| 家庭住址       | home_address       | VARCHAR(64)  |          |            |                                      |
| 本次看诊日期   | visit_date         | DATETIME     |          |            |                                      |
| 午别           | noon               | VARCHAR(6)   |          |            | 上午/下午                            |
| 本次挂号科室ID | deptment_id        | INT(9)       | 外键     |            | 指向*department(*ID*)*               |
| 本次挂号医生ID | employee_id        | INT(9)       | 外键     |            | 指向employee*(ID)*                   |
| 本次挂号级别ID | regist_level_id    | INT(9)       | 外键     |            | 指向*regist_Level (ID)*              |
| 结算类别ID     | settle_category_id | INT(9)       | 外键     |            | 指向*settle_category(ID)*            |
| 病历本要否     | is_book            | CHAR(2)      |          |            | 是/否                                |
| 收费方式       | regist_method      | VARCHAR(10)  |          |            | 现金、银行卡、医保卡、微信、支付宝   |
| 挂号金额       | regist_money       | DECIMAL(8,2) |          |            |                                      |
| 本次看诊状态   | visit_state        | INT(1)       |          |            | 1-已挂号2-医生接诊3-看诊结束4-已退号 |

#### 7、检查申请表：check_request

| **字段名**     | **字段****编码**       | **数据类型** | **键值** | **默认值** | **注释**   |
| -------------- | ---------------------- | ------------ | -------- | ---------- | ---------- |
| ID             | id                     | INT(9)       | 主键     |            | 自增长类型 |
| 挂号id         | register_id            | INT(9)       | 外键     |            |            |
| 医技项目id     | medical_technology_id  | INT(9)       | 外键     |            |            |
| 目的要求       | check_info             | VARCHAR(512) |          |            |            |
| 检查部位       | check_position         | VARCHAR(255) |          |            |            |
| 开立时间       | creation_time          | datetime     |          |            |            |
| 检查人员id     | check_employee_id      | INT(9)       | 外键     |            |            |
| 结果录入人员id | inputcheck_employee_id | INT(9)       | 外键     |            |            |
| 检查时间       | check_time             | datetime     |          |            |            |
| 检查结果       | check_result           | VARCHAR(512) |          |            |            |
| 状态           | check_state            | VARCHAR(64)  |          |            |            |
| 备注           | check_remark           | VARCHAR(512) |          |            |            |

#### 8、检验申请表：inspection_request 

| **字段名**     | **字段****编码**            | **数据类型** | **键值** | **默认值** | **注释**   |
| -------------- | --------------------------- | ------------ | -------- | ---------- | ---------- |
| ID             | id                          | INT(9)       | 主键     |            | 自增长类型 |
| 挂号id         | register_id                 | INT(9)       | 外键     |            |            |
| 医技项目id     | medical_technology_id       | INT(9)       | 外键     |            |            |
| 目的要求       | inspection_info             | VARCHAR(512) |          |            |            |
| 检验部位       | inspection_position         | VARCHAR(255) |          |            |            |
| 开立时间       | creation_time               | datetime     |          |            |            |
| 检验人员id     | inspection_employee_id      | INT(9)       | 外键     |            |            |
| 结果录入人员id | inputinspection_employee_id | INT(9)       | 外键     |            |            |
| 检验时间       | inspection_time             | datetime     |          |            |            |
| 检验结果       | inspection_result           | VARCHAR(512) |          |            |            |
| 状态           | inspection_state            | VARCHAR(64)  |          |            |            |
| 备注           | inspection_remark           | VARCHAR(512) |          |            |            |

#### 9、处置申请表：disposal_request

| **字段名**     | **字段****编码**          | **数据类型** | **键值** | **默认值** | **注释**   |
| -------------- | ------------------------- | ------------ | -------- | ---------- | ---------- |
| ID             | id                        | INT(9)       | 主键     |            | 自增长类型 |
| 挂号id         | register_id               | INT(9)       | 外键     |            |            |
| 医技项目id     | medical_technology_id     | INT(9)       | 外键     |            |            |
| 目的要求       | disposal_info             | VARCHAR(512) |          |            |            |
| 处置部位       | disposal_position         | VARCHAR(255) |          |            |            |
| 开立时间       | creation_time             | datetime     |          |            |            |
| 处置人员id     | disposal_employee_id      | INT(9)       | 外键     |            |            |
| 结果录入人员id | inputdisposal_employee_id | INT(9)       | 外键     |            |            |
| 处置时间       | disposal_time             | datetime     |          |            |            |
| 处置结果       | disposal_result           | VARCHAR(512) |          |            |            |
| 状态           | disposal_state            | VARCHAR(64)  |          |            |            |
| 备注           | disposal_remark           | VARCHAR(512) |          |            |            |

#### 10、医技项目表：medical_technology

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**   |
| ---------- | ---------------- | ------------ | -------- | ---------- | ---------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型 |
| 项目编码   | tech_code        | VARCHAR(64)  |          |            |            |
| 项目名称   | tech_name        | VARCHAR(64)  |          |            |            |
| 规格       | tech_format      | VARCHAR(64)  |          |            |            |
| 单价       | tech_price       | DECIMAL(8,2) |          |            |            |
| 类型       | tech_type        | VARCHAR(64)  |          |            |            |
| 费用分类   | price_type       | VARCHAR(64)  |          |            |            |
| 执行科室   | deptment_id      | INT(9)       | 外键     |            |            |

#### 11、患者病历表：medical_record

| **字段名**    | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**   |
| ------------- | ---------------- | ------------ | -------- | ---------- | ---------- |
| ID            | id               | INT(9)       | 主键     |            | 自增长类型 |
| 挂号ID        | register_id      | INT(9)       | 外键     |            |            |
| 主诉          | readme           | VARCHAR(512) |          |            |            |
| 现病史        | present          | VARCHAR(512) |          |            |            |
| 现病治疗情况  | present_treat    | VARCHAR(512) |          |            |            |
| 既往史        | history          | VARCHAR(512) |          |            |            |
| 过敏史        | allergy          | VARCHAR(512) |          |            |            |
| 体格检查      | physique         | VARCHAR(512) |          |            |            |
| 检查/检验建议 | proposal         | VARCHAR(512) |          |            |            |
| 注意事项      | careful          | VARCHAR(512) |          |            |            |
| 诊断结果      | diagnosis        | VARCHAR(512) |          |            |            |
| 处理意见      | cure             | VARCHAR(512) |          |            |            |

#### 12、病历首页疾病关联表：medical_record_disease

| **字段名** | **字段****编码**  | **数据类型** | **键值** | **默认值** | **注释** |
| ---------- | ----------------- | ------------ | -------- | ---------- | -------- |
| 病历id     | medical_record_id | INT(9)       | 外键     |            |          |
| 疾病id     | disease_id        | INT(9)       | 外键     |            |          |

#### 13、疾病表：disease

| **字段名**   | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**   |
| ------------ | ---------------- | ------------ | -------- | ---------- | ---------- |
| ID           | id               | INT(9)       | 主键     |            | 自增长类型 |
| 疾病助记编码 | disease_code     | VARCHAR(64)  |          |            |            |
| 疾病名称     | disease_name     | VARCHAR(255) |          |            |            |
| 国际ICD编码  | diseaseICD       | VARCHAR(64)  |          |            |            |
| 疾病所属分类 | disease_category | VARCHAR(64)  |          |            |            |

#### 14、处方表：prescription

| **字段名**   | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**   |
| ------------ | ---------------- | ------------ | -------- | ---------- | ---------- |
| ID           | id               | INT(9)       | 主键     |            | 自增长类型 |
| 病历id       | register_id      | INT(9)       | 外键     |            |            |
| 药品id       | drug_id          | INT(9)       | 外键     |            |            |
| 用法用量频次 | drug_usage       | VARCHAR(255) |          |            |            |
| 数量         | drug_number      | VARCHAR(255) |          |            |            |
| 开立时间     | creation_time    | DATETIME     |          |            |            |
| 状态         | drug_state       | VARCHAR(64)  |          |            |            |

#### 15、药品信息表：drug_info

| **字段名** | **字段****编码** | **数据类型** | **键值** | **默认值** | **注释**   |
| ---------- | ---------------- | ------------ | -------- | ---------- | ---------- |
| ID         | id               | INT(9)       | 主键     |            | 自增长类型 |
| 药品编码   | drug_code        | VARCHAR(255) |          |            |            |
| 药品名称   | drug_name        | VARCHAR(255) |          |            |            |
| 药品规格   | drug_format      | VARCHAR(255) |          |            |            |
| 包装单位   | drug_unit        | VARCHAR(16)  |          |            |            |
| 生产厂家   | manufacturer     | VARCHAR(255) |          |            |            |
| 药剂类型   | drug_dosage      | VARCHAR(64)  |          |            |            |
| 药品类型   | drug_type        | VARCHAR(64)  |          |            |            |
| 药品单价   | drug_price       | DECIMAL(8,2) |          |            |            |
| 拼音助记码 | mnemonic_code    | VARCHAR(255) |          |            |            |
| 创建时间   | creation_date    | DATE         |          |            |            |

## 3.4 项目关键状态图

### 3.4.1 挂号患者状态图

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653360760019-75d2cd00-5573-4566-b0b1-2c450b37b361.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_19%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.4.2 医生开立检查状态图

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653360792483-1726ad42-f17b-4d83-84d0-7d49e3eca8fa.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_20%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.4.1 医生开立检验状态图

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653360806489-ffbd5fbf-d78a-4a82-b58e-7a917342ec78.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_20%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.4.1 医生开立处方状态图

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653360815650-3a1a2422-0c35-473a-bf8a-d625b1712a43.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

### 3.4.1 医生开立处置状态图

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653360824285-b48f3464-4f01-4549-acfa-6eb5da3fb704.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_20%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

## 3.5 模块设计

### 3.5.1 前端模块及页面

- 挂号收费模块：registration

- - onsite_registratiion 窗口挂号
  - registration_record 窗口退号
  - expense_charge 收费
  - expense_refund 退费
  - expense_manage 费用记录查看

- 门诊医生模块：physician

- - physician_patient 患者查看
  - 医生诊疗

- - - home_medical_record 病历首页
    - check_request 检查申请
    - inspection_request 检验申请
    - physician-history 看诊记录
    - check_results 检查结果查看
    - inspection_results 检验结果查看
    - outpatient_diagnosis 门诊确诊
    - write_prescription 开立处方
    - disposal_request 处置申请

- - expense_query 费用查询

- 检查医生模块：check

- - check_apply 检查申请
  - check-patient 患者录入
  - check_input 结果录入
  - check-manage 检查管理

- 检验医生模块：inspection

- - inspection_apply 检验申请
  - inspection_patient 患者录入
  - inspection_input 检验录入
  - inspection_manage 检验管理

- 药库管理模块：drugstore

- - give_medicine 药房发药
  - drug_medicine 药房退药
  - drug_storage 药库管理
  - tran_history 交易记录

- 处置医生模块：disposal

- - disposal_apply 处置申请
  - disposal_patient 患者录入
  - disposal_input 处置录入
  - disposal_manage 处置管理

### 3.5.2 后端模块

1、common：通用模块
2、drugstage：药库管理模块：端口8091
3、outpatient：门诊模块： 端口8092



# 4、系统实现

项目在线演示网址：<http://39.105.101.77:8080/index.html#/>

## 4.1 服务器端项目

### 4.1.1.服务器端项目搭建

#### 4.1.1.1.开发工具检查

1. 开发工具：SpringToolSuite4+（STS）
2. 检查开发工具的jdk配置：jdk8
3. 检查maven构建工具的配置：maven3+
4. 检查开发工具的文件编码配置：utf-8

#### 4.1.1.2.搭建SpringBoot工程

1. 工程类型：

创建maven工程

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653284565604-717992bd-eaca-4761-b02a-abbdaf6ac921.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_15%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

创建maven模块

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653284643466-a114579a-80ed-466c-821f-0abf6736f541.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_15%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



1. pom.xml文件

hismodules/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.neuedu</groupId>
  <artifactId>hismodules</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>
  <modules>
  	<module>his-common</module>
  	<module>his-drugstore</module>
  	<module>his-outpatient</module>
  </modules>
  
  <properties>
  	<java.version>1.8</java.version>
  </properties>
  
  <parent>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-parent</artifactId>
  	<version>2.2.10.RELEASE</version>
  </parent>
  
  <dependencies>
  	<!-- Spring Boot 核心 :Web容器-->
  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-web</artifactId>  		
  	</dependency>
  	
  	<!-- Spring Boot 测试 : JUnit -->
  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-test</artifactId>  		
  	</dependency>
  	
  	<!-- Spring Boot 数据库使用 : MyBatis -->
  	<dependency>
  		<groupId>org.mybatis.spring.boot</groupId>
  		<artifactId>mybatis-spring-boot-starter</artifactId>  	
  		<version>2.0.0</version>	
  	</dependency>
  	
  	<!-- Spring Boot 数据库使用 : MySQL驱动 -->
  	<dependency>
  		<groupId>mysql</groupId>
  		<artifactId>mysql-connector-java</artifactId>  	
  	</dependency>  	
  </dependencies>  
</project>
```

his-outpatient/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <!-- 门诊模块：挂号管理（挂号、退号、收费、退费），医生看诊，对患者进行检查，对患者检验，对患者处置 -->
  <parent>
    <groupId>com.neuedu</groupId>
    <artifactId>hismodules</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>his-outpatient</artifactId>
  <dependencies>
  	<!-- 自定义的通用模块:common -->
  	<dependency>
  		<groupId>com.neuedu</groupId>
  		<artifactId>his-common</artifactId>
		<version>0.0.1-SNAPSHOT</version>
  	</dependency>
  </dependencies>
</project>
```

his-drugstore/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <!-- 药库管理模块：药品管理（增加药品、修改药品、删除药品、查找药品）、给患者发药、给患者退药 -->
  <parent>
    <groupId>com.neuedu</groupId>
    <artifactId>hismodules</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>his-drugstore</artifactId>
  <dependencies>
  	<!-- 自定义的通用模块:common -->
  	<dependency>
  		<groupId>com.neuedu</groupId>
  		<artifactId>his-common</artifactId>
		<version>0.0.1-SNAPSHOT</version>
  	</dependency>
  </dependencies> 
</project>
```

his-common/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <!-- 通用模块：给业务模块进行支撑 -->
  <parent>
    <groupId>com.neuedu</groupId>
    <artifactId>hismodules</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  
  <!-- 设置jar包 -->
  <packaging>jar</packaging>
  <artifactId>his-common</artifactId>
  <name>his-common</name>
</project>
```

1. 工程目录结构

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653284940870-7b9d820b-3339-4a92-aa30-24cf2df77a71.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. SpringBoot入口文件

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653285097900-974bd219-8f93-460b-ae89-e6691b99608d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_32%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653285118972-c3ad5da0-542c-4e1a-b3e0-0b50d70e83f9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. application.properties配置文件:

```properties
# 数据库连接配置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/his01?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&useUnicode=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

# MyBatis配置
mybatis.mapper-locations=classpath:/mapper/*.xml

# 设置端口号
server.port=8091
# 数据库连接配置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/his01?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&useUnicode=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

# MyBatis配置
mybatis.mapper-locations=classpath:/mapper/*.xml

# 设置端口号
server.port=8092
```



### 4.1.2.服务器端代码

参考项目源代码。

## 4.2.前端项目

### 4.2.1.前端项目搭建

#### 4.2.1.1.开发工具检查

1. 检查vscode是否安装成功。
2. 检查npm安装环境： 命令行下输入：npm -v
3. 检查VueCli安装环境：命令行下输入：vue -V （注意：本工程使用VueCli3版本）

附录：

1. 安装npm：直接安装node.js （输入 "npm -v" 测试是否安装成功； 输入 node –v 查看node版本）
2. 全局安装vuecli：npm install -g @vue/cli@3.11 
3. 查看当前安装的vue-cli版本：vue --version 或 vue –V
4. 卸载旧版本的vue-cli：npm uninstall vue-cli -g
5. 查看远程仓库中的版本号：npm view @vue/cli versions --json

#### 4.2.1.2.搭建VueCli工程

1. 命令行下进入工作空间目录中，输入： vue create hisclient（工程名必须小写）
2. 选择预设模板：这里选择“Manually select features”（手动选择特征）

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653291330772-edc4f9ef-8275-4e32-afe5-c3211e1905af.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_13%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 模块选取：Babel、Router

![img](https://cdn.nlark.com/yuque/0/2022/png/955151/1653291365248-2b8d9f50-fe27-45e3-bbe5-696708d43d79.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_16%2Ctext_TmV1ZWR1%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

1. 选择是否使用history 形式的路由：选择：N
2. 将依赖文件放在package.json中：选择：“in package.json”
3. 是否将当前选择保存以备下次使用：选择：N
4. 进入创建好的工程目录：cd hisclient 
5. 启动工程：npm run serve 
6. 在浏览器中测试：<http://localhost:8080>

#### 4.2.1.3.添加其它依赖及配置文件

1. 添加element与axios依赖：

npm install element-ui  --save 

npm install axios --save

#### 4.2.1.4.main.js文件

```javascript
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import Axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false

Vue.use(ElementUI);
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$http = Axios;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
```

#### 4.2.1.5.index.vue文件

注意：在layout/index.vue文件中，完成项目主界面。

```html
<template>
  <!-- 项目主界面 -->
  <el-container>
    <!-- 主界面的标题栏 -->
    <el-header style="background-color: #20A0FF;">
      <div style="display:flex;justify-content:space-between">
        <div style="display:flex">
          <div class="home-title-text" style="width:220px">东软云医院HIS系统</div>
          <div class="home-title-icon"><i class="el-icon-s-fold"></i></div>
        </div>
        <div style="display:flex">                    
          <div class="home-title-img">
            <el-image src="logo.png" fit="contain "></el-image>    
          </div>
          <div class="home-title-menu" style="width:150px">
            <el-dropdown @command="dropdownClick">
              <span class="el-dropdown-link">
                {{titleUserName}}<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown" >
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item divided command="logout">退出</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown> 
          </div>
        </div>
      </div>
    </el-header>
    <el-container style="height:1000px">
      <el-aside style="background-color: #D3DCE6;" width="240px">
        <el-menu default-active="1" class="el-menu-demo" style="background-color: #ECECEC" mode="vertical" router >
          <el-submenu :index="''+index" v-for="(item,index) in this.menuList" :key="index"
                      v-if="!item.hidden && (item.meta.type == dept_type || dept_type == 'root')" >
            <template slot="title"><i :class="item.iconCls"></i><span>{{item.name}}</span></template>
            <el-menu-item :index="child.path" v-for="(child,cindex) in item['children']" :key="cindex">
              <span>{{child.name}}</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main style="background-color: #E9EEF3;">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
  
  export default ({
    mounted: function(){
      this.menuList = this.$router.options.routes;
      let loginUser = sessionStorage.getItem("loginUser");
      if(loginUser !=null && loginUser.length>0){
        loginUser = JSON.parse(loginUser);
        this.titleUserName = loginUser.realname;
        this.dept_type = loginUser.dept_type;
      }
    },
    methods:{
      dropdownClick(commond){
        if(commond == "logout"){
          sessionStorage.removeItem("loginUser");
          sessionStorage.removeItem("Flag");
          //退出跳转到指定页面
          location.href="http://39.105.101.77:8080/index.html";
        }           
      }
    },
    data(){
      return{
        menuList:[],
        titleUserName:"东软医生",
        dept_type:''//部门类型
      }
    }
  })
</script>

<style scoped>
  .home-title-text {
    color: #FFFFFF;
    font-size: 22px;
    margin-top: 15px;
    text-align: left;
  }
  .home-title-icon {
    margin-top: 15px;
    width: 40px;
    font-size: 22px;
  }
  .home-title-img{
    margin-top: 10px;
  }
  .home-title-menu{
    margin-top: 15px;
  }
  .el-dropdown-link {
    cursor: pointer;
    color: #FFFFFF;
    font-size: 20px;
  }
  .el-icon-arrow-down {
    font-size: 20px;
  }
</style>
```

#### 4.2.1.6.路由index.js文件

```javascript
import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../layout/index.vue'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    hidden:true,
    component: Login,
    meta: {
      isLogin: false
    }
  },{
    path: '/login',
    name: 'Login',
    hidden:true,
    component: Login,
    meta: {
      isLogin: false
    }
  },{
    path: '/home',
    name: 'Layout',
    hidden:true,
    component: Layout,
    meta: {
      isLogin: true
    }
  },{
    path: '/',
    name: '挂号收费',
    component: Layout,
    iconCls:"el-icon-document",
    meta: {
      type: "财务"
    },
    children:[      
      {
        path: '/onsite-registration',
        name: '窗口挂号',
        component: () => import('../views/registration/onsite_registration.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/registration-record',
        name: '窗口退号',
        component: () => import('../views/registration/registration_record.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/expense-charge',
        name: '收费',
        component: () => import('../views/registration/expense_charge.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/expense-refund',
        name: '退费',
        component: () => import('../views/registration/expense_refund.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/expense-manage',
        name: '费用记录查询',
        component: () => import('../views/registration/expense_manage.vue'),
        meta: {
          isLogin: true
        }
      },
    ]
  },{
    path: '/',
    name: '门诊医生',
    component: Layout,
    iconCls:"el-icon-user",
    meta: {
      type: "门诊"
    },
    children:[      
      {
        path: '/physician-patient',
        name: '患者查看',
        component: () => import('../views/physician/physician_patient.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/home_medical_record',
        name: '医生诊疗：病历首页',
        component: () => import('../views/physician/patient/home_medical_record.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/check_request',
        name: '医生诊疗：检查申请',
        component: () => import('../views/physician/patient/check_request.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/inspection_request',
        name: '医生诊疗：检验申请',
        component: () => import('../views/physician/patient/inspection_request.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/physician-history',
        name: '看诊记录',
        component: () => import('../views/physician/physician_history.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/check_results',
        name: '医生诊疗：检查结果',
        component: () => import('../views/physician/patient/check_results.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/inspection_results',
        name: '医生诊疗：检验结果',
        component: () => import('../views/physician/patient/inspection_results.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/outpatient_diagnosis',
        name: '医生诊疗：门诊确诊',
        component: () => import('../views/physician/patient/outpatient_diagnosis.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/write_prescription',
        name: '医生诊疗：开设处方',
        component: () => import('../views/physician/patient/write_prescription.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/disposal_request',
        name: '医生诊疗：处置申请',
        component: () => import('../views/physician/patient/disposal_request.vue'),
        meta: {
          isLogin: true
        }
      },
      {
        path: '/expense_query',
        name: '医生诊疗：费用查询',
        component: () => import('../views/physician/patient/expense_query.vue'),
        meta: {
          isLogin: true
        }
      },
      
    ]
  },{
    path: '/',
    component: Layout,
    name: '检查管理',
    iconCls: 'el-icon-camera',
    meta: {
      type: "检查"
    },
    children: [
      {
        path: '/check-apply',
        name: '检查申请',
        component: () => import('../views/check/check_apply.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/check-patient',
        name: '患者录入',
        component: () => import('../views/check/check_patient.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/check-input',
        name: '检查结果录入',
        component: () => import('../views/check/check_input.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/check-manage',
        name: '检查管理',
        component: () => import('../views/check/check_manage.vue'),
        meta: {
          isLogin: true
        }
      }
    ]
  },{
    path: '/',
    component: Layout,
    name: '检验管理',
    iconCls: 'el-icon-headset',
    meta: {
      type: "检验"
    },
    children: [
      {
        path: '/inspection-apply',
        name: '检验申请',
        component: () => import('../views/inspection/inspection_apply.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/inspection-patient',
        name: '患者录入',
        component: () => import('../views/inspection/inspection_patient.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/inspection-input',
        name: '检验结果录入',
        component: () => import('../views/inspection/inspection_input.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/inspection-manage',
        name: '检验管理',
        component: () => import('../views/inspection/inspection_manage.vue'),
        meta: {
          isLogin: true
        }
      }
    ]
  },{
    path: '/',
    component: Layout,
    name: '药房管理',
    iconCls: 'el-icon-wallet',
    meta: {
      type: "药房"
    },
    children: [
      {
        path: '/give-medicine',
        name: '药房发药',
        component: () => import('../views/drugstore/give_medicine.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/refund_medicine',
        name: '药房退药',
        component: () => import('../views/drugstore/refund_medicine.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/drug-storage',
        name: '药库管理',
        component: () => import('../views/drugstore/drug_storage.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/tran-history',
        name: '交易记录',
        component: () => import('../views/drugstore/tran_history.vue'),
        meta: {
          isLogin: true
        }
      }
    ]
  },{
    path: '/',
    component: Layout,
    name: '处置管理',
    iconCls: 'el-icon-first-aid-kit',
    meta: {
      type: "处置"
    },
    children: [
      {
        path: '/disposal-apply',
        name: '处置申请',
        component: () => import('../views/disposal/disposal_apply.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/disposal-patient',
        name: '患者录入',
        component: () => import('../views/disposal/disposal_patient.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/disposal-input',
        name: '处置录入',
        component: () => import('../views/disposal/disposal_input.vue'),
        meta: {
          isLogin: true
        }
      },{
        path: '/disposal-manage',
        name: '处置管理',
        component: () => import('../views/disposal/disposal_manage.vue'),
        meta: {
          isLogin: true
        }
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
```

### 4.2.2.前端代码

参考项目源代码。