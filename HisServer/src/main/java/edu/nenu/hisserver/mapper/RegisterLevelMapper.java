package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.RegistLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterLevelMapper {


    List<RegistLevel> findAllRegistLevel();
}
