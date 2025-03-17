package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Disease;
import edu.nenu.hisserver.pojo.MedicalTechnology;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalTechnologyMapper {

    // 分页查询获取所有体检项目
    List<MedicalTechnology> getAllMedicalTechnology(@Param("id") Integer id, @Param("name") String name);
}
