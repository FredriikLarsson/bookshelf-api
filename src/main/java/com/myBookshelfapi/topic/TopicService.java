package com.myBookshelfapi.topic;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	 * Hämtar alla ämnen "topic".
	 * @return en lista med alla ämnen
	 */
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		Iterable<Topic> _topics = topicRepository.findAll();
		for (Topic t : _topics) {
			topics.add(t);
		}
		return topics;
	}
	
	/*
	 * Hämta ett specifikt ämne "topic".
	 * @param namnet på ämnet "topic"
	 * @return ett specifikt ämne
	 */
	public Topic getTopic(String topicName) {
		return topicRepository.findByName(topicName);
	}
	
	/*
	 * Lägg till ett ämne "topic"
	 * @param ett ämne "topic" objekt
	 */
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	/*
	 * Uppdaterar ett befintligt ämne
	 * @param id = ämnets "topic" primära nyckel "id",
	 * @param topic = det nya ämnet som ska ersätta "uppdatera" det gamla
	 */
	public void updateTopic(long id, Topic topic) {
		if (topicRepository.findById(id).isPresent()) {
			topic.setId(id);
			topicRepository.save(topic);
		}
	}

	/*
	 * Tar bort ett befintligt ämne
	 * @param id = ämnets primärnyckel
	 */
	public void deleteTopic(long id) {
		topicRepository.deleteById(id);
	}
	
}
