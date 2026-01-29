package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.CourseDAO;
import com.edutech.progressive.entity.Course;

public class CourseServiceImplJdbc  {
    private CourseDAO courseDAO;
    public List<Course> getAllCourses(){
        return new ArrayList<>();
        
    }
    public Course getCourseById(int courseId){
        return null;
    }
    public Integer addCourse(Course course){
        return -1;
    }
    public void updateCourse(Course course){

    }
    public void deleteCourse(int courseId){
        
    }
    

}