package com.autotrade.entityVo;
/**
 * 
 *
 * @ClassName: StaffVo

 * @description 员工Vo
 *
 * @author lishaozhang
 * @createDate 2019年2月13日
 */
public class StaffVo {
	/*SELECT s.id,s.name,s.phone,s.address,d.department COUNT(*) 
	FROM t_staff AS s INNER JOIN t_department AS d WHERE s.department_id = d.id AND s.id =2*/
	
	    private Long id;

	    private String name;

	    private String phone;

	    private String address;

	    private String postId;

	    private String departmentId;

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
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPostId() {
			return postId;
		}

		public void setPostId(String postId) {
			this.postId = postId;
		}

		public String getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		@Override
		public String toString() {
			return "StaffVo [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", postId="
					+ postId + ", departmentId=" + departmentId + "]";
		}
	    
	    
	    
	    
}
