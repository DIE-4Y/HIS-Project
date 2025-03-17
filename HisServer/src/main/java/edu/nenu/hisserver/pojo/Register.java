package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
	private Integer id;
	private String caseNumber;
	private String realName;
	private String gender;
	private String cardNumber;
	private Date birthday;
	private Integer age;
	private String ageType;
	private String homeAddress;
	private Date visitDate;
	private String noon;
	private Integer deptmentId;
	private Integer employeeId ;
	private Integer registLevelId;
	private Integer settleCategoryId;
	private String isBook;
	private String registMethod;
	private Integer visitState;
	private Double registMoney; 
	private List<CheckRequest> checkRequestList =null;

}
