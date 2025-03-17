package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.DrugstoreMapper;
import edu.nenu.hisserver.pojo.DrugInfo;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.pojo.Register;
import edu.nenu.hisserver.service.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DrugstoreServiceImpl implements DrugstoreService {
    @Autowired
    private DrugstoreMapper drugstoreMapper;

    @Override
    public PageBean getAllRegisterByState(String caseNumber, String realName, Integer pageNumber, Integer pageSize, String state) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Register> registerList = drugstoreMapper.getAllRegisterByState(caseNumber, realName, state);
        Page<Register> registerPage = (Page<Register>) registerList;
        return new PageBean(registerPage.getTotal(), registerPage.getResult());
    }

    @Override
    public List<Map<String, Object>> getAllDrugByRegisterId(Integer registerId) {
        return drugstoreMapper.getAllDrugByRegisterId(registerId);
    }
}
