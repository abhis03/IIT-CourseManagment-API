package com.springboot.web.Course.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude null fields
public class CourseInstance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="year")
	private int year;
	
	@Column(name="semester")
	private int semester;
	
	@ManyToOne
	@JoinColumn(name = "course_Id") 
	@JsonIgnoreProperties("instances")  // Ignores the 'instances' field in the course during serialization
	private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseInstance(int id, int year, int semester, Course course) {
		super();
		this.id = id;
		this.year = year;
		this.semester = semester;
		this.course = course;
	}

	public CourseInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseInstance [id=" + id + ", year=" + year + ", semester=" + semester + ", course=" + course + "]";
	} 
	
	


}
