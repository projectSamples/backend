package com.springboot.h2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.h2.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("select e FROM Employee e where e.empId = :empid and e.deleted = false")
	List<Employee> findByEmpId(int empid);
	@Query("select e FROM Employee e where e.projectId = :projId and e.deleted = false")
	List<Employee> findByProjectId(int projId);
    @Query("select max(id) FROM Employee e")       // it will get max id to handle manual data entry to generated id
    int maxid();
}
