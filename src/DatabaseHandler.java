import java.util.Scanner;


public class DatabaseHandler {
    private final Scanner scan = new Scanner(System.in);
    private int choice = -1;

    public void run() {
        while (choice != 0) {
            menu();
            choice = readIntInput();
            choose(choice);
        }
    }

    private void menu() {
        System.out.println("Welcome to our database for user information");
        System.out.println();
        System.out.println("1 - List all users");
        System.out.println("2 - Find a user by ID");
        System.out.println("3 - Find a user by name");
        System.out.println("4 - Update password");
        System.out.println("5 - Delete user");
        System.out.println("6 - Add user");
        System.out.println("7 - Delete user by age");
        System.out.println("0 - Exit");
        System.out.println();
        System.out.println(" __|__ [This is not up to the GDPR requirements] __|__");
        System.out.println();
        System.out.println("Please select from the menu above.");
    }

    private int readIntInput() {
        int input = -1;
        try {
            input = scan.nextInt();
            scan.nextLine();
            if (input < 0) {
                System.out.println("Not valid input, try again!");
                readIntInput();
            }
        } catch (Exception e) {
            System.out.println("Give me a NUMBER.");
            scan.nextLine();
            readIntInput();
        }
        return input;
    }

    private String readStringInput() {
        return scan.nextLine();
    }

    private void choose(int choice) {
        UserDao user = new UserDaoImpl();
        switch (choice) {
            case 0 -> System.out.println("Guess you have all the private information you need. " +
                    "A dinner would have been nice...");
            case 1 -> {
                System.out.println(user.getAllUsers());
                System.out.println();
            }
            case 2 -> {
                System.out.println("Give me an ID");
                System.out.println(user.getUser(readIntInput()));
                System.out.println();
            }
            case 3 -> {
                System.out.println("Give me a name");
                System.out.println(user.getUser(readStringInput()));
                System.out.println();
            }
            case 4 -> {
                System.out.println("Give me the ID");
                int id = readIntInput();
                System.out.println("Give me the new password");
                String newPassword = readStringInput();
                System.out.println(user.updatePassword(id, newPassword));
                System.out.println();
            }
            case 5 -> {
                System.out.println("Give me the ID");
                System.out.println(user.deleteUser(readIntInput()));
                System.out.println();
            }
            case 6 -> {
                System.out.println("Give me the new ID");
                int id = readIntInput();
                System.out.println("Give me a name");
                String name = readStringInput();
                System.out.println("Give me the new password");
                String password = readStringInput();
                System.out.println("Give me the age");
                int age = readIntInput();
                System.out.println(user.addNewUser(id, name, password, age));
                System.out.println();
            }
            case 7 -> {
                System.out.println("Give me the age");
                System.out.println(user.deleteUserByAge(readIntInput()));
                System.out.println();
            }
        }
    }
}
