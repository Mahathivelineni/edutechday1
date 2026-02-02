package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO {
    private Connection connection;
    
    public CourseDAOImpl() throws SQLException {
        this.connection=DatabaseConnectionManager.getConnection();

    }
    @Override
    public int addCourse(Course course) throws SQLException{
        String str="INSERT INTO course(course_name,description,teacher_id) values(?,?,?)";
        try(
    PreparedStatement ps=connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1,course.getCourseName());
        ps.setString(2,course.getDescription());
        ps.setInt(3,course.getTeacherId());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
    }
    return  course.getCourseId();
    }
    @Override 
    public Course getCourseById(int courseId)throws SQLException{
        String sql="SELECT * FROM course WHERE course_id=?";
        Course course =null;
        try(
    PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1,courseId);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
           course=new Course();
           course.setCourseId(rs.getInt("course_id"));
           course.setCourseName(rs.getString("course_name"));
           course.setDescription(rs.getString("description"));
           course.setTeacherId(rs.getInt("teacher_id"));

        }

    }
    return course;
    }
    @Override 
    public void updateCourse(Course course)throws SQLException{
        String str="UPDATE course SET course_name=?, description=?,teacher_id=? WHERE course_id=?";
        try(
    PreparedStatement ps= connection.prepareStatement(str)){
        ps.setString(1,course.getCourseName());
        ps.setString(2,course.getDescription());
        ps.setInt(3,course.getTeacherId());
        ps.setInt(4,course.getCourseId());
        ps.executeUpdate();
    }

    }
    @Override 
    public void deleteCourse(int courseId) throws SQLException{
        String str="DELETE FROM course WHERE course_id=?";
        try(
    PreparedStatement ps=connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
        ps.setInt(1,courseId);
        ps.executeUpdate();
    }

    }
    @Override 
    public List<Course>  getAllCourses() throws SQLException{
       List<Course> courses =new ArrayList<>();
       String str="SELECT * FROM course";
       try(
    PreparedStatement ps=connection.prepareStatement(str);
ResultSet rs= ps.executeQuery()){
    while(rs.next()){
        Course course =new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
           course.setDescription(rs.getString("description"));
           course.setTeacherId(rs.getInt("teacher_id"));
           courses.add(course);


    }
}
return courses;
        
    }

}
