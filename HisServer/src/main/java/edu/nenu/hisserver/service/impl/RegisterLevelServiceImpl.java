package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.RegisterLevelMapper;
import edu.nenu.hisserver.pojo.RegistLevel;
import edu.nenu.hisserver.service.RegisterLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterLevelServiceImpl implements RegisterLevelService {

    @Autowired
    private RegisterLevelMapper registerLevelMapper;

    public List<RegistLevel> findAllRegistLevel() {

        return registerLevelMapper.findAllRegistLevel();
    }

}
