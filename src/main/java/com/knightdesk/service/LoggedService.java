package com.knightdesk.service;

import java.util.List;

import com.knightdesk.model.LoggedPolicy;

public interface LoggedService {
	
	public void addLoggedPolicy(LoggedPolicy policy);
	
	public List<LoggedPolicy> findAllByAgentEmail(String email);


}
