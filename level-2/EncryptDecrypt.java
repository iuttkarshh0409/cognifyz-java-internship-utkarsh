import java.io.*;
import java.util.Scanner;

public class EncryptDecrypt {

    // Method to encrypt the file using Caesar Cipher (+3 shift)
    static void encryptFile(String inputPath, String outputPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        String line;
        while ((line = reader.readLine()) != null) {
            StringBuilder encryptedLine = new StringBuilder();
            for (char ch : line.toCharArray()) {
                encryptedLine.append((char) (ch + 3));
            }
            writer.write(encryptedLine.toString());
            writer.newLine();
        }

        reader.close();
        writer.close();
        System.out.println("\nFile successfully encrypted and saved as: " + outputPath);
    }

    // Method to decrypt the file using Caesar Cipher (-3 shift)
    static void decryptFile(String inputPath, String outputPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        String line;
        while ((line = reader.readLine()) != null) {
            StringBuilder decryptedLine = new StringBuilder();
            for (char ch : line.toCharArray()) {
                decryptedLine.append((char) (ch - 3));
            }
            writer.write(decryptedLine.toString());
            writer.newLine();
        }

        reader.close();
        writer.close();
        System.out.println("\nFile successfully decrypted and saved as: " + outputPath);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        String filePath;

        System.out.println("----     Welcome to File Encrypter/Decrypter Application     ----\n");

        try {
            System.out.println("Application Menu: ");
            System.out.println("Press E to encrypt a file");
            System.out.println("Press D to decrypt a file");
            System.out.print("Input: ");
            choice = sc.nextLine();

            System.out.print("\nEnter file name or path: ");
            filePath = sc.nextLine();

            switch (choice) {
                case "E" -> encryptFile(filePath, "encrypted_" + new File(filePath).getName());
                case "D" -> decryptFile(filePath, "decrypted_" + new File(filePath).getName());
                default -> System.out.println("Error: Please enter a valid choice!(E/D)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found! Check the path and try again.");
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
