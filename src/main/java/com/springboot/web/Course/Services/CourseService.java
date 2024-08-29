package com.springboot.web.Course.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.web.Course.Dao.CourseInstanceRepository;
import com.springboot.web.Course.Dao.CourseRepository;
import com.springboot.web.Course.Entity.Course;
import com.springboot.web.Course.Entity.CourseInstance;

@Component
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseInstanceRepository courseInstanceRepository;
	
	//Add Course
	public Course addCourse(Course c) {
		
		Course result = courseRepository.save(c);
		return result;
	}
	
	//get all course
	public List<Course> getAllCourses(){
		
		List<Course> list = (List<Course>) this.courseRepository.findAll();
		return list;
	}
	
	//get single course by id
	public Course getCourseById(int id) {
		
		Course course = null;
		
		try {
			course = this.courseRepository.findById(id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return course;
	}
	
	//delete course by id
	public void deleteCourse(int cId) {
		courseRepository.deleteById(cId);
	}
	
	
	//Add Instance
	public CourseInstance createCourseInstance(CourseInstance instance) {
		
		return courseInstanceRepository.save(instance);
	}
	
	
	//get Instance by year and semester
	public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }
	
	//get Instance by year and semester and courseId
	public CourseInstance getCourseInstanceByYearSemesterAndCourseId(int year, int semester, int courseId) {
        return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
    }
	
	//Delete
	public void deleteCourseInstance(int year, int semester, int courseId) {
        CourseInstance instance = courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
        courseInstanceRepository.delete(instance);
    }


}
