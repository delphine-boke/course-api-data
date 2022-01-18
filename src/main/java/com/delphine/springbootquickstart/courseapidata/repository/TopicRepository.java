package com.delphine.springbootquickstart.courseapidata.repository;

import com.delphine.springbootquickstart.courseapidata.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TopicRepository extends CrudRepository <Topic, String>{
    Topic findOne(String id);
    //some structure:
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
    //thus we use an interface instead of a class
    //CrudRepository<entity class, id of the entity class>
}
