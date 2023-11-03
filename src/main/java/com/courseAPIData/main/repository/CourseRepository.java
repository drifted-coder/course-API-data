package com.courseAPIData.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.courseAPIData.main.models.Course;

public interface CourseRepository extends CrudRepository<Course,Integer> {
	public List<Course> findByTopicId(Integer topicId);
}
