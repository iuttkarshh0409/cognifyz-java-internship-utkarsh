import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {

        int length;
        char lower, upper;
        char digit;
        char specialChar;
        char choice;

        System.out.println("----Welcome to Password Generator Application----");

        System.out.println();

        // 1. Prompt the user for password length and preferences
        Scanner sc = new Scanner(System.in);
        
        do{
        System.out.println("--Input Menu--");
        // Ask user: password length
        System.out.print("Enter length of your password: ");
        length= sc.nextInt();
        sc.nextLine();

        if(length<5){
            System.out.println("Error: Password length should be at least 4 for security!\nRetry and Run the Application...");
            System.exit(0);
        }

        System.out.println();

        // Ask user: include lowercase? (y/n)
        System.out.print("Do you want to include lowercase characters in your password?\nInput: ");
        lower= sc.nextLine().charAt(0);

        System.out.println();

        // Ask user: include uppercase? (y/n)
        System.out.print("Do you want to include uppercase characters in your password?\nInput: ");
        upper= sc.nextLine().charAt(0);

        System.out.println();

        // Ask user: include digits? (y/n)
        System.out.print("Do you want to include digits(0-9) in your password?\nInput: ");
        digit= sc.nextLine().charAt(0);

        System.out.println();

        // Ask user: include special characters? (y/n)
        System.out.print("Do you want to include special characters in your password?\nInput: ");
        specialChar= sc.nextLine().charAt(0);

        System.out.println();

        // 2. Based on input, build a pool of characters
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[{]}|;:',<.>/?";

        StringBuilder charPool = new StringBuilder(); // final character pool to choose from

        // Include lowercase if user chose 'y' or 'Y'
        if (lower == 'y' || lower == 'Y') {
        charPool.append(lowerCase);
    }

        // Include uppercase if user chose 'y' or 'Y'
        if (upper == 'y' || upper == 'Y') {
        charPool.append(upperCase);
    }

        // Include digits if user chose 'y' or 'Y'
        if (digit == 'y' || digit == 'Y') {
        charPool.append(digits);
    }

        // Include special characters if user chose 'y' or 'Y'
        if (specialChar == 'y' || specialChar == 'Y') {
        charPool.append(special);
    }

        //Check if user selected at least one option
        if (charPool.length() == 0) {
        System.out.println("Please choose at least one option and try again!");
        System.exit(0);
    }


        // 3. Use Random to generate password of given length from the pool
        StringBuilder password = new StringBuilder();  // to store final password
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
        // Pick a random index from the charPool
        int index = rand.nextInt(charPool.length());

        // Append the character at that index to the password
        password.append(charPool.charAt(index));
}

        // 4. Display the generated password
        System.out.println("--Output Menu--");
        System.out.println("Generated Password: "+password);

        System.out.println();

        System.out.println("Do you want to generate another Password?\nInput: ");
        choice=sc.nextLine().trim().toLowerCase().charAt(0);
}
while(choice=='y'||choice=='Y');


        System.out.println();

        System.out.print("---Thank you for using Password Generator Application---");

        System.out.println();

        System.out.print("Exiting the program...");

        sc.close();
    }
}
