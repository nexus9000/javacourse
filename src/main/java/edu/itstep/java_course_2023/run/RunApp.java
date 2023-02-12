package edu.itstep.java_course_2023.run;

import java.util.Scanner;
import java.util.logging.Logger;

public class RunApp {
    static Logger log = Logger.getLogger(RunApp.class.getName());
    public static void main(String[] arg) {
        //ctrl+alt+L
        try (Scanner sc = new Scanner(System.in)) {
            log.info("First program!");
            log.info("Please, enter a first operand.");
            var operand1 = sc.nextInt();
            log.info("Please, enter a second operand.");
            var operand2 = sc.nextInt();
            var result = 0;
            log.info("test");
            System.out.printf("%S %d", "the result of sum is:", result);
        } catch (Exception e) {
           log.info("Invalid input, NaN!");
        } finally {
            log.info("Program finished!");
            //close Scanner
        }

    }


}
