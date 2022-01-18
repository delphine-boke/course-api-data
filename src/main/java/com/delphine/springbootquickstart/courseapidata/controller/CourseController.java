package com.delphine.springbootquickstart.courseapidata.controller;


import com.delphine.springbootquickstart.courseapidata.model.Course;
import com.delphine.springbootquickstart.courseapidata.model.Topic;
import com.delphine.springbootquickstart.courseapidata.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired    //means needs dependency injection
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){

        return courseService.getAllCourses(id);
    }

    //get topic by id
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public  Course getCourse(@PathVariable String id){ //id is available in the path

        return courseService.getCourse(id);
    }

    //create a new topic
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId){

        courseService.deleteCourse(topicId);
    }

//      @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
//    public void deleteCourse(@PathVariable String id){
//
//        courseService.deleteCourse(id);
//    }

}