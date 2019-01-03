package io.javabrains.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
//    dependency injection of TopicService
    private TopicService topicService;

    @RequestMapping("/topics")
//    mapped to /topics
//    method returns the list of topic
//    the list of topics will automatically converted to json when this url is requested
//    json is visible when /topics is requested instead of a list of topics
//    spring mvc does this automatic conversion
//    when there is a get request on /topics, this method will get executed
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
//        @PathVariable annotation maps the id in @RequestMapping annotation to the argument of this method
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
//    when there is post request on /topics, this method will get executed
    public void addTopic(@RequestBody Topic topic) {
//        the @RequestBody annotation tells the spring mvc that the payload will have a json representation of the topic instance
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
