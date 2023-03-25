package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();


    public void addStudent(Student student)
    {
        studentDb.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher)
    {
        teacherDb.put(teacher.getName(), teacher);
    }
    public void addStudentTeacherPair(String studentName, String teacherName)
    {
        studentDb.get(studentName).setTeacherName(teacherName);
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        for(Student student: studentDb.values())
        {
            students.add(student);
        }
        return students;
    }

    public void deleteTeacherByName(String name)
    {
        teacherDb.remove(name);
        for(Student student: studentDb.values())
        {
            if(student.getTeacherName()!=null && student.getTeacherName().equals(name))
                student.setTeacherName(null);
        }
    }

    public void deleteAllTeachers()
    {
        teacherDb.clear();
        for(Student student: studentDb.values())
        {
            student.setTeacherName(null);
        }
    }

    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = new ArrayList<>();
        for(Teacher teacher: teacherDb.values())
        {
            teachers.add(teacher);
        }
        return teachers;
    }
}
