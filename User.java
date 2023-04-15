import java.util.Random;
import java.util.Scanner;

public class User {

    private static final Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;


    public User(String username, String password) {
        if (isValidUsername(username)) {
            this.username = username;
        }
        if (isValidPassword(password)) {
            this.password = encryptPassword(password);
        }

    }

    public static boolean isValidUsername(String username) {
        if (!username.startsWith(String.valueOf(username.charAt(0)).toUpperCase())) {
            System.out.println("Username must start with uppercase letter");
            return false;
        }
        if (username.length() < 3) {
            System.out.println("Username must have at least 3 characters");
            return false;
        }
        if (Character.isDigit(username.charAt(0))) {
            System.out.println("Username must not start with digit");
            return false;
        }
        return true;
    }


    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password length must be at least 8 characters long");
            return false;
        }
        if (!password.startsWith(String.valueOf(password.charAt(0)).toUpperCase())) {
            System.out.println("First letter of the password must be uppercase");
            return false;
        }
        return true;
    }

    public static String encryptPassword(String password) {
        StringBuilder builder = new StringBuilder(password.length());
        Random random = new Random();
        for (int i = 0; i < password.length(); i++) {
            int randomNumber = random.nextInt(26);
            int currentValue = password.charAt(i) + randomNumber;
            builder.append((char) currentValue);
        }
        return builder.toString();
    }

    public static String initializerUsername() {
        System.out.println("Enter your username: ");
        return scanner.nextLine();
    }

    public static String initializePassword() {
        System.out.println("Enter your password: ");
        return scanner.nextLine();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }


    public String toString() {
        return "Username: "
                + this.username + " "
                + "\n"
                + "Password: " + this.password + " "
                + "\n";
    }

    public static void exitScanner() {
        System.out.println("Scanner exiting");
        scanner.close();
    }


}
