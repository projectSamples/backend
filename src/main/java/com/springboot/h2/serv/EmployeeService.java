package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.exceptionHandler.ResourceNotFoundException;
import com.springboot.h2.model.Employee;
import com.springboot.h2.model.Projects;
import com.springboot.h2.repo.EmployeeRepository;
import com.springboot.h2.repo.ProjectRepository;

@Service
public class EmployeeService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	EmployeeRepository repository;
	@Autowired
	ProjectRepository projRepo;

	// Save student entity in the h2 database.
	public void save(final Employee employee) throws ResourceNotFoundException {
		Optional<Projects> proj = projRepo.findById(employee.getProjectId());
		proj.orElseThrow(
				() -> new ResourceNotFoundException("Project not found for this id :: " + employee.getProjectId()));
		if (proj.get().getName().equals(employee.getProjectName())) {
			if (this.getAll().size() > 0) {
				employee.setId(repository.maxid() + 1);
			} else {
				employee.setId(1);
			}
			repository.save(employee);
		} else {
			throw new ResourceNotFoundException("Project name did not matched :: ");
		}
	}

	// Get all students from the h2 database.
	public List<Employee> getAll() {
		final List<Employee> employees = new ArrayList<>();
		repository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}

	public List<Employee> getByEmpId(int id) {
		return repository.findByEmpId(id);
	}

	public List<Employee> getByProjId(int id) {
		return repository.findByProjectId(id);
	}

	public void deleteByEmpId(int id) {
		repository.deleteByEmpId(id);
	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Employee update(Employee emplyoee, int id) throws ResourceNotFoundException {
		Optional<Projects> proj = projRepo.findById(emplyoee.getProjectId());
		proj.orElseThrow(
				() -> new ResourceNotFoundException("Project not found for this id :: " + emplyoee.getProjectId()));
		if (proj.get().getName().equals(emplyoee.getProjectName())) {
			Optional<Employee> employeeOptional = repository.findById(id);
			if (!employeeOptional.isPresent())
				throw new ResourceNotFoundException("Employee id did not matched :: ");
			emplyoee.setId(id);

			return repository.save(emplyoee);
		} else {
			throw new ResourceNotFoundException("Project name did not matched :: ");
		}

	}
}
