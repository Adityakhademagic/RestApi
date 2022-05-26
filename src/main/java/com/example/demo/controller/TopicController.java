package com.example.demo.controller;

import com.example.demo.model.Topic;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {

        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{Id}")
    public Topic getTopic(@PathVariable String Id) {

        return topicService.getTopic(Id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{Id}")
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic("Id", topic);
    }
    @DeleteMapping("/topics/{Id}")
    public void deleteTopic(@PathVariable String Id) {
        topicService.deleteTopic(Id);
    }
}
