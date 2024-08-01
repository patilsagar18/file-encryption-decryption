import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to choose encryption or decryption
        System.out.print("Choose operation (encrypt/decrypt): ");
        String operation = scanner.nextLine().trim().toLowerCase();

        // Prompt user for the file name or path
        System.out.print("Enter file name or path: ");
        String fileName = scanner.nextLine();

        // Perform encryption or decryption based on user choice
        switch (operation) {
            case "encrypt":
                encryptFile(fileName);
                break;
            case "decrypt":
                decryptFile(fileName);
                break;
            default:
                System.out.println("Invalid operation choice. Please choose encrypt or decrypt.");
        }

        scanner.close();
    }

    public static void encryptFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName));

            int character;
            while ((character = reader.read()) != -1) {
                char encryptedChar = (char) (character + 1); // Simple encryption: shift each character by 1
                writer.write(encryptedChar);
            }

            reader.close();
            writer.close();

            System.out.println("Encryption completed. Encrypted file saved as encrypted_" + fileName);
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }

    public static void decryptFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName));

            int character;
            while ((character = reader.read()) != -1) {
                char decryptedChar = (char) (character - 1); // Simple decryption: shift each character back by 1
                writer.write(decryptedChar);
            }

            reader.close();
            writer.close();

            System.out.println("Decryption completed. Decrypted file saved as decrypted_" + fileName);
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
