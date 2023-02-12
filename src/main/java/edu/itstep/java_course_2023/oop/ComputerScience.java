package edu.itstep.java_course_2023.oop;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComputerScience implements Department{
    static Logger log = Logger.getLogger(ComputerScience.class);
    String name;
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Students>students = new ArrayList<>();
    private int numberTeachers;
    public ComputerScience(int numberTeachers, String name){
        this.name = name;
        numberTeachers =   numberTeachers * Department.numberTeachers;
    }
    public void addTeacher(Teacher t1){
        teachers.add(t1);
    }
    //lambda functions
    public void listTeachers(){
        teachers.forEach(p->log.info(p));
    }
    @Override
    public String getName() {
        return name;
    }
    public void addStudent(Students s1){
        students.add(s1);
    }

    public ArrayList<Students> getStudents() {
        Collections.sort(students);
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        Collections.sort(teachers);
        return teachers;
    }

    @Override
    public String setName(String name) {
        return name;
    }

    public  <E> void  printValues(@NotNull Collection<E> values){
          for (E el : values){
            log.info(el);
          }
    }
}
