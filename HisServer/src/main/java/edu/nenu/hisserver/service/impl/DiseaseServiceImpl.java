package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.DiseaseMapper;
import edu.nenu.hisserver.pojo.Disease;
import edu.nenu.hisserver.pojo.MedicalRecordDisease;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseMapper diseaseMapper;

    @Override
    public PageBean getAllDisease(Integer id, String diseaseName, Integer pageNumber, Integer pageSize) {
        // 1.分页参数设置
        PageHelper.startPage(pageNumber, pageSize);
        // 2.获取所欲疾病列表
        List<Disease> diseaseList =  diseaseMapper.getAllDisease(id, diseaseName);
        Page<Disease> p = (Page<Disease>) diseaseList;

        // 3.开始分页
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

}
