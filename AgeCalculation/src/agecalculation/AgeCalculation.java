package agecalculation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("The current date and time is " + dtf.format(now));
        System.out.println("To calculate your age, please awnser the following questions with numerical answers in the format requested");
        boolean Invalid;
        LocalDateTime birth = null;
        do {

            try {
                Invalid = false;
                System.out.println("When were you born? (YYYY/MM/DD)");
                String str1 = input.next();

                System.out.println("What time were you born? (HH:MM:SS)");
                String str2 = input.next();

                String str3 = str1 + " " + str2;

                birth = LocalDateTime.parse(str3, dtf);
            } catch (Exception e) {
                Invalid = true;
                System.out.println("Invalid, please enter answers again");
            }

        } while (Invalid);
        LocalDateTime birthday = LocalDateTime.from(birth);

        long years = birthday.until(now, ChronoUnit.YEARS);
        birthday = birthday.plusYears(years);

        long months = birthday.until(now, ChronoUnit.MONTHS);
        birthday = birthday.plusMonths(months);

        long days = birthday.until(now, ChronoUnit.DAYS);
        birthday = birthday.plusDays(days);

        long hours = birthday.until(now, ChronoUnit.HOURS);
        birthday = birthday.plusHours(hours);

        long minutes = birthday.until(now, ChronoUnit.MINUTES);
        birthday = birthday.plusMinutes(minutes);

        long seconds = birthday.until(now, ChronoUnit.SECONDS);

        System.out.println();

        long life = 80 - years;

        if (life > 80) {
            System.out.println("You have not been born.");
        } else {

            System.out.println("your age: " + years + " years, " + months + " months, " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");

            if (life < 0) {
                System.out.println("You are likely already dead.");
            } else {

                System.out.println();

                System.out.println("The average life expectancy is around 80.");
                System.out.println("Estimated time to death: " + life + " years, " + months + " months, " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");

                System.out.println();

                System.out.println("For a more accurate prediction, please awnser the following questions.");

                System.out.println("Do you smoke regularly? (Y/N).");
                String smoke = input.next();

                if (smoke.equalsIgnoreCase("Y")) {
                    life -= 10;
                }
                System.out.println("Do you drink regularly? (Y/N.)");
                String drink = input.next();

                if (drink.equalsIgnoreCase("Y")) {
                    life -= 2;
                }
                System.out.println("Do you exercise regularly? (Y/N).");
                String ex = input.next();

                if (ex.equalsIgnoreCase("Y")) {
                    life += 3;
                }
                System.out.println("Do you eat food? (Y/N).");
                String food = input.next();

                if (food.equalsIgnoreCase("N")) {
                    life = 0;
                    months = 1;
                }
                System.out.println("Do you drink water? (Y/N).");
                String water = input.next();

                if (water.equalsIgnoreCase("N")) {
                    life = 0;
                    months = 0;
                    days = 2;
                }
                System.out.println("Accurate estimated time to death: " + life + " years, " + months + " months, " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
                System.out.println("You will likely die at age: " + (years + life) + ".");
            }
        }
    }
}
