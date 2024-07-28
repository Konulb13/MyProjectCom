package com.example.konul;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class KonulApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	void testUserSecurityServiceBean() {
		boolean userSecurityServiceBeanExists = applicationContext.containsBean("userSecurityService");
		assertThat(userSecurityServiceBeanExists).isTrue();
	}


	@Test
	void testCartItemRepositoryBean() {
		boolean cartItemRepositoryBeanExists = applicationContext.containsBean("cartItemRepository");
		assertThat(cartItemRepositoryBeanExists).isTrue();
	}

	@Test
	void testApplicationStarts() {
		KonulApplication.main(new String[] {});
	}

}
