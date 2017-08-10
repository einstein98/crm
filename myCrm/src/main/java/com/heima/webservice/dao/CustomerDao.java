package com.heima.webservice.dao;

import java.util.List;

import com.heima.webservice.domain.Customer;

/**
 * @author 作者 Eins98
 * @version 创建时间：2017年8月10日 下午2:06:30
 */
public interface CustomerDao {

	List<Customer> getNoAssociatedCust();

	List<Customer> getCustInDecidedZone(String decidedZone_Id);

	void clearDecidedZoneInCust(String id);

	void setDecidedZoneToCust(String customer_id, String decidedZone_id);

}
