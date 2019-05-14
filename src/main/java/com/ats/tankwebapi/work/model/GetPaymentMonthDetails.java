package com.ats.tankwebapi.work.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetPaymentMonthDetails {
	@Id
	private int paymentId;
	
	private String monthName;
	
	private String monthDate;
	
	private String year;
			
	private float costRs;
	
	@Transient
	private float totalAmt;
	
	@Transient
	private float finalAmt;
	
	@Transient
	private float discAmt;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public float getCostRs() {
		return costRs;
	}

	public void setCostRs(float costRs) {
		this.costRs = costRs;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
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

	@Override
	public String toString() {
		return "GetPaymentMonthDetails [paymentId=" + paymentId + ", monthName=" + monthName + ", monthDate="
				+ monthDate + ", year=" + year + ", costRs=" + costRs + ", totalAmt=" + totalAmt + ", finalAmt="
				+ finalAmt + ", discAmt=" + discAmt + "]";
	}


	

}
