package org.securitases.union.sesems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.securitases.union.sesems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class SesEmsApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@Test
	public void contextLoads__serviceIsNotNull() {
		assertThat(service).isNotNull();
	}

}
