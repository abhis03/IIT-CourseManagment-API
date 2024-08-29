package com.springboot.web.Course.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.web.Course.Entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	
	public Course findById(int id);

}
