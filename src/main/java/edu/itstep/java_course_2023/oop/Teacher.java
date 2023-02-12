package edu.itstep.java_course_2023.oop;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance
public class Teacher extends Person implements  Serializable,Comparable {
    @java.io.Serial
    private static final long serialVersionUID = 1L;
    public Teacher(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        int result = this.getAge() - ((Teacher)o).getAge();
        return result;
    }


}
