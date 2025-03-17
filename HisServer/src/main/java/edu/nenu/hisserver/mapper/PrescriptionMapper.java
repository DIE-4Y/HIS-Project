package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Prescription;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PrescriptionMapper {

    // 插入开立数据
    void insert(@Param("prescriptionList") List<Prescription> prescriptionList);

    // 修改开药状态
    @Update("update prescription set drug_state = #{drugState} where register_id=#{registerId} and drug_id=#{drugId}")
    void updateState(Prescription prescription);
}
