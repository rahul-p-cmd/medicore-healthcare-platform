package com.medicore.entity;

import java.math.BigDecimal;

public enum InsurancePlan {
	
	//BASIC,
	//STANDARD,
	//PREMIUM;
	BASIC(new BigDecimal("5000"), new BigDecimal("500000")),
    STANDARD(new BigDecimal("10000"), new BigDecimal("1000000")),
    PREMIUM(new BigDecimal("20000"), new BigDecimal("2000000"));

	private BigDecimal premium;
	private BigDecimal coverage;
	
	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public BigDecimal getCoverage() {
		return coverage;
	}

	public void setCoverage(BigDecimal coverage) {
		this.coverage = coverage;
	}

	InsurancePlan(BigDecimal premium, BigDecimal coverage) {
	    this.premium = premium;
	    this.coverage = coverage;
	}
}
