package com.delphine.springbootquickstart.courseapidata.service;

import com.delphine.springbootquickstart.courseapidata.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    //create a mutable list
    //private List<Topic> topics = Arrays.asList(
    //Arrays.asList creates a new non-mutable list
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                    new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core Java", "Java Core Description"),
                    new Topic("javascript", "Javascript", "Javascript Description")
                    ));

    public List<Topic> getAllTopics (){
        return topics;
    }

    //GET method
    public Topic getTopic(String id){

        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //POST method
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    //PUT method
    public void updateTopic(String id, Topic topic) {
        //use for loop to loop through the topics
        for(int i = 0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){ //if the id matches, then replace topic
                topics.set(i, topic);
                return;
            }
        }

    }

    //DELETE method
    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id));  //delete if getId equals inputId
    }

}
