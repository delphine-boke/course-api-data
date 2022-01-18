package com.delphine.springbootquickstart.courseapidata.service;

import com.delphine.springbootquickstart.courseapidata.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    //create a mutable list
    //private List<Course> Courses = Arrays.asList(
    //Arrays.asList creates a new non-mutable list
    private List<Course> Courses = new ArrayList<>(Arrays.asList(
                    new Course("spring", "Spring Framework", "Spring Framework Description"),
                    new Course("java", "Core Java", "Java Core Description"),
                    new Course("javascript", "Javascript", "Javascript Description")
                    ));

    public List<Course> getAllCourses (){
        return Courses;
    }

    //GET method
    public Course getCourse(String id){

        return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //POST method
    public void addCourse(Course Course) {
        Courses.add(Course);
    }

    //PUT method
    public void updateCourse(String id, Course Course) {
        //use for loop to loop through the Courses
        for(int i = 0; i<Courses.size(); i++){
            Course t = Courses.get(i);
            if (t.getId().equals(id)){ //if the id matches, then replace Course
                Courses.set(i, Course);
                return;
            }
        }

    }

    //DELETE method
    public void deleteCourse(String id) {

        Courses.removeIf(t -> t.getId().equals(id));  //delete if getId equals inputId
    }

}
