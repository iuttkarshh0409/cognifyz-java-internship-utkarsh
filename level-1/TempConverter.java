import java.util.*;

class Converter {
    double temp, convertedTemp;
    String unit;

    public Converter() {
        System.out.println("---- Welcome to Temperature Converter Application ----");
    }

    void input(Scanner sc) {
        try {
            System.out.println();
            System.out.print("Enter the temperature: ");
            temp = sc.nextDouble();
            sc.nextLine(); // clear buffer

            System.out.print("Enter the unit (Celsius or Fahrenheit): ");
            unit = sc.nextLine().trim();

            System.out.println("Temperature entered: " + temp + " " + unit);
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input! Please enter a numeric temperature and valid unit.");
            System.exit(1);
        }
    }

    void convert() {
        System.out.println("\n-- Initialising Temperature Conversion --");

        switch (unit) {
            case "Celsius" -> {
                convertedTemp = ((9.0 / 5.0 * temp) + 32);
                System.out.println("Temperature in Fahrenheit: " + convertedTemp);
            }

            case "Fahrenheit" -> {
                convertedTemp = (5.0 / 9.0 * (temp - 32));
                System.out.println("Temperature in Celsius: " + convertedTemp);
            }

            default -> System.out.println("Enter a valid temperature unit (Celsius or Fahrenheit)!");
        }

        System.out.println("\n---- Thank you for using Temperature Converter ----");
    }
}

public class TempConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            Converter tc = new Converter();
            tc.input(sc);
            tc.convert();

            System.out.print("\nDo you want to convert another temperature? (Y/N): ");
            choice = sc.nextLine().trim();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("\nExiting the Application... See you next time!");
        sc.close();
    }
}
