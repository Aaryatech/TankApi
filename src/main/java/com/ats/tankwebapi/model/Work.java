package com.ats.tankwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name = "t_work")
	public class Work {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="work_id")
		private int workId;
		
		@Column(name="customer_id")
		private int customerId;
		
		@Column(name="employee_id")
		private String employeeId;		
				
		@Column(name="work_date")
		private String workDate;		
		
		@Column(name="work_time")
		private String workTime;
		
		@Column(name="sequence_number")
		private int sequenceNumber;	
		
		@Column(name="no_of_lower_tank")
		private float noOfLowerTank;
		
		@Column(name="no_of_upper_tank")
		private float noOfUpperTank;
		
		@Column(name="no_of_hr_spend ")
		private float noOfHrSpend ;		
	
		@Column(name="amt_lower_tank")
		private float amtLowerTank;
		
		@Column(name="amt_upper_tank")
		private float amtUpperTank;
				
		@Column(name="final_amt")
		private float finalAmt;
		
		@Column(name="disc_amt")
		private float discAmt;
				
		@Column(name="total_amt")
		private float totalAmt;
		
		@Column(name="remark")
		private String remark;
		
		@Column(name="next_date")
		private String nextDate;
		
		@Column(name="status")
		private int status;
		
		@Column(name="customer_frequency")
		private float customerFrequency;
		
		@Column(name="bill_number")
		private String billNumber;
			
		@Column(name="del_status")
		private int delStatus;
		
		@Column(name="is_used")
		private int isUsed;	
		
		@Column(name = "ex_int1")
		private Integer exInt1;

		@Column(name = "ex_int2")
		private Integer exInt2;

		@Column(name = "ex_int3")
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
		
		public int getWorkId() {
			return workId;
		}

		public void setWorkId(int workId) {
			this.workId = workId;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}


		public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}

		public String getWorkDate() {
			return workDate;
		}

		public void setWorkDate(String workDate) {
			this.workDate = workDate;
		}

		public String getWorkTime() {
			return workTime;
		}

		public void setWorkTime(String workTime) {
			this.workTime = workTime;
		}

		public int getSequenceNumber() {
			return sequenceNumber;
		}

		public void setSequenceNumber(int sequenceNumber) {
			this.sequenceNumber = sequenceNumber;
		}

		public float getNoOfLowerTank() {
			return noOfLowerTank;
		}

		public void setNoOfLowerTank(float noOfLowerTank) {
			this.noOfLowerTank = noOfLowerTank;
		}

		public float getNoOfUpperTank() {
			return noOfUpperTank;
		}

		public void setNoOfUpperTank(float noOfUpperTank) {
			this.noOfUpperTank = noOfUpperTank;
		}

		public float getNoOfHrSpend() {
			return noOfHrSpend;
		}

		public void setNoOfHrSpend(float noOfHrSpend) {
			this.noOfHrSpend = noOfHrSpend;
		}

		public float getAmtLowerTank() {
			return amtLowerTank;
		}

		public void setAmtLowerTank(float amtLowerTank) {
			this.amtLowerTank = amtLowerTank;
		}

		public float getAmtUpperTank() {
			return amtUpperTank;
		}

		public void setAmtUpperTank(float amtUpperTank) {
			this.amtUpperTank = amtUpperTank;
		}

		public float getFinalAmt() {
			return finalAmt;
		}

		public void setFinalAmt(float finalAmt) {
			this.finalAmt = finalAmt;
		}

		public float getDiscAmt() {
			return discAmt;
		}

		public void setDiscAmt(float discAmt) {
			this.discAmt = discAmt;
		}

		public float getTotalAmt() {
			return totalAmt;
		}

		public void setTotalAmt(float totalAmt) {
			this.totalAmt = totalAmt;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getNextDate() {
			return nextDate;
		}

		public void setNextDate(String nextDate) {
			this.nextDate = nextDate;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public float getCustomerFrequency() {
			return customerFrequency;
		}

		public void setCustomerFrequency(float customerFrequency) {
			this.customerFrequency = customerFrequency;
		}

		public String getBillNumber() {
			return billNumber;
		}

		public void setBillNumber(String billNumber) {
			this.billNumber = billNumber;
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

		public void setExInt1(Integer exInt1) {
			this.exInt1 = exInt1;
		}

		public void setExInt2(Integer exInt2) {
			this.exInt2 = exInt2;
		}

		public void setExInt3(Integer exInt3) {
			this.exInt3 = exInt3;
		}

		@Override
		public String toString() {
			return "Work [workId=" + workId + ", customerId=" + customerId + ", employeeId=" + employeeId
					+ ", workDate=" + workDate + ", workTime=" + workTime + ", sequenceNumber=" + sequenceNumber
					+ ", noOfLowerTank=" + noOfLowerTank + ", noOfUpperTank=" + noOfUpperTank + ", noOfHrSpend="
					+ noOfHrSpend + ", amtLowerTank=" + amtLowerTank + ", amtUpperTank=" + amtUpperTank + ", finalAmt="
					+ finalAmt + ", discAmt=" + discAmt + ", totalAmt=" + totalAmt + ", remark=" + remark
					+ ", nextDate=" + nextDate + ", status=" + status + ", customerFrequency=" + customerFrequency
					+ ", billNumber=" + billNumber + ", delStatus=" + delStatus + ", isUsed=" + isUsed + ", exInt1="
					+ exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
					+ ", exVar3=" + exVar3 + ", msg=" + msg + ", isError=" + isError + "]";
		}

	
}
