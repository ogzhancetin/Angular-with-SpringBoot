package com.springbootWithAngular.employemanager.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springbootWithAngular.employemanager.API.Employee;
import com.springbootWithAngular.employemanager.DAL.IEmployeeRepository;
import com.springbootWithAngular.employemanager.exception.UserNotFoundException;

@Service
public class EmployeeService {
	private final IEmployeeRepository employeeRepository;
	
	public EmployeeService(IEmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(Long id){
		employeeRepository.deleteEmployeeById(id);
	}
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not found"));
	}
}
