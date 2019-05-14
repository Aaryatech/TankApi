package com.ats.tankwebapi.work.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetWorkMonthDetails {
	@Id
	private int workId;
	
	private String monthName;
	
	private String monthDate;
	
	private String year;
			
	private float finalAmt;
	
	private float discAmt;
			
	private float totalAmt;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
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

	@Override
	public String toString() {
		return "GetWorkMonthDetails [workId=" + workId + ", monthName=" + monthName + ", monthDate=" + monthDate
				+ ", year=" + year + ", finalAmt=" + finalAmt + ", discAmt=" + discAmt + ", totalAmt=" + totalAmt + "]";
	}
	
	
}
