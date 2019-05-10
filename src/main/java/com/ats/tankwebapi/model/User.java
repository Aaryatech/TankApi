package com.ats.tankwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name = "m_user")
	public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_id")
		private int userId;
		
		@Column(name="user_name")
		private String userName;
		
		@Column(name="date_of_birth")
		private String dateOfBirth;
		
		@Column(name="designation")
		private String designation;
		
		@Column(name="is_used")
		private int isUsed;	
		
		@Column(name="del_status")
		private int delStatus;
		
		@Column(name="mobile_number")
		private String mobileNumber;
		
		@Column(name="password")
		private String password;	
		
		@Column(name = "ex_int1")
		private Integer exInt1;

		@Column(name = "ex_int2")
		private Integer exInt2;

		@Column(name = "ex_int3")
		private Integer exInt3;

		@Column(name = "ex_var1")
		private String exVar1;

		@Column(name = "ex_var2")
		private String exVar2;

		@Column(name = "ex_var3")
		private String exVar3;

		@Column(name="ex_float1")
		private float exFloat1;
		
		@Transient
		private String msg;
		
		@Transient
		private boolean isError;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public int getIsUsed() {
			return isUsed;
		}

		public void setIsUsed(int isUsed) {
			this.isUsed = isUsed;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getExInt1() {
			return exInt1;
		}

		public void setExInt1(Integer exInt1) {
			this.exInt1 = exInt1;
		}

		public Integer getExInt2() {
			return exInt2;
		}

		public void setExInt2(Integer exInt2) {
			this.exInt2 = exInt2;
		}

		public Integer getExInt3() {
			return exInt3;
		}

		public void setExInt3(Integer exInt3) {
			this.exInt3 = exInt3;
		}

		public String getExVar1() {
			return exVar1;
		}

		public void setExVar1(String exVar1) {
			this.exVar1 = exVar1;
		}

		public String getExVar2() {
			return exVar2;
		}

		public void setExVar2(String exVar2) {
			this.exVar2 = exVar2;
		}

		public String getExVar3() {
			return exVar3;
		}

		public void setExVar3(String exVar3) {
			this.exVar3 = exVar3;
		}

		public float getExFloat1() {
			return exFloat1;
		}

		public void setExFloat1(float exFloat1) {
			this.exFloat1 = exFloat1;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public boolean isError() {
			return isError;
		}

		public void setError(boolean isError) {
			this.isError = isError;
		}

		public int getDelStatus() {
			return delStatus;
		}

		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", dateOfBirth=" + dateOfBirth
					+ ", designation=" + designation + ", isUsed=" + isUsed + ", delStatus=" + delStatus
					+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", exInt1=" + exInt1 + ", exInt2="
					+ exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
					+ ", exFloat1=" + exFloat1 + ", msg=" + msg + ", isError=" + isError + "]";
		}

		
		 
}
