package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.MedicalTechnologyMapper;
import edu.nenu.hisserver.pojo.Disease;
import edu.nenu.hisserver.pojo.MedicalTechnology;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.service.MedicalTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalTechnologyServiceImpl implements MedicalTechnologyService {

    @Autowired
    private MedicalTechnologyMapper medicalTechnologyMapper;

    @Override
    public PageBean getAllMedicalTechnology(Integer id, String name, Integer pageNumber, Integer pageSize) {
        // 1.分页参数设置
        PageHelper.startPage(pageNumber, pageSize);
        // 2.获取所欲疾病列表
        List<MedicalTechnology> medicalTechnologyList =  medicalTechnologyMapper.getAllMedicalTechnology(id, name);
        Page<MedicalTechnology> p = (Page<MedicalTechnology>) medicalTechnologyList;

        // 3.开始分页
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }
}
