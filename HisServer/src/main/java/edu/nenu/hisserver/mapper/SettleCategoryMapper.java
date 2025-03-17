package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.SettleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SettleCategoryMapper {

    @Select("select * from settle_category")
    List<SettleCategory> findAllSettleName();
}