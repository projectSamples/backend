package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.model.Projects;
import com.springboot.h2.model.ProjectsDetails;
import com.springboot.h2.repo.EmployeeRepository;
import com.springboot.h2.repo.ProjectRepository;

@Service
public class ProjectService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	ProjectRepository repository;
	@Autowired
	EmployeeRepository empRepository;
	
	public Projects save(final Projects project) {
		return repository.save(project);
	}

	public List<Projects> getAll() {
		final List<Projects> projects = new ArrayList<>();
		repository.findAll().forEach(project -> projects.add(project));
		return projects;
	}
	public List<ProjectsDetails> getprojectDetails() {
		final List<ProjectsDetails> projects = new ArrayList<>();
		Iterable<Projects> projList = repository.findAll();
		for(Projects proj:projList) {
			ProjectsDetails projdetails = new ProjectsDetails();
			projdetails.setId(proj.getId());
			projdetails.setName(proj.getName());
			projdetails.setEmployees(empRepository.findByProjectId(proj.getId()));
			projects.add(projdetails);
		}
		return projects;
	}
	public Projects getById(int id) {
		return repository.findById(id).get();
	}
}
