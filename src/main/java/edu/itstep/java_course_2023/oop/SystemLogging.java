package edu.itstep.java_course_2023.oop;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name="events")
public class SystemLogging {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="events")
    private String events;

    public SystemLogging(String events){
        this.events = events;
    }
}
