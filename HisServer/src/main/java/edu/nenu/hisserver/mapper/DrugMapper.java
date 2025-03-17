package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.DrugInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DrugMapper {

    // 根据名称和记助码获取所有药品信息
    List<DrugInfo> findByNameAndCode(@Param("drugName") String drugName,@Param("drugCode") String drugCode);
}
