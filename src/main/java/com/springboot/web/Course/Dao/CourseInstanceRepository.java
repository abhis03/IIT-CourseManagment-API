package com.springboot.web.Course.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.Course.Entity.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Integer>{
	
	List<CourseInstance> findByYearAndSemester(int year, int semester);
	
	CourseInstance findByYearAndSemesterAndCourseId(int year, int semester, int courseId);

}
