package com.ats.tankwebapi.work.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetWorkDetail {
	
	@Id
	private int workId;
	
	private int customerId;
	
	private Date workDate;	
	
	private float totalAmt;

	@Transient
	List<GetPaymentDetail> getPaymentDetail;
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

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public List<GetPaymentDetail> getGetPaymentDetail() {
		return getPaymentDetail;
	}

	public void setGetPaymentDetail(List<GetPaymentDetail> getPaymentDetail) {
		this.getPaymentDetail = getPaymentDetail;
	}

	@Override
	public String toString() {
		return "GetWorkDetail [workId=" + workId + ", customerId=" + customerId + ", workDate=" + workDate
				+ ", totalAmt=" + totalAmt + ", getPaymentDetail=" + getPaymentDetail + "]";
	}

	
}
