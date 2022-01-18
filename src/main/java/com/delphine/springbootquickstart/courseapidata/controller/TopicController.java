package com.delphine.springbootquickstart.courseapidata.controller;


import com.delphine.springbootquickstart.courseapidata.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired    //means needs dependency injection
    private CourseService courseService;

    @RequestMapping("/Courses")
    public List<Course> getAllCourses(){

        return CourseService.getAllCourses();
    }

    //get Course by id
    @RequestMapping("/Courses/{id}")
    public  Course getCourse(@PathVariable String id){ //id is available in the path

        return CourseService.getCourse(id);
    }

    //create a new Course
    @RequestMapping(method = RequestMethod.POST, value = "/Courses")
    public void addCourse(@RequestBody Course Course){

        CourseService.addCourse(Course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Courses/{id}")
    public void updateCourse(@RequestBody Course Course, @PathVariable String id){

        CourseService.updateCourse(id, Course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Courses/{id}")
    public void deleteCourse(@PathVariable String id){

        CourseService.deleteCourse(id);
    }

}
