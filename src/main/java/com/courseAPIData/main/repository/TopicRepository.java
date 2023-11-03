package com.courseAPIData.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.courseAPIData.main.models.Topic;

public interface TopicRepository extends CrudRepository<Topic,Integer> {

}
