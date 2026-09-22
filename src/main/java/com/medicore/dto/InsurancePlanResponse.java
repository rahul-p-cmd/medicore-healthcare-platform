package com.medicore.dto;

	import java.math.BigDecimal;

	public class InsurancePlanResponse {

	    private String plan;
	    private BigDecimal premium;
	    private BigDecimal coverage;

	    public InsurancePlanResponse(String plan, BigDecimal premium, BigDecimal coverage) {
	        this.plan = plan;
	        this.premium = premium;
	        this.coverage = coverage;
	    }

	    public String getPlan() {
	        return plan;
	    }

	    public BigDecimal getPremium() {
	        return premium;
	    }

	    public BigDecimal getCoverage() {
	        return coverage;
	    }
	}


