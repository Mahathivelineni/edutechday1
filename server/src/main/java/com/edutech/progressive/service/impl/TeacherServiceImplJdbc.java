package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.TeacherDAO;
import com.edutech.progressive.dao.TeacherDAOImpl;
import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService  {
    TeacherDAOImpl teacherDAO;
    
    public TeacherServiceImplJdbc(TeacherDAOImpl teacherDAO) {
        this.teacherDAO = teacherDAO;
    }
    @Override 
    public List<Teacher> getAllTeachers() throws Exception{
      // try{
            return teacherDAO.getAllTeachers();
      // }catch(SQLException e){
      //   throw new Exception("Unable to retrieve data",e);
      // }
        }
    
    @Override 
    public Integer addTeacher(Teacher teacher) throws Exception{
        // try{
            return teacherDAO.addTeacher(teacher);
        }
    // catch(SQLException e){
    //     throw new Exception("Unable to retrieve data",e);
    //   }
    
    
    @Override 
    public List<Teacher> getTeacherSortedByExperience() throws Exception{
      //  try{
             List<Teacher> teachers=teacherDAO.getAllTeachers();
            // Collections.sort(teachers);
            teachers.sort(Comparator.comparing(Teacher::getYearsOfExperience));
            return teachers;
      //   } catch(SQLException e){
      //   throw new Exception("Unable to retrieve data",e);
      // }
    }
      
    
    @Override 
    public void updateTeacher(Teacher teacher) throws Exception{
          // try{
            teacherDAO.updateTeacher(teacher);
        }
      //   catch(SQLException e){
      //   throw new Exception("Unable to retrieve data",e);
      // }
    
    @Override
    public void deleteTeacher(int teacherId) throws Exception{
// try{
            teacherDAO.deleteTeacher(teacherId);
        

    // }catch(SQLException e){
    //     throw new Exception("Unable to retrieve data",e);
    //   }
    }
    @Override
    public Teacher getTeacherById(int teacherId) throws Exception{
      // try{
            Teacher teacher=teacherDAO.getTeacherById(teacherId);
            //tudentDAO.deleteStudent(studentId);
          
            return teacher;
        
    // } catch(SQLException e){
    //     throw new Exception("Unable to retrieve data",e);
    //   }
    }
  }

