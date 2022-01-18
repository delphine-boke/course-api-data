package com.delphine.springbootquickstart.courseapidata.service;

import com.delphine.springbootquickstart.courseapidata.model.Course;
import com.delphine.springbootquickstart.courseapidata.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    private List<Course> courses = new ArrayList<>(Arrays.asList(
//            new Course("spring", "Spring Framework", "Spring Framework Description"),
//            new Course("java", "Core Java", "Java Core Description"),
//            new Course("javascript", "Javascript", "Javascript Description")
//    ));

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopic(topicId)
                .forEach(courses::add);
        return courses;
    }

    //GET method
    public Course getCourse(String id) {
        //courseRepository.findByName("--");
        return courseRepository.findOne(id);
    }

    //POST method
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    //PUT method
    public void updateCourse(Course course) {
        courseRepository.save(course);  //save can be used twice as long as we pass an instance
    }

    //DELETE method
    public void deleteCourse(String topicId) {
        courseRepository.deleteById(topicId);
    }

//    //DELETE method
//    public void deleteCourse(String id) {
//        courseRepository.deleteById(id);
//    }

}