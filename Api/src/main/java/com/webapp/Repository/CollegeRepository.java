package com.webapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.Entity.College;

public interface CollegeRepository extends CrudRepository<College, Integer> {

}
