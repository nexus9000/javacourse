package edu.itstep.java_course_2023.oop;

import jakarta.persistence.EntityManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListPersons {
    static Logger log = Logger.getLogger(ListPersons.class);

    public static void main(String... arg) {

//        ArrayList<Integer> list = new ArrayList<>();
//        ComputerScience cs = new ComputerScience(3, "comp science");
//        Teacher t1 = new Teacher("John", "Doe", 38);
//        Teacher t2 = new Teacher("John", "Doe", 30);
//
//        cs.addTeacher(t1);
//        cs.addTeacher(t2);
//        // cs.listTeachers();
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        cs.printValues(cs.getTeachers());
//        cs.printValues(arr);
//        try (FileWriter fw = new FileWriter("cs.props")) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("Computer Science Course:");
//            sb.append("teachers=");
//            sb.append(System.getProperty("line.separator"));
//            ArrayList<Teacher> t = cs.getTeachers();
//
//            for (Teacher teacher : t) {
//
//                sb.append(teacher);
//                sb.append(",");
//                //sb.append(System.getProperty("line.separator"));
//            }
//            fw.write(sb.toString());
//        } catch (IOException io) {
//            log.error(io.getMessage());
//        }
          initTable();
    }

    private static void initTable() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        SystemLogging log1 = new SystemLogging("student get excellent ");
        em.persist(log1);
//        List<Users> result = em.createQuery("from Users").getResultList();
//        System.out.println("##################################################");
//        for (Users user : result) {
//            System.out.println(user.getUserName() + " " + user.getPassword());
//        }
        em.getTransaction().commit();
        em.close();
    }
}//end class


