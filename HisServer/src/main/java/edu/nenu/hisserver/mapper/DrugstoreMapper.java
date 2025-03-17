package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.DrugInfo;
import edu.nenu.hisserver.pojo.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface DrugstoreMapper {

    // 根据state获取所有已缴费人员
    List<Register> getAllRegisterByState(@Param("caseNumber") String caseNumber, @Param("realName") String realName, @Param("state") String state);

    // 根据患者id获取所有已缴费药品
    @Select("select p.drug_id drugId, di.drug_code drugCode, di.drug_name drugName,di.drug_format drugFormat, di.drug_unit drugUnit, di.manufacturer,di.drug_price drugPrice,p.drug_number drugNumber from drug_info di " +
            "join prescription p on di.id= p.drug_id where p.register_id=#{registerId}")
    List<Map<String, Object>> getAllDrugByRegisterId(Integer registerId);
}