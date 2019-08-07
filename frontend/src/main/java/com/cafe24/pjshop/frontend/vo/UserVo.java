package com.cafe24.pjshop.frontend.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.pjshop.validator.constraints.ValidGender;
import com.cafe24.pjshop.validator.constraints.ValidId;
import com.cafe24.pjshop.validator.constraints.ValidName;
import com.cafe24.pjshop.validator.constraints.ValidPassword;
import com.cafe24.pjshop.validator.constraints.ValidPhone;

public class UserVo {
	private Long no;
	
	@ValidId
	private String id;

	@ValidPassword
	private String password;
	
	@ValidName
	private String name;

	@ValidPhone
	private String phone;
	
	@Email(message="잘못된 이메일 형식입니다.")
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	
	private String birth;
	
	@ValidGender
	private String gender;
	
	private String role = "ROLE_USER";
	
	public UserVo() {
	}

	public UserVo(Long no, String id, String password, String name, String phone, String email, String birth,
			String gender, String role) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.role = role;
	}

	public UserVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", birth=" + birth + ", gender=" + gender + ", role=" + role + "]";
	}

	
	
	
}
