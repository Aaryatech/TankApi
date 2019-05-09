package com.ats.tankwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_customer")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_address")
	private String customerAddress;
	
	@Column(name="customer_phone")
	private String customerPhone;
	
	@Column(name="customer_phone2")
	private String customerPhone2;	
	
	@Column(name="customer_contact_name")
	private String customerContactName;
	
	@Column(name="customer_contact_number")
	private String customerContactNumber;
	
	@Column(name="no_of_upper_tank")
	private float noOfUpperTank;
	
	@Column(name="no_of_lower_tank")
	private float noOfLowerTank;
	
	@Column(name="cost_uppertank_perpieces")
	private float costUppertankPerpieces;
	
	@Column(name="cost_lowertank_perpieces")
	private float costLowertankPerpieces;
	
	@Column(name="area_id")
	private int areaId;
	
	@Column(name="frequency")
	private float frequency;
	
	@Column(name="ex_float1")
	private float exFloat1;
	
	@Column(name="del_status")
	private int delStatus;
	
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
	
	
	
	@Column(name="remark")
	private String remark;
	
	@Transient
	private String msg;
	
	@Transient
	private boolean isError;

	

	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}



	public String getCustomerPhone() {
		return customerPhone;
	}



	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}



	public String getCustomerPhone2() {
		return customerPhone2;
	}



	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}



	public String getCustomerContactName() {
		return customerContactName;
	}



	public void setCustomerContactName(String customerContactName) {
		this.customerContactName = customerContactName;
	}



	public String getCustomerContactNumber() {
		return customerContactNumber;
	}



	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}



	public float getNoOfUpperTank() {
		return noOfUpperTank;
	}



	public void setNoOfUpperTank(float noOfUpperTank) {
		this.noOfUpperTank = noOfUpperTank;
	}



	public float getNoOfLowerTank() {
		return noOfLowerTank;
	}



	public void setNoOfLowerTank(float noOfLowerTank) {
		this.noOfLowerTank = noOfLowerTank;
	}



	public float getCostUppertankPerpieces() {
		return costUppertankPerpieces;
	}



	public void setCostUppertankPerpieces(float costUppertankPerpieces) {
		this.costUppertankPerpieces = costUppertankPerpieces;
	}



	public float getCostLowertankPerpieces() {
		return costLowertankPerpieces;
	}



	public void setCostLowertankPerpieces(float costLowertankPerpieces) {
		this.costLowertankPerpieces = costLowertankPerpieces;
	}



	public int getAreaId() {
		return areaId;
	}



	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}



	public float getFrequency() {
		return frequency;
	}



	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}



	public float getExFloat1() {
		return exFloat1;
	}



	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}



	public int getDelStatus() {
		return delStatus;
	}



	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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
		return "Employee [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhone=" + customerPhone + ", customerPhone2=" + customerPhone2
				+ ", customerContactName=" + customerContactName + ", customerContactNumber=" + customerContactNumber
				+ ", noOfUpperTank=" + noOfUpperTank + ", noOfLowerTank=" + noOfLowerTank + ", costUppertankPerpieces="
				+ costUppertankPerpieces + ", costLowertankPerpieces=" + costLowertankPerpieces + ", areaId=" + areaId
				+ ", frequency=" + frequency + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", exFloat1=" + exFloat1 + ", remark=" + remark + ", msg=" + msg + ", isError=" + isError + "]";
	}
	
	
}
