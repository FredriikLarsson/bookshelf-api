package com.myBookshelfapi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/*
	 * Hämtar alla ämnen "topics"
	 * @return en lista med alla ämnen
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	/*
	 * Hämtar ett specifikt ämne "topic"
	 * @param namnet på ämnet
	 * @return ett ämne 
	 */
	@RequestMapping("/topics/{topicName}")
	public Topic getTopic(@PathVariable String topicName) {
		return topicService.getTopic(topicName);
	}
	
	/*
	 * Lägger till ett nytt ämne
	 * @param ämnet "topic" som ska läggas till
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/*
	 * Uppdaterar ett befintligt ämne
	 * @param topic = det nya ämnet som ska ersätta det gamla,
	 * @param id = ämnet som ska uppdateras primära nyckel "id"
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable long id) {
		topicService.updateTopic(id, topic);
	}
	
	/*
	 * Tar bort ett specifikt ämne
	 * @param id = primärnyckeln hos det ämne som ska tas bort
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable long id) {
		try {
			topicService.deleteTopic(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Topic not found");
		}
	}
	
}
