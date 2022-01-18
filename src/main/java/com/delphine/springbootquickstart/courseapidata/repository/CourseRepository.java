package com.delphine.springbootquickstart.courseapidata.repository;

import com.delphine.springbootquickstart.courseapidata.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    Course findOne(String id);

    //public List<Course> getCourseByTopic(String topicId);
    //public List<Course> findByName(String name);

    public  List<Course> findByTopic(String topicId);


}