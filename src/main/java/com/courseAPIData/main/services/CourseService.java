package com.courseAPIData.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseAPIData.main.models.Course;
import com.courseAPIData.main.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	// complete CRUD operation
	
	public List<Course> getAllcourses(Integer topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(Integer courseId) {
		return courseRepository.findById(courseId);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		return;
	}

	public void updateCourse(Course course) {
		this.courseRepository.save(course);
		return;
	}

	public void deleteCourse(Integer courseId) {
		courseRepository.deleteById(courseId);
		
	}
}
