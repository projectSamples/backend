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
	List<Employee> findByEmpId(int empid);
	List<Employee> findByProjectId(int projId);
	void deleteByEmpId(int projId);
	//@Modifying      // to mark delete or update query
    @Query("select max(id) FROM Employee e")       // it will delete all the record with specific name
    int maxid();
}
