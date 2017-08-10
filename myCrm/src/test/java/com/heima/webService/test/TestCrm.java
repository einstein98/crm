package com.heima.webService.test;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.heima.webservice.domain.Customer;

/**
 * @author 作者 Eins98
 * @version 创建时间：2017年8月10日 下午8:18:41
 */
@SuppressWarnings("unchecked")
public class TestCrm {
	@Test
	public void get() {
		List<Customer> list = (List<Customer>) WebClient
				.create("http://localhost:8080/myCrm/custServer/customer/noAssociated")
				.accept(MediaType.APPLICATION_JSON).getCollection(Customer.class);
		System.out.println(list);
	}

	@Test
	public void get2() {
		List<Customer> list = (List<Customer>) WebClient
				.create("http://localhost:8080/myCrm/custServer/customer/associated/DQ003")
				.accept(MediaType.APPLICATION_JSON).getCollection(Customer.class);
		System.out.println(list);
	}

	@Test
	public void associate() {
		WebClient.create("http://localhost:8080/myCrm/custServer/customer/associate/8/DQ003").put(null);
	}
}
