package com.springboot.h2.serv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			sdf.setLenient(false);
//
//			Date d1 = sdf.parse("2020-01-11");
//			Date d2 = sdf.parse(employee.getStartDate().toString());
//			Date d3 = sdf.parse("2020-11-12");
//
//			if (d2.compareTo(d1) >= 0) {
//				if (d2.compareTo(d3) <= 0) {
//					System.out.println("d2 is in between d1 and d2");
//				} else {
//					System.out.println("d2 is NOT in between d1 and d2");
//				}
//			} else {
//				System.out.println("d2 is NOT in between d1 and d2");
//			}
//
//		} catch (ParseException pe) {
//			pe.printStackTrace();
//		}
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

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Employee update(Employee emplyoee, int id) throws ResourceNotFoundException {
		Optional<Projects> proj = projRepo.findById(emplyoee.getProjectId());
		proj.orElseThrow(
				() -> new ResourceNotFoundException("Project not found for this id :: " + emplyoee.getProjectId()));
		if (proj.get().getName().equals(emplyoee.getProjectName())) {
			emplyoee.setId(id);
			return repository.save(emplyoee);
		} else {
			throw new ResourceNotFoundException("Project name did not matched :: ");
		}

	}
}
