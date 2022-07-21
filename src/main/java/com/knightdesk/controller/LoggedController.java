package com.knightdesk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knightdesk.exception.EmptyListException;
import com.knightdesk.model.LoggedPolicy;
import com.knightdesk.service.LoggedService;


@RestController
@RequestMapping("/jdbank")
public class LoggedController {
	
	
	@Autowired
	private LoggedService loggedPolicyService;
	
	@GetMapping("/test")
	public String getText() {
		return "This is a test with simple responses";
	}
	
	@PostMapping("/policy")
	public ResponseEntity<String> addNewLoggedPolicy(@RequestBody LoggedPolicy policy){
		if((int)policy.getInsuranceAmount() >= 100000 && (int)policy.getInsuranceAmount() <300000) {
			policy.setRewardPoint(10);
		}
		else if((int)policy.getInsuranceAmount() >= 300000 && (int)policy.getInsuranceAmount() <800000) {
			policy.setRewardPoint(20);
		}
		else if((int)policy.getInsuranceAmount() >= 800000 && (int)policy.getInsuranceAmount() <1000000) {
			policy.setRewardPoint(50);
		}
		else if((int)policy.getInsuranceAmount() >= 1000000){
			policy.setRewardPoint(90);
		}
		else {
			policy.setRewardPoint(0);
		}
		
		
		loggedPolicyService.addLoggedPolicy(policy);
		
		
		return new ResponseEntity<>("Logged Policy Detail Inserted! Success", HttpStatus.OK);
	}
	
	@GetMapping("/policy_detail/{email}")
	public List<LoggedPolicy> getAllLoggedPolicy(@PathVariable String email){
		List<LoggedPolicy> loggedPolicy = loggedPolicyService.findAllByAgentEmail(email);
		if(loggedPolicy.isEmpty()) {
			throw new EmptyListException();
		}
		else {			
			return loggedPolicy;
		}
	}
	
	@GetMapping("/reward/{email}")
	public int getReward(@PathVariable String email) {
		List<LoggedPolicy> loggedPolicy = loggedPolicyService.findAllByAgentEmail(email);
		if(loggedPolicy.isEmpty()) {
			throw new EmptyListException();
		}
		else {
			int total=0;
			for(LoggedPolicy log : loggedPolicy) {
				total += log.getRewardPoint();
			}
			return total;
		}
	}

}
