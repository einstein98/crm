package com.heima.crm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.heima.crm.dao.CustomerDao;
import com.heima.crm.domain.Customer;

/**
 * @author 作者 Eins98
 * @version 创建时间：2017年8月10日 下午2:08:21
 */
@Repository
@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	@Autowired
	public void setSuperSessonFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<Customer> getNoAssociatedCust() {
		List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer where decidedzoneId is null");
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<Customer> getCustInDecidedZone(String decidedZone_Id) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer where decidedzoneId = ?",
				decidedZone_Id);
		return list.isEmpty() ? null : list;
	}

	@Override
	public void clearDecidedZoneInCust(String id) {
		getHibernateTemplate().bulkUpdate("update Customer set decidedzoneId = null where decidedzoneId = ?", id);
	}

	@Override
	public void setDecidedZoneToCust(String customer_id, String decidedZone_id) {
		getHibernateTemplate().bulkUpdate("update Customer set decidedzoneId = ? where id = ?", decidedZone_id,
				Integer.parseInt(customer_id));
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Integer id = (Integer) getHibernateTemplate().save(customer);
		customer.setId(id);
		return customer;
	}

	@Override
	public Customer getCustomerByTelephone(String tel) {
		return (Customer) getHibernateTemplate().find("from Customer where telephone=?", tel).get(0);
	}
}
