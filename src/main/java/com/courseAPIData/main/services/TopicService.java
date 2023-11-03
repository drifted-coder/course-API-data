package com.courseAPIData.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseAPIData.main.models.Topic;
import com.courseAPIData.main.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	
	// complete CRUD operation
	
	public List<Topic> getAlltopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(Integer id) {
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		return;
	}

	public void updateTopic(Topic topic, Integer id) {
		this.topicRepository.save(topic);
		return;
	}

	public void deleteTopic(Integer id) {
		topicRepository.deleteById(id);
		
	}
}
