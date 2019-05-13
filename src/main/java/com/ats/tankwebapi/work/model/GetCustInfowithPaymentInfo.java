 package com.ats.tankwebapi.work.model;
 
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GetCustInfowithPaymentInfo {
	
	@Id	
	private int paymentId;
	
	private String paymentDate;	

	private int customerId;
	
	private float costRs;

	private int delStatus;
	
	private int userId;	
	
	private String paymentNumber;
	
	private String remark;	
	
	private Integer exInt1;
	
	private Integer exInt2;
	
	private Integer exInt3;
	
	private String exVar1;
	
	private String exVar2;
	
	private String exVar3;
	
	private String customerName;
	
	private String customerAddress;
	
	private String customerPhone;
	
	private String customerContactName;
	
	private String customerContactNumber;

	

	public int getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}



	public String getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public float getCostRs() {
		return costRs;
	}



	public void setCostRs(float costRs) {
		this.costRs = costRs;
	}



	public int getDelStatus() {
		return delStatus;
	}



	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getPaymentNumber() {
		return paymentNumber;
	}



	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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



	@Override
	public String toString() {
		return "GetCustInfowithPaymentInfo [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", customerId="
				+ customerId + ", costRs=" + costRs + ", delStatus=" + delStatus + ", userId=" + userId
				+ ", paymentNumber=" + paymentNumber + ", remark=" + remark + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhone="
				+ customerPhone + ", customerContactName=" + customerContactName + ", customerContactNumber="
				+ customerContactNumber + "]";
	}

	
	
}