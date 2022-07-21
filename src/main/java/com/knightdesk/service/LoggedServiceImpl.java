package com.knightdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knightdesk.model.LoggedPolicy;
import com.knightdesk.repository.LoggedRepository;

@Service
public class LoggedServiceImpl implements LoggedService {

	@Autowired
	private LoggedRepository loggedRepo;
	
	@Override
	public void addLoggedPolicy(LoggedPolicy policy) {
		loggedRepo.save(policy);
	}

	@Override
	public List<LoggedPolicy> findAllByAgentEmail(String email) {
		return loggedRepo.findByAgentEmail(email);
	}


	
	

}
