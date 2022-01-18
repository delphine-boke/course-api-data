package com.delphine.springbootquickstart.courseapidata.repository;

import org.springframework.data.repository.CrudRepository;
import com.delphine.springbootquickstart.courseapidata.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
}
