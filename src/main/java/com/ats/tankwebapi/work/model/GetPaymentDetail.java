package com.ats.tankwebapi.work.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPaymentDetail {
	@Id
	private int paymentId;
	
	private Date paymentDate;
	
	private float costRs;
	
	@Transient
	private float totalAmt;
	
	private int customerId;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getCostRs() {
		return costRs;
	}

	public void setCostRs(float costRs) {
		this.costRs = costRs;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "GetPaymentDetail [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", costRs=" + costRs
				+ ", totalAmt=" + totalAmt + ", customerId=" + customerId + "]";
	}
	
	
	
}
