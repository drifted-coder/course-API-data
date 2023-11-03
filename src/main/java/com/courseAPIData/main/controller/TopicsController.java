package com.courseAPIData.main.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseAPIData.main.models.Topic;
import com.courseAPIData.main.services.TopicService;

@RestController
public class TopicsController {
	
	// dependency injection
	@Autowired
	private TopicService topicService;
	
	// GET Request
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAlltopics();
	}
	
	@RequestMapping("topics/{id}")
	public Optional<Topic> getTopicById(@PathVariable("id") Integer id) {
		return topicService.getTopic(id);
	}
	
	// POST Request
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//PUT Request
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") Integer id) {
		topicService.updateTopic(topic, id);
	}
	
	// DELETE Request
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable("id") Integer id) {
		topicService.deleteTopic(id);
	}
}
