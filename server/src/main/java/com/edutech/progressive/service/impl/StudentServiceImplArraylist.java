package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Student;

public class StudentServiceImplArraylist  {
     public static List<Student> studentList = new ArrayList<>();
    
    public List<Student> getAllStudents(){
        return studentList;
    }
    public Integer addStudent(Student student){
        studentList.add(student);
        return studentList.size();
    }
    public List<Student> getAllStudentSortedByName(){
        Collections.sort(studentList);
        return studentList;
    }
    public void emptyArrayList(){
        studentList.clear();

    }
   

}