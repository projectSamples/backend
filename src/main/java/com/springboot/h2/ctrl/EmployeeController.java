package com.springboot.h2.ctrl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.exceptionHandler.ResourceNotFoundException;
import com.springboot.h2.model.Employee;
import com.springboot.h2.model.Projects;
import com.springboot.h2.model.ProjectsDetails;
import com.springboot.h2.serv.EmployeeService;
import com.springboot.h2.serv.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@Api(value = "/dashboard", description = "dashboard", produces = "application/json")
@RequestMapping("/dashboard")
public class EmployeeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	EmployeeService service;
	@Autowired
	ProjectService projService;

	// Save student entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given
	// uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value = "/employee/save")
	public int save(final @RequestBody @Valid Employee student) throws ResourceNotFoundException {
		log.info("Saving employee details in the database.");
		service.save(student);
		return student.getId();
	}

	// Get all students from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given
	// uri.

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@GetMapping(value = "/employee/getall", produces = "application/vnd.jcg.api.v1+json")
	public List<Employee> getAll() {
		log.info("Getting employee details from the database.");
		return service.getAll();
	}

	@GetMapping(value = "/employee/getById", produces = "application/vnd.jcg.api.v1+json")
	public List<Employee> getById(@RequestParam(value = "id") int id) {
		log.info("Getting employee details from the database by Id.");
		return service.getByEmpId(id);
	}
	@GetMapping(value = "/employee/getByProjId", produces = "application/vnd.jcg.api.v1+json")
	public List<Employee> getByProjectId(@RequestParam(value = "id") int id) {
		log.info("Getting employee details from the database by projId.");
		return service.getByProjId(id);
	}

	@DeleteMapping(value = "/employee/deleteByEmpId", produces = "application/vnd.jcg.api.v1+json")
	public void deleteByEmpId(@RequestParam(value = "id") int id) {
		log.info("delete employee details from the database by empId.");
		service.deleteByEmpId(id);
	}

	@PostMapping(value = "/projects/save")
	public Projects projectSave(final @RequestBody @Valid Projects projects) {
		log.info("Saving Projects details in the database.");
		return projService.save(projects);
	}

	@GetMapping(value = "/projects/getall", produces = "application/vnd.jcg.api.v1+json")
	public List<Projects> getAllProjects() {
		log.info("Getting projects list from the database.");
		return projService.getAll();
	}
	
	@GetMapping(value = "/projects/getProjectDetails", produces = "application/vnd.jcg.api.v1+json")
	public List<ProjectsDetails> getAllProjectsDetails() {
		log.info("Getting projects list with employee details from the database.");
		return projService.getprojectDetails();
	}

	@GetMapping(value = "/projects/getById", produces = "application/vnd.jcg.api.v1+json")
	public Projects getProjectsById(@RequestParam(value = "id") int id) {
		log.info("Getting project by Id from the database.");
		return projService.getById(id);
	}
	@PutMapping("/employee/update")
	public Employee updateStudent(@RequestBody Employee emplyoee, @RequestParam(value = "id") int id) throws ResourceNotFoundException {
		return service.update(emplyoee, id);
	}
}
