package com.ats.tankwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="location_id")
	private int locationId;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="location_details")
	private String locationDetails;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_used")
	private int isUsed;	
	
	@Column(name="add_on_rate")
	private float addOnRate;
	
	@Column(name="pin_code")
	private String pinCode;	
	
	@Column(name="ex_int1")
	private Integer exInt1;
	
	@Column(name="ex_int2")
	private Integer exInt2;
	
	@Column(name="ex_int3")
	private Integer exInt3;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="ex_var3")
	private String exVar3;
	
	@Transient
	private String msg;
	
	@Transient
	private boolean isError;

	
	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getLocationDetails() {
		return locationDetails;
	}


	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public int getIsUsed() {
		return isUsed;
	}


	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}


	public float getAddOnRate() {
		return addOnRate;
	}


	public void setAddOnRate(float addOnRate) {
		this.addOnRate = addOnRate;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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


	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationDetails="
				+ locationDetails + ", delStatus=" + delStatus + ", isUsed=" + isUsed + ", addOnRate=" + addOnRate
				+ ", pinCode=" + pinCode + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", msg=" + msg + ", isError="
				+ isError + "]";
	}

	
	
}
