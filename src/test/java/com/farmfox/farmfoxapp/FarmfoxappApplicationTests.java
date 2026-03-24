package com.farmfox.farmfoxapp;

import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
class FarmfoxappApplicationTests {

	@MockBean
	SupplierService supplierService;
	@MockBean
	SupplierConfig supplierConfig;
	@Test
	void contextLoads() {
	}

}
