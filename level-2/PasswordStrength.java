//prototype code for task-2

import java.util.Scanner;
public class PasswordStrength {
    public static void main(String[] args) {
        
    Scanner sc= new Scanner(System.in);

    String password;

    System.out.print("----       Welcome to Password Strength Checker Application       ----");
    System.out.println();
    System.out.println();
    System.out.print("\nPassword Strength Menu: ");
    System.out.println();
    System.out.print("\n   GRADE          MUST HAVE");
    
    System.out.print("\n   Very Weak       Password Length <5");
    System.out.print("\n   Weak            Password Length >=5 + Upper case + Lower case Characters ");
    System.out.print("\n   Strong          Password Length >=5 + Upper case + Lower case Characters + Numeric Characters >=1 ");
    System.out.print("\n   Very Strong     Password Length >=5 + Upper case + Lower case Characters + Numeric Characters >=1 + Special Characters >=1 ");

    System.out.println();
    System.out.print("\n\nEnter your password for evaluation: ");
    password = sc.nextLine();

    boolean hasUpper = false;
    boolean hasLower = false;
    boolean hasDigit = false;
    boolean hasSpecial = false;

    for (int i = 0; i < password.length(); i++) {
    char ch = password.charAt(i);
    
    if (Character.isUpperCase(ch)) hasUpper = true;
    else if (Character.isLowerCase(ch)) hasLower = true;
    else if (Character.isDigit(ch)) hasDigit = true;
    else if ("!@#$%^&*()-_=+[{]}|;:',<.>/?".indexOf(ch) >= 0) hasSpecial = true;
}

if (password.length() < 5) {
    System.out.println("Result: Very Weak");
}
else if (hasUpper && hasLower && !hasDigit && !hasSpecial) {
    System.out.println("Result: Weak");
}
else if (hasUpper && hasLower && hasDigit && !hasSpecial) {
    System.out.println("Result: Strong");
}
else if (hasUpper && hasLower && hasDigit && hasSpecial) {
    System.out.println("Result: Very Strong");
}
else {
    System.out.println("Result: Moderate (Try to include more varied characters)");
}
   
    System.out.println("\n--- Thank you for using Password Strength Checker Application ---");
    sc.close(); 
    }  
}
