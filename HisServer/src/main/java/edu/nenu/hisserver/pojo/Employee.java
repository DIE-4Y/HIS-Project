package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Integer id;
	private String realname;
	private String password;
	private Integer deptmentId;
	private Integer registLevelId;
	private Integer schedulingId;
	private Integer delmark;
	private Integer role;
	private List<Permit> permitList;
	private String token;
}
