package io.alain.springboot.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> topics() {
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic topic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void store(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void update(@RequestBody Topic topic, @PathVariable String id) {
        topicService.update(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void delete(@PathVariable String id){
        topicService.delete(id);
    }
}
