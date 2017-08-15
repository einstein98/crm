package com.heima.crm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.heima.crm.domain.Customer;

/**
 * @author 作者 Eins98
 * @version 创建时间：2017年8月10日 下午2:04:20
 */
@Produces("*/*")
public interface CustomerService {
	@Path("/customer/noAssociated")
	@GET
	@Produces({ "application/json", "application/xml" })
	public List<Customer> getNoAssociatedCust();

	@Path("/customer/associated/{id}")
	@GET
	@Produces({ "application/json", "application/xml" })
	public List<Customer> getCustInDecidedZone(@PathParam("id") String decidedZone_Id);

	@Path("/customer/associate/{cid}/{did}")
	@PUT
	@Consumes({ "application/json", "application/xml" })
	public void associateCustToDecidedZone(@PathParam("cid") String customer_id,
			@PathParam("did") String decidedZone_id);

	@Path("/customer/save")
	@POST
	@Consumes({ "application/json", "application/xml" })
	@Produces({ "application/json", "application/xml" })
	public Customer saveCustomer(Customer customer);

	@Path("/customer/getCustomerByTel/{tel}")
	@GET
	@Produces({ "application/json", "application/xml" })
	public Customer getCustomerByTelephone(@PathParam("tel") String tel);

}
