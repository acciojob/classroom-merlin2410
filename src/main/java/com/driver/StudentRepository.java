package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<Teacher,List<Student>> studentTeacher = new HashMap<>();


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
        Teacher teacher = teacherDb.get(teacherName);
        Student student = studentDb.get(studentName);
        if(studentTeacher.containsKey(teacher))
        {
            List<Student> students = studentTeacher.get(teacher);
            students.add(student);
            studentTeacher.put(teacher,students);
        }
        else
        {
            List<Student> students = new ArrayList<>();
            students.add(student);
            studentTeacher.put(teacher,students);
        }
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
        studentTeacher.remove(name);
    }

    public void deleteAllTeachers()
    {
        teacherDb.clear();
        studentTeacher.clear();
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

    public List<Student> getStudentByTeacherName(String teacherName)
    {
        return studentTeacher.get(teacherDb.get(teacherName));
    }
}
