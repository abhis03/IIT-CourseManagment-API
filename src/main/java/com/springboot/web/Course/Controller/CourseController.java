package com.springboot.web.Course.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.Course.Entity.Course;
import com.springboot.web.Course.Entity.CourseInstance;
import com.springboot.web.Course.Services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		
		Course c = null;
		
		try {
			c = this.courseService.addCourse(course);
			return ResponseEntity.of(Optional.of(c));
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourse(){
		
		List<Course> list = courseService.getAllCourses();
		
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable("id") int id){
		Course course = courseService.getCourseById(id);
		
		if(course == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(course));
	}
	
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("courseId") int courseId){
		
		try {
			
			this.courseService.deleteCourse(courseId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping("/instances")
    public CourseInstance createCourseInstance(@RequestBody CourseInstance instance) {
        return courseService.createCourseInstance(instance);
    }
	
	
	@GetMapping("/instances/{year}/{semester}")
    public List<CourseInstance> getCourseInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseService.getCourseInstancesByYearAndSemester(year, semester);
    }
	
	
	@GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getCourseInstanceByYearSemesterAndCourseId(@PathVariable int year, @PathVariable int semester, @PathVariable int courseId) {
        return ResponseEntity.ok(courseService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId));
    }
	
	
	@DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable int courseId) {
        courseService.deleteCourseInstance(year, semester, courseId);
        return ResponseEntity.noContent().build();
    }

}
