package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Disease;
import edu.nenu.hisserver.pojo.MedicalRecordDisease;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiseaseMapper {

    /**
     * 分页查询疾病
     * */
    List<Disease> getAllDisease(@Param("id") Integer id,@Param("diseaseName") String diseaseName);

}
