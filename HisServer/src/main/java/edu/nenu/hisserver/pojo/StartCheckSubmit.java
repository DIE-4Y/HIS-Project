package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartCheckSubmit {
    Integer registerId;
    Integer deptId;
    Integer empId;
    LocalDateTime checkTime;
    List<Integer> medicalTechnologyIdList;
}
