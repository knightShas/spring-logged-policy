package com.knightdesk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.knightdesk.model.LoggedPolicy;

@Repository
public interface LoggedRepository extends MongoRepository<LoggedPolicy, String> {
	
	public List<LoggedPolicy> findByAgentEmail(String email);
	
	public LoggedPolicy findByPolicyNo(String policyNo);
	
	public List<LoggedPolicy> findAll();
	
}
