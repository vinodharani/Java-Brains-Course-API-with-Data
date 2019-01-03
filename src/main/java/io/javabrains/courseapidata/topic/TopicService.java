package io.javabrains.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
//this is a stereotype annotation
//this marks the class as spring service
public class TopicService {

    @Autowired
    //    dependency injection of TopicRepository
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);

        return topics;
    }

    public Topic getTopic(String id) {
        if (topicRepository.findById(id).isPresent()) {
            return topicRepository.findById(id).get();
        }

        return null;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        add and update use the same save method
//        the repository looks at the id of the topic and automatically determines if it is an update or a new entry
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
