package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.RegisterMapper;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.pojo.Register;
import edu.nenu.hisserver.service.RegisterService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public Integer insert(Register register) {
        try {
            if (register.getIsBook().equals("true")) {
                register.setIsBook("是");
            } else {
                register.setIsBook("否");
            }
            registerMapper.insertRegister(register);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public Integer getMaxId() {
        String maxId = registerMapper.getMaxCaseNumber();
        return Integer.parseInt(maxId) + 1;
    }

    @Override
    public PageBean findAllRegistersByEmployee(Integer empId, Integer pageNumber, Integer pageSize, String caseNumber, String realName, Integer state) {
//    public PageBean findAllRegistersByEmployee(Integer currentPage, Integer pageSize, Integer registerId, String realName) {
        // 1.设置分页参数
        PageHelper.startPage(pageNumber, pageSize);

        // 2.执行查询
        List<Register> registerList = registerMapper.findAllRegistersByEmployee(empId, caseNumber, realName, state);
        Page<Register> p = (Page<Register>) registerList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /**
     * 通过员工id和患者状态查询数量
     *
     * @param id    员工id
     * @param state 患者状态
     */
    @Override
    public Integer getAllCountByIdAndState(Integer id, int state) {
        return registerMapper.getCountsByIdAndState(id, state);
    }

    @Override
    public void updateVisitState(Register register, Integer state) {
        registerMapper.updateVisitState(register.getCaseNumber(), register.getRealName(), state);
    }

}
