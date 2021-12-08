package com.greatlearning.crm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.crm.entity.Customer;
import com.greatlearning.crm.implementation.CustomerServiceImpl;
import com.greatlearning.crm.service.CustomerService;

public class CrmApp {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = config.buildSessionFactory();

		CustomerService cs = new CustomerServiceImpl(sessionFactory);

		List<Customer> customers = cs.findAll();

		for (Customer customer : customers)
			System.out.println(customer);

	}

}
