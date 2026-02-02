package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.StudentDAO;
import com.edutech.progressive.dao.StudentDAOImpl;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;

public class StudentServiceImplJdbc implements StudentService {
   StudentDAOImpl studentDAOImpl;
    
    public StudentServiceImplJdbc(StudentDAOImpl studentDAOImpl) {
        this.studentDAOImpl = studentDAOImpl;
    }
    @Override 
    public List<Student> getAllStudents() throws Exception{
        // try{
        
            return studentDAOImpl.getAllStudents();
     
    
    // }catch(SQLException e){
    //     throw new Exception("Unable to fetch students ",e);

    // }
}
    @Override 
    public Integer addStudent(Student student) throws Exception{
       
             return studentDAOImpl.addStudent(student);
        // }catch(SQLException e){
        // throw new Exception("Unable to fetch students ",e);

    }
      
    
    @Override 
    public List<Student> getAllStudentSortedByName() throws Exception{
    //  try{
            List<Student> students=studentDAOImpl.getAllStudents();
            students.sort(Comparator.comparing(Student::getFullName));
            return students;
    //  }catch(SQLException e){
    //     throw new Exception("Unable to fetch students ",e);

    // }
       
    }
    @Override 
    public void deleteStudent(int studentId) throws Exception{
    //  try{
            studentDAOImpl.deleteStudent(studentId);
    //  }catch(SQLException e){
    //     throw new Exception("Unable to fetch students ",e);

    // }
        

    }
    @Override 
    public Student getStudentById(int studentId) throws Exception{
    //    try{
            Student student=studentDAOImpl.getStudentById(studentId);
            //tudentDAO.deleteStudent(studentId);
            // 
            return student;
     
    // }catch(SQLException e){
    //     throw new Exception("Unable to fetch students ",e);

    // }

}
public void updateStudent(Student student) throws SQLException{
    studentDAOImpl.updateStudent(student);

}
}