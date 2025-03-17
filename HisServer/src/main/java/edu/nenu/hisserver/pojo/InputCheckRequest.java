package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputCheckRequest {
    Integer registerId;
    Integer empId;
    ArrayList<Integer> medicalTechnologyIdList;
    String checkResult;
}
