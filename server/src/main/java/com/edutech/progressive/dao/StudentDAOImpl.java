package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Student;

public class StudentDAOImpl implements StudentDAO {
     private Connection connection;
    
    public StudentDAOImpl() throws SQLException {
        this.connection=DatabaseConnectionManager.getConnection();

    }
    @Override 
    public int addStudent(Student student) throws SQLException{
        String str="INSERT INTO student(full_name,date_of_birth,contact_number,email,address) values(?,?,?,?,?)";
    try(
    PreparedStatement ps=connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1,student.getFullName());
       // java.util.Date dob=student.getDateOfBirth();
        ps.setDate(2,new Date(student.getDateOfBirth().getTime()));
       // ps.setDate(2,student.getDateOfBirth());
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }

    }
    return -1;
        
    }
    @Override
    public Student getStudentById(int studentId) throws SQLException{
         String sql="SELECT * FROM student WHERE student_id=?";
        Student student =null;
        try(
    PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1,studentId);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
           student=new Student();
           student.setStudentId(rs.getInt("student_id"));
           student.setFullName(rs.getString("full_name"));
           student.setDateOfBirth(rs.getDate("date_of_birth"));
           student.setContactNumber(rs.getString("contact_number"));
           student.setEmail(rs.getString("email"));
           student.setAddress(rs.getString("address"));

        }

    }
    return student;
    }
    @Override 
    public void updateStudent(Student student) throws SQLException{
         String str="UPDATE student SET full_name=?, date_of_birth=?,contact_number=?,email=?,address=? WHERE student_id=?";
        try(
    PreparedStatement ps= connection.prepareStatement(str)){
        ps.setString(1,student.getFullName());
       // ps.setDate(2,student.getDateOfBirth());
       
        ps.setDate(2,new Date(student.getDateOfBirth().getTime()));
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        ps.setInt(6,student.getStudentId());
        ps.executeUpdate();
    }

    }
    @Override 
    public void deleteStudent(int studentId) throws SQLException{
         String str="DELETE FROM student WHERE student_id=?";
        try(
    PreparedStatement ps=connection.prepareStatement(str)){
        ps.setInt(1,studentId);
        ps.executeUpdate();
    }


    }
    @Override 
    public List<Student>  getAllStudents() throws SQLException{
         List<Student> students =new ArrayList<>();
       String str="SELECT * FROM student";
       try(
    PreparedStatement ps=connection.prepareStatement(str);
ResultSet rs= ps.executeQuery()){
    while(rs.next()){
        Student student =new Student();
        student.setStudentId(rs.getInt("student_id"));
        student.setFullName(rs.getString("full_name"));
        student.setDateOfBirth(rs.getDate("date_of_birth"));
        student.setEmail(rs.getString("email"));
        student.setContactNumber(rs.getString("contact_number"));
          student.setAddress(rs.getString("address"));
           students.add(student);


    }
}
return students;
        
    }
        
    }


