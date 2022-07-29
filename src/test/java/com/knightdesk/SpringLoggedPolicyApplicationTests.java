package com.knightdesk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.knightdesk.model.LoggedPolicy;
import com.knightdesk.repository.LoggedRepository;
import com.knightdesk.service.LoggedService;

@SpringBootTest
class SpringLoggedPolicyApplicationTests {
	
	public LoggedPolicy policy = new LoggedPolicy("Sanjeevani","AAB00223JSD","Shiv", "shiv@gmail.com", "PASN1292JG","Rohit", "rohit@gmail.com", "JSI92792UE", 80921, 100000.00, 3);
	
	@Autowired
	private LoggedService loggedService;
	
	@MockBean
	private LoggedRepository loggedRepo;

	@Test
	public void getAllLoggedPolicyTest() {
		when(loggedRepo.findAll()).thenReturn(Stream
				.of(policy,
					new LoggedPolicy("Lic","AAB00224ACB","Krish", "krish@gmail.com", "PASN1302DJ","Ram", "ram@gmail.com", "JSI92800PV", 78945, 900000.00, 2)).collect(Collectors.toList()));
		assertEquals(2, loggedService.findAllLoggedPolicy().size());
	}
	
	@Test
	public void savePolicyTest() {
		when(loggedRepo.save(policy)).thenReturn(policy);
	}
	
	@Test
	public void getPolicyDetailTest() {
		when(loggedRepo.findByPolicyNo(policy.getPolicyNo())).thenReturn(policy);
		assertThat(loggedService.getPolicyDetail(policy.getPolicyNo()).equals(policy));
	}
	
	@Test
	public void findAllByAgentEmailTest() {
		when(loggedRepo.findByAgentEmail(policy.getAgentEmail())).thenReturn(Stream
				.of(policy).collect(Collectors.toList()));
		assertEquals(1, loggedService.findAllByAgentEmail(policy.getAgentEmail()).size());
	}
}
