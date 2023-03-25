package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public void addStudents(Student student)
    {
         studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String studentName, String teacherName)
    {
        studentRepository.addStudentTeacherPair(studentName,teacherName);
    }

    public Student getStudentByName(String name)
    {
        List<Student> students = studentRepository.getAllStudents();
        for(Student student: students)
        {
            if(student.getName().equals(name))
                return student;
        }
        return null;

    }

    public Teacher getTeacherByName(String name)
    {
        List<Teacher> teachers = studentRepository.getAllTeachers();
        for(Teacher teacher: teachers)
        {
            if(teacher.getName().equals(name))
                return teacher;
        }
        return null;
    }

    public List<String> getStudentByTeacherName(String teacherName)
    {
        List<Student> students = studentRepository.getAllStudents();
        List<String> studentsByTeacherName = new ArrayList<>();
        for(Student student: students)
        {
            if(student.getTeacherName()!=null && student.getTeacherName().equals(teacherName))
                studentsByTeacherName.add(student.getName());
        }
        return studentsByTeacherName;
    }

    public List<String> getAllStudents()
    {
        List<Student> students = studentRepository.getAllStudents();
        List<String> studentNames = new ArrayList<>();
        for(Student student: students)
        {
            studentNames.add(student.getName());
        }
        return studentNames;
    }

    public void deleteTeacherByName(String teacher)
    {
        studentRepository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }
}
