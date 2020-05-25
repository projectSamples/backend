package com.springboot.h2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.model.Projects;

@Repository
public interface ProjectRepository extends CrudRepository<Projects, Integer>{

}
