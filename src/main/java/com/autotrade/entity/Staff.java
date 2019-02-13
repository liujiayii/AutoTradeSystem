package com.autotrade.entity;
/**
 * 
 *
 * @ClassName: Staff

 * @description 员工表实体类
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
public class Staff {
    private Long id;

    private String name;

    private String phone;

    private String address;

    private Integer postId;

    private Integer departmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", postId=" + postId
				+ ", departmentId=" + departmentId + "]";
	}
    
}