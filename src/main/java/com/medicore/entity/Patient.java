package com.medicore.entity;
import com.medicore.entity.InsurancePlan;
import com.medicore.entity.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp = "^[0-9]{10}$")
    private String phone;
	@NotNull
	@Min(18)
	@Max(120)
    private Integer age;
	@NotBlank    
    private String gender;
	
	@NotBlank
	private String address;
    
    @Enumerated(EnumType.STRING)
    private InsurancePlan insurancePlan;
    @NotNull
    private Boolean insuranceRequired;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Boolean getInsuranceRequired() {
		return insuranceRequired;
	}
	public void setInsuranceRequired(Boolean insuranceRequired) {
		this.insuranceRequired = insuranceRequired;
	}
	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}
	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
    
  
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	 
}
