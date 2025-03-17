package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.DrugMapper;
import edu.nenu.hisserver.pojo.DrugInfo;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public PageBean getAllDrug(String drugName, String drugCode, Integer pageSize, Integer pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        List<DrugInfo> drugInfoList = drugMapper.findByNameAndCode(drugName, drugCode);
        Page<DrugInfo> p =(Page<DrugInfo>) drugInfoList;
        return new PageBean(p.getTotal(), p.getResult());
    }
}
