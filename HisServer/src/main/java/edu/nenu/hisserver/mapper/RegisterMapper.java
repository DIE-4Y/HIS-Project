package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Register;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegisterMapper {

    @Insert("insert into register(case_number, real_name, gender, card_number, birthday, age, age_type,home_address, visit_date, noon,deptment_id,employee_id, regist_level_id, settle_category_id, is_book, regist_method, regist_money,visit_state)" +
            " values(#{caseNumber},#{realName},#{gender},#{cardNumber},#{birthday},#{age},#{ageType},#{homeAddress},#{visitDate},#{noon},#{deptmentId},#{employeeId},#{registLevelId},#{settleCategoryId},#{isBook}, #{registMethod},#{registMoney}, 1)")
    void insertRegister(Register register);

    @Select("select case_number from register ORDER BY id DESC LIMIT 1")
    String getMaxCaseNumber();

    // 根据empId caseNumber realName visitState查询所的病人
    List<Register> findAllRegistersByEmployee(@Param("empId") Integer empId, @Param("caseNumber") String caseNumber, @Param("realName") String realName, @Param("state")Integer state);

    //通过员工id和患者状态查询数量
    @Select("SELECT COUNT(*) FROM register r JOIN employee e ON r.employee_id = e.id\n" +
            " WHERE e.id=#{id} AND r.visit_state=#{state} AND DATE(r.visit_date) = DATE(NOW())")
    Integer getCountsByIdAndState(@Param("id") Integer id, @Param("state") int state);

    // 根据姓名和caseNumber修改visit状态
    @Update("update register set visit_state=#{state} where case_number=#{caseNumber} and real_name=#{realName}")
    void updateVisitState(@Param("caseNumber") String caseNumber,@Param("realName") String realName,@Param("state") Integer state);
}
