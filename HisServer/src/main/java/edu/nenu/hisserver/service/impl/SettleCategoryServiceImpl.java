package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.SettleCategoryMapper;
import edu.nenu.hisserver.pojo.SettleCategory;
import edu.nenu.hisserver.service.SettleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettleCategoryServiceImpl implements SettleCategoryService {
    @Autowired
    private SettleCategoryMapper settleCategoryMapper;

    @Override
    public List<SettleCategory> findAllSettleName() {
        return settleCategoryMapper.findAllSettleName();
    }

}
