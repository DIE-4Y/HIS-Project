package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequest {
	private Integer id;
	private Integer registerId;
	private Integer medicalTechnologyId;
	private String checkInfo;
	private String checkPosition;
	private LocalDateTime creationTime;
	private Integer checkEmployeeId;
	private Integer inputcheckEmployeeId;
	private LocalDateTime checkTime;
	private String checkResult;
	private String checkState;
	private String checkRemark;
	private MedicalTechnology medicalTechnology;
	private Employee checkEmployeee;
	private Employee resultEmployee;
}
