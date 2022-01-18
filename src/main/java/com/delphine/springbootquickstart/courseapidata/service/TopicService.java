package com.delphine.springbootquickstart.courseapidata.service;

import com.delphine.springbootquickstart.courseapidata.model.Topic;
import com.delphine.springbootquickstart.courseapidata.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    //create a mutable list
    //private List<Topic> topics = Arrays.asList(
    //Arrays.asList creates a new non-mutable list
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                    new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core Java", "Java Core Description"),
                    new Topic("javascript", "Javascript", "Javascript Description")
                    ));

    public List<Topic> getAllTopics (){
        //return topics replacement
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    //GET method
    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); replacement
        //hence we create the class findOne in TopicRepository
        return topicRepository.findOne(id);
    }

    //POST method
    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    //PUT method
    public void updateTopic(String id, Topic topic) {
//        //use for loop to loop through the topics replacement
//        for(int i = 0; i<topics.size(); i++){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){ //if the id matches, then replace topic
//                topics.set(i, topic);
//                return;
//            }
        topicRepository.save(topic);  //save can be used twice as long as we pass an instance
        }

    //DELETE method
    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));  //delete if getId equals inputId replacement
        topicRepository.deleteById(id);
    }

}
