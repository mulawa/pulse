
package pl.marlena;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime dCurrent = LocalDateTime.now();
        System.out.println("Current date: " + dCurrent);
        LocalDateTime birthDate;
        Scanner bd = new Scanner(System.in);
        System.out.println("Your date of birth  'yyyy-MM-dd HH:mm': ");
        birthDate = LocalDateTime.parse(bd.nextLine(), formatter);
        System.out.println("Your sex: \n"
                + "enter: M or F ");
        Sex sex = Sex.valueOf(bd.nextLine());
        System.out.println("Your condition:\n"
                + "EXTRA, GREAT, GOOD, OVERUSUAL, BASIC, WEAK, BAD");
        Condition condition = Condition.valueOf(bd.nextLine());
        bd.close();
        PulseCalculator pulseCalculatorCalculator = new PulseCalculator();
        pulseCalculatorCalculator.calculate(dCurrent, birthDate, sex, condition);
    }


}






