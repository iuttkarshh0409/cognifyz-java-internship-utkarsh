import java.util.Scanner;

class Palindrome{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        
        String originalStr="";
        String reversedStr="";

        System.out.print("Enter a String: ");
        originalStr= sc.nextLine();

        sc.close();

        originalStr = originalStr.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i=originalStr.length()-1; i>=0; i--){
            reversedStr+= originalStr.charAt(i);
        }

        if(originalStr.equals(reversedStr)){
            System.out.println("Observation: Entered String is a Palindrome");
        }
        else{
            System.out.println("Observation: Entered String is not a Palindrome");
        }
    }
}
