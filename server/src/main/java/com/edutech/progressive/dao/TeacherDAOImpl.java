package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
     private Connection connection;
    
    public TeacherDAOImpl() throws SQLException {
        this.connection=DatabaseConnectionManager.getConnection();

    }
    @Override 
    public int addTeacher(Teacher teacher) throws SQLException{
        String str="INSERT INTO teacher(full_name,subject,contact_number,email,years_of_experience) values(?,?,?,?,?)";
    try(
    PreparedStatement ps=connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1,teacher.getFullName());
        ps.setString(2,teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            //return rs.getInt(1);
            teacher.setTeacherId(rs.getInt(1));
        }
       // return 0;

    }
   return teacher.getTeacherId();
    }
    @Override 
    public Teacher getTeacherById(int teacherId) throws SQLException{
        String sql="SELECT * FROM teacher WHERE teacher_id=?";
        Teacher teacher =null;
        try(
    PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1,teacherId);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
           teacher=new Teacher();
           teacher.setTeacherId(rs.getInt("teacher_id"));
           teacher.setFullName(rs.getString("full_name"));
           teacher.setSubject(rs.getString("subject"));
           teacher.setContactNumber(rs.getString("contact_number"));
           teacher.setEmail(rs.getString("email"));
           teacher.setYearsOfExperience(rs.getInt("years_of_experience"));

        }

    }
    return teacher;
        
    }
    @Override 
    public void updateTeacher(Teacher teacher) throws SQLException{
          String str="UPDATE teacher SET full_name=?, subject=?,contact_number=?,email=?,years_of_experience=? WHERE teacher_id=?";
        try(
    PreparedStatement ps= connection.prepareStatement(str)){
        ps.setString(1,teacher.getFullName());
        ps.setString(2,teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        ps.setInt(6,teacher.getTeacherId());
        ps.executeUpdate();
    }


    }
    @Override 
    public void deleteTeacher(int teacherId) throws SQLException{
         String str="DELETE FROM teacher WHERE teacher_id=?";
        try(
    PreparedStatement ps=connection.prepareStatement(str)){
        ps.setInt(1,teacherId);
        ps.executeUpdate();
    }


    }
    @Override 
    public List<Teacher>  getAllTeachers() throws SQLException{
         List<Teacher> teachers =new ArrayList<>();
       String str="SELECT * FROM teacher";
       try(
    PreparedStatement ps=connection.prepareStatement(str);
ResultSet rs= ps.executeQuery()){
    while(rs.next()){
        Teacher teacher =new Teacher();
        teacher.setTeacherId(rs.getInt("teacher_id"));
        teacher.setFullName(rs.getString("full_name"));
        teacher.setSubject(rs.getString("subject"));
        teacher.setContactNumber(rs.getString("contact_number"));
        teacher.setEmail(rs.getString("email"));
        teacher.setYearsOfExperience(rs.getInt("years_of_experience"));
        teachers.add(teacher);


    }
}
return teachers;
        
    }
        
    }




