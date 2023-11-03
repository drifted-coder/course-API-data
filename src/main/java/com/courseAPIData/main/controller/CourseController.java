package com.courseAPIData.main.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseAPIData.main.models.Course;
import com.courseAPIData.main.models.Topic;
import com.courseAPIData.main.services.CourseService;

@RestController
public class CourseController {
	
	// dependency injection
	@Autowired
	private CourseService courseService;
	
	// GET Request
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") Integer topicId) {
		return courseService.getAllcourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourseById(@PathVariable("id") Integer topicId, @PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}
	
	// POST Request
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") Integer topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	//PUT Request
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") Integer topicId, @PathVariable("courseId") Integer courseId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	// DELETE Request
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("id") Integer courseId) {
		courseService.deleteCourse(courseId);
	}
}
