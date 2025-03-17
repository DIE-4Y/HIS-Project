package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface CheckRequestMapper {

    @Update(" update check_request set check_state=#{checkState} where id = #{id}")
    void updateState(@Param("id") Integer id, @Param("checkState") String checkState);

    @Insert("insert into check_request(register_id, medical_technology_id,check_info,check_position,creation_time, check_state,check_remark) " +
            "values (#{registerId}, #{medicalTechnologyId}, #{checkInfo}, #{checkPosition}, #{creationTime},#{checkState}, #{checkRemark})")
    void insertCheckRequestInfo(CheckRequest checkRequest);

    // 获取所有未交费项目
    List<Map<String, Object>> getAllMedicalTechnology(@Param("caseNumber") String caseNumber, @Param("name") String name, @Param("state") String state);

    // 修改为缴费状态
    void updateSettlementState(@Param("checkRequestIdList") List<Integer> checkRequestIdList, @Param("checkState") String checkState);

    // 获取已看诊人数
    @Select("select count(*) from check_request where check_state=#{state} and check_time between #{startOfDay} and #{endOfDay}")
    Integer getAllCheckedCount(@Param("state") String state, @Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);

    // 获取所有排队人员
    @Select("select r.id, r.case_number, r.real_name, r.gender, r.card_number, r.birthday, r.age, r.age_type, r.home_address, r.visit_date, r.noon, r.deptment_id, r.employee_id, r.regist_level_id, r.settle_category_id, r.is_book, r.regist_method, r.visit_state, r.regist_money " +
            "from register r join check_request cr on r.id=cr.register_id where cr.check_state=#{state}")
    List<Register> getAllPeopleInLine(@Param("state") String state);

    List<Register> findByCaseNumberAndName(@Param("caseNumber") String caseNumber, @Param("name") String name, @Param("state") String state);

    // 获取所有检验项目
    @Select("select mt.id, mt.tech_code, mt.tech_name, mt.tech_format, mt.tech_price, mt.tech_type, mt.price_type, mt.deptment_id " +
            "from medical_technology mt join check_request cr on mt.id = cr.medical_technology_id " +
            "join register r on cr.register_id = r.id where r.case_number=#{caseNumber} and cr.check_state=#{state}")
    List<MedicalTechnology> findMedicalTechnologyByCaseNumber(@Param("caseNumber") String caseNumber, @Param("state") String state);

    // 更新check_state和其他部分信息状态
    void updateCheckState(StartCheckSubmit startCheckSubmit);

    // 修改检查结果
    void updateInputCheck(@Param("registerId") Integer registerId, @Param("empId") Integer empId, @Param("medicalTechnologyIdList") List<Integer> medicalTechnologyIdList, @Param("checkResult") String checkResult);

    // 根据检查状态和id获取所有项目细节
    @Select("select cr.creation_time creationTime, e.realname realName, cr.check_position checkPosition, cr.check_info checkInfo, cr.check_remark checkRemark, cr.check_result checkResult, cr.check_time checkTime from check_request cr join his01.employee e on e.id = cr.check_employee_id where cr.register_id=#{registerId} and cr.medical_technology_id=#{medicalTechnologyId} and cr.check_state=#{checkState}")
    Map<String, Object> getAllMedicalTechnologyDetail(@Param("registerId") Integer registerId, @Param("medicalTechnologyId") Integer medicalTechnologyId, @Param("checkState") String checkState);
}
