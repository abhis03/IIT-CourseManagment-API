package com.springboot.web.Course.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="course")
@JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude null fields
public class Course {
	
	@Id
	@Column(name="course_Id")
	private int id;
	
	@Column(name="course_Title")
	private String title;
	
	@Column(name="course_Description")
	private String description;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("course")  // Ignores the 'course' field in the instances list during serialization
	private List<CourseInstance> instances;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<CourseInstance> getInstances() {
		return instances;
	}

	public void setInstances(List<CourseInstance> instances) {
		this.instances = instances;
	}

	public Course(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
