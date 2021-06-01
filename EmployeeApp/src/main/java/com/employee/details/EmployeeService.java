package com.employee.details;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee get(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}
}
