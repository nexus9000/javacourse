package edu.itstep.java_course_2023.oop;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private  String firstName;
    @Column (name="last_name")
    private  String lastName;
    @Column (name="age")
    private int age;
    public static int instanceCount ;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        instanceCount++;
    }
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        instanceCount++;
    }




    @Override
    public String toString(){
        return firstName.toUpperCase() + " "+lastName.toUpperCase() + " age:"+age;
    }
}
