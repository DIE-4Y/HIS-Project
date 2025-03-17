package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.pojo.Register;

public interface RegisterService {
    Integer insert(Register register);

    Integer getMaxId();


    PageBean findAllRegistersByEmployee(Integer empId, Integer pageNumber, Integer pageSize, String caseNumber,String realName, Integer state);

    Integer getAllCountByIdAndState(Integer id, int state);

    void updateVisitState(Register register, Integer state);
}
