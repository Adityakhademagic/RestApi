package com.example.demo.service;


import ch.qos.logback.core.joran.conditional.ElseAction;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicService {
    @Autowired
    public TopicRepository topicRepository;
    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "sBoot", "SP"),
            new Topic("js", "jScript", "JS"),
            new Topic("Java", "jA", "J")
    ));

    public List<Topic> getAllTopics() {

        topics.addAll(topicRepository.findAll());
        return topics;
    }

    public Topic getTopic(String Id) {
        topicRepository.findById(Id);
        return topics.stream().filter(t -> t.getId().equals(Id)).findFirst().get();

    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
        topics.add(topic);
    }

    public void updateTopic(String Id, Topic topic) {
        topicRepository.save(topic);
        for(int i=0; i< topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId().equals(Id)) {
                topics.set(i, topic);
                return;
            }
        }
    }


    public void deleteTopic(String Id) {
        topicRepository.deleteById(Id);
        topics.removeIf(t -> t.getId().equals(Id));
    }


}
