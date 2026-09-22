package com.medicore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicore.dto.InsurancePlanResponse;
import com.medicore.entity.InsurancePlan;

@RestController
@RequestMapping("/insurance-plans")
public class InsuranceController {

	@GetMapping
	public List<InsurancePlanResponse> getInsurancePlans()
	{
		return Arrays.stream(InsurancePlan.values())
                .map(plan -> new InsurancePlanResponse(
                        plan.name(),
                        plan.getPremium(),
                        plan.getCoverage()))
                .toList();
}
}
