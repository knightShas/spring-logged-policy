package com.knightdesk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="logged_policy")
public class LoggedPolicy {

	@Id
	private String id;
	
	private String policyName;
	
	@Indexed(unique = true)
	private String policyNo;
	
	private String agentName;
	
	private String agentEmail;
	
	private String agentPanNo;
	
	private String customerName;
	
	private String customerEmail;
	
	private String customerPanNo;
	
	private long customerPhoneNo;
	
	private double insuranceAmount;
	
	private int noOfYear;
	
	private int rewardPoint;

	public LoggedPolicy() {
		super();
	}

	public LoggedPolicy(String policyName, String policyNo, String agentName, String agentEmail, String agentPanNo,
			String customerName, String customerEmail, String customerPanNo, long customerPhoneNo,
			double insuranceAmount, int noOfYear) {
		super();
		this.policyName = policyName;
		this.policyNo = policyNo;
		this.agentName = agentName;
		this.agentEmail = agentEmail;
		this.agentPanNo = agentPanNo;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPanNo = customerPanNo;
		this.customerPhoneNo = customerPhoneNo;
		this.insuranceAmount = insuranceAmount;
		this.noOfYear = noOfYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public String getAgentPanNo() {
		return agentPanNo;
	}

	public void setAgentPanNo(String agentPanNo) {
		this.agentPanNo = agentPanNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPanNo() {
		return customerPanNo;
	}

	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}

	public long getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public int getNoOfYear() {
		return noOfYear;
	}

	public void setNoOfYear(int noOfYear) {
		this.noOfYear = noOfYear;
	}

	public int getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(int rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	@Override
	public String toString() {
		return "LoggedPolicy [id=" + id + ", policyName=" + policyName + ", policyNo=" + policyNo + ", agentName="
				+ agentName + ", agentEmail=" + agentEmail + ", agentPanNo=" + agentPanNo + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + ", customerPanNo=" + customerPanNo
				+ ", customerPhoneNo=" + customerPhoneNo + ", insuranceAmount=" + insuranceAmount + ", noOfYear="
				+ noOfYear + ", rewardPoint=" + rewardPoint + "]";
	}
		
}
