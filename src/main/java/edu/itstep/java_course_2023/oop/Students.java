package edu.itstep.java_course_2023.oop;

import org.jetbrains.annotations.NotNull;

public class Students extends Person implements Comparable{

    public Students(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return ((Students)o).getAge() - this.getAge();
    }
}
