package com.heima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.crm.dao.CustomerDao;
import com.heima.crm.domain.Customer;
import com.heima.crm.service.CustomerService;

/**
 * @author 作者 Eins98
 * @version 创建时间：2017年8月10日 下午2:05:03
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getNoAssociatedCust() {
		return customerDao.getNoAssociatedCust();
	}

	@Override
	public List<Customer> getCustInDecidedZone(String decidedZone_Id) {
		return customerDao.getCustInDecidedZone(decidedZone_Id);
	}

	@Override
	public void associateCustToDecidedZone(String customer_id, String decidedZone_id) {
		String[] ids = customer_id.split(",");
		for (String id : ids) {
			customerDao.clearDecidedZoneInCust(decidedZone_id);
			customerDao.setDecidedZoneToCust(id, decidedZone_id);
		}
	}

}
