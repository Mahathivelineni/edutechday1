package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.StudentDAO;
import com.edutech.progressive.entity.Student;

public class StudentServiceImplJdbc  {
    private StudentDAO studentDAO;
    public List<Student> getAllStudents(){
        return new ArrayList<>();
    }
    public Integer addStudent(Student student){
        return -1;
    }
    public List<Student> getAllStudentsSortedByName(){
        return new ArrayList<>();
    }
    public void deleteStudent(int studentId){

    }
    public Student getStudentById(int studentId){
        return null;
    }

}