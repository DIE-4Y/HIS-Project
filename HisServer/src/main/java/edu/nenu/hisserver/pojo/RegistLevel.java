package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistLevel {
	private Integer id;
	private String registCode;
	private String registName;
	private Double registFee;
	private Integer registQuota;
	private Integer sequenceNo;
	private Integer delmark;

}
