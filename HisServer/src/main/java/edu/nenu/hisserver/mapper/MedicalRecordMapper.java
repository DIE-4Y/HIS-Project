package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.MedicalRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {

    // 添加MedicalRecord
    @Insert("insert into medical_record (register_id, readme, present, present_treat, history, allergy, physique, proposal, careful, diagnosis, cure) " +
            "values (#{registerId},#{readme},#{present},#{presentTreat},#{history},#{allergy},#{physique},#{proposal},#{careful},#{diagnosis},#{cure});")
    void insertMedicalRecord(MedicalRecord medicalRecord);

    // 获取最近添加的MedicalRecord
    @Select("select id from medical_record " +
            "where register_id = #{registerId} and medical_record.readme=#{readme} and present=#{present} and present_treat=#{presentTreat} and history=#{history} and allergy=#{allergy} and physique=#{physique} and proposal=#{proposal} and careful=#{careful} and diagnosis=#{diagnosis} and cure=#{cure} " +
            "order by id desc limit 1")
    Integer findLatestInsertId(MedicalRecord medicalRecord);

    // 添加病历表和疾病id
    void insertByMedicalIdAndDiseaseId(@Param("medicalRecordId") Integer medicalRecordId,@Param("diseaseIdList") List<Integer> diseaseIdList);

    // 根据registerId更新MedicalRecord
    void updateMedicalRecord(MedicalRecord medicalRecord);
}
