package com.microservices.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.employee.exception.EmployeeException;
import com.microservices.employee.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDaoIF {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() throws EmployeeException {
		Session session = null;
		List<Employee> employeeList = null;

		try {
			session = sessionFactory.getCurrentSession();
			employeeList = session.createQuery("from Employee").list();
			//session.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
		}
		return employeeList;
	}

	@Override
	public Object getEmployee(Long employeeId) throws EmployeeException {
		Session session = null;
		Object employee = null;

		try {
			session = sessionFactory.getCurrentSession();
			employee = session.get(Employee.class,employeeId);
//			Query query = session.getNamedQuery("Customer.findCustomerById").setParameter("id", customerId);
//			List<Customer> customerList = Collections.checkedList(query.list(), Customer.class);
//			if (customerList.iterator().hasNext()){
//				customer = customerList.iterator().next();
//			}else{
//				//
//			}


		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {

		}
		return employee;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
