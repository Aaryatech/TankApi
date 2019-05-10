package com.ats.tankwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name = "t_payment")
	public class Payment {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="payment_id")
		private int paymentId;
		
		@Column(name="payment_date")
		private String paymentDate;
		
		@Column(name="customer_id")
		private int customerId;
		
		@Column(name="cost_rs")
		private float costRs;
		
		@Column(name="del_status")
		private int delStatus;
		
		@Column(name="user_id")
		private int userId;	
		
		@Column(name="payment_number")
		private String paymentNumber;
		
		@Column(name="remark")
		private String remark;	
		
		@Column(name="ex_int1")
		private int exInt1;
		
		@Column(name="ex_int2")
		private int exInt2;
		
		@Column(name="ex_int3")
		private int exInt3;
		
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

		public int getExInt1() {
			return exInt1;
		}

		public void setExInt1(int exInt1) {
			this.exInt1 = exInt1;
		}

		public int getExInt2() {
			return exInt2;
		}

		public void setExInt2(int exInt2) {
			this.exInt2 = exInt2;
		}

		public int getExInt3() {
			return exInt3;
		}

		public void setExInt3(int exInt3) {
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

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
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
			return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", customerId=" + customerId
					+ ", costRs=" + costRs + ", delStatus=" + delStatus + ", userId=" + userId + ", paymentNumber="
					+ paymentNumber + ", remark=" + remark + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3="
					+ exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", msg=" + msg
					+ ", isError=" + isError + "]";
		}

		
		
} 	
