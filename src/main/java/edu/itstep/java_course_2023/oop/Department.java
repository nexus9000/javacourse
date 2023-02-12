package edu.itstep.java_course_2023.oop;

public interface Department {
   public final int gradeDepartament = 3;
   public final int numberTeachers = 1;
   public String getName();
   public String setName(String name);
   //> Java 1.8
   public default int gradeDepartament(int coefImp){
      return gradeDepartament*coefImp;
   }
   public static int countNumberTeachers(){
      return numberTeachers;
   }

}
