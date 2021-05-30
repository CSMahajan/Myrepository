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
	@Autowired
	private EmployeeMapper employeeMapper;

	public List<Employee> listAll() {
		return employeeMapper.getAllEmployees();
	}

	public void save(Employee employee) {
		// repo.save(employee);
		employeeMapper.addEmployee(employee);
	}

	public void edit(Employee employee) {
		// repo.save(employee);
		employeeMapper.updateEmployee(employee.getId(), employee.getFirstname(), employee.getLastname(),
				employee.getEmail(), employee.getAge());
	}

	public Employee get(long id) {
		return employeeRepository.findById(id).get();
	}

	public void delete(long id) {
		// repo.deleteById(id);
		employeeMapper.deleteEmployee(id);
	}
}
