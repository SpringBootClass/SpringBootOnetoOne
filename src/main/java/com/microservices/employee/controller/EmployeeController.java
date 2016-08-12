package com.microservices.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employee.model.Employee;
import com.microservices.employee.service.EmployeeServiceIF;
import com.microservices.result.Result;

@RestController
@RequestMapping(path = "/employee/v1")
public class EmployeeController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EmployeeServiceIF employeeServiceIF;
	
	public EmployeeServiceIF getEmployeeServiceIF() {
		return employeeServiceIF;
	}

	public void setEmployeeServiceIF(EmployeeServiceIF employeeServiceIF) {
		this.employeeServiceIF = employeeServiceIF;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> getEmployees() {

		HttpStatus statusCode = null;
		Result result = new Result();
		List<Employee> employeeList = null;
		try {
			employeeList = employeeServiceIF.getEmployees();
			if (employeeList.isEmpty()) {
//				result.setMessage(ApplicationMessages.CUSTOMERS_LIST_EMPTY);
//				result.setStatus(ApplicationConstants.SUCCESS);
				result.setObject(employeeList);
			} else {
				result.setObject(employeeList);
				statusCode = HttpStatus.OK;
//				result.setStatus(ApplicationConstants.SUCCESS);
//				result.setMessage(ApplicationMessages.CUSTOMERS_LIST_NOT_EMPTY);
			}

		} catch (Exception e) {
			//logger.error(ApplicationMessages.CUSTOMER_METHED_FIND_ALL);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			result.setObject(employeeList);
			//result.setStatus(ApplicationConstants.FAILED);
			result.setMessage(e.getLocalizedMessage());
			// throw new
			// EmployeeException(ApplicationConstants.CUSTOMER_NOT_FOUND,e);
			return new ResponseEntity<Result>(result, statusCode);
		}

		return new ResponseEntity<Result>(result, statusCode);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> getEmployee(@PathVariable("employeeId") String employeeId) {

		HttpStatus statusCode = null;
		Result result = new Result();
		Object employee = null;
		try {
			employee = employeeServiceIF.getEmployee(Long.parseLong(employeeId));
			if (employee == null) {
				result.setObject(employee);
				statusCode = HttpStatus.NO_CONTENT;
				//result.setStatus(ApplicationConstants.FAILED);
				//result.setMessage(ApplicationMessages.CUSTOMER_DOES_NOT_EXIST);
			} else {
				result.setObject(employee);
				statusCode = HttpStatus.OK;
				//result.setStatus(ApplicationConstants.SUCCESS);
				//result.setMessage(ApplicationMessages.CUSTOMER_EXIST);
			}

		} catch (Exception e) {
			//logger.error(ApplicationMessages.CUSTOMER_METHED_FIND_ONE);
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			result.setObject(employee);
			//result.setStatus(ApplicationConstants.FAILED);
			result.setMessage(e.getLocalizedMessage());
			// throw new
			// CustomerException(ApplicationConstants.CUSTOMER_NOT_FOUND,e);
			return new ResponseEntity<Result>(result, statusCode);
		}

		return new ResponseEntity<Result>(result, statusCode);
	}

	
}
