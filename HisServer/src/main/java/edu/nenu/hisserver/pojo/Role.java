package edu.nenu.hisserver.pojo;

public class Role {
	private Integer id;
	private String roleName;
	private String roleDesc;
	private Integer delmark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Integer getDelmark() {
		return delmark;
	}
	public void setDelmark(Integer delmark) {
		this.delmark = delmark;
	}
	
}
