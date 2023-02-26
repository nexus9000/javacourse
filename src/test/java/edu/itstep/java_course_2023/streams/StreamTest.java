package edu.itstep.java_course_2023.streams;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


 class StreamTest {
    List<Integer> numbers;
    @BeforeEach
    public void setUp(){
      numbers = Arrays.asList(33,55,77,111);
    }
    @Test
    @DisplayName("test map")
    void testMap(){
        //returns a stream consisting by applied functions
       List<Integer> sq = numbers.stream().map(x->x * x).toList();
       Assertions.assertEquals(4, sq.size());
       sq.forEach(System.out::println);
    }
    @Test
    void testStringMap(){
       List<String> names = Arrays.asList("Java", "Spring", "Python");
       List<String> result = names.parallelStream().filter(s->s.startsWith("S")).toList();
       result.forEach(System.out::println);
       Assertions.assertEquals(1, result.size());
       //declaration of a new List
       List<String> old = new ArrayList<>(names.size());
       //filtering
       for(String name : names){
          if(name.startsWith("S"))old.add(name);
       }
       Assertions.assertEquals(1, old.size());
       //iterations
       Iterator<String> it = old.iterator();
       while(it.hasNext()){
          System.out.println("from old style "+it.next());
       }
    }


}
