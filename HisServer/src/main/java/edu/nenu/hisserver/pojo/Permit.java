package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permit {
	private Integer id;
	private String permitName;
	private String permitPath;
	private String permitIcon;
	private Integer permitParent;
	private Integer relmark;
	//关联属性
	private List<Permit> children;
}
