package com.springbootWithAngular.employemanager.DAL;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootWithAngular.employemanager.API.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);


}
