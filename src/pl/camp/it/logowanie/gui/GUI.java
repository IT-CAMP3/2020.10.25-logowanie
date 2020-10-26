package pl.camp.it.logowanie.gui;

import pl.camp.it.logowanie.database.UserRepositoryDataBase;
import pl.camp.it.logowanie.database.UsersRepository;
import pl.camp.it.logowanie.model.User;

import java.util.List;
import java.util.Scanner;

public class GUI {
    private static Scanner scanner = new Scanner(System.in);
    private static UserRepositoryInterface usersRepository;

    public static void showMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        switch(scanner.nextLine()) {
            case "1":
                showLoginScreen();
                showMainMenu();
                break;
            case "2":
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            case "9":
                showDatabase();
                showMainMenu();
                default:
                    System.out.println("Nieprawidlowy wybor !!");
                    showMainMenu();
                    break;
        }
    }

    private static void showLoginScreen() {
        System.out.println("Podaj login:");
        String login = scanner.nextLine();
        System.out.println("Podaj haslo:");
        String pass = scanner.nextLine();
        boolean authenticationResult = usersRepository.authenticate(login, pass);
        if(authenticationResult) {
            System.out.println("Zalogowano !!");
        } else {
            System.out.println("Bledne dane !!");
        }
    }

    private static void showRegisterScreen() {
        System.out.println("Podaj login:");
        String login = scanner.nextLine();
        System.out.println("Podaj haslo:");
        String pass = scanner.nextLine();

        boolean registerResult = usersRepository.register(login, pass);

        if(registerResult) {
            System.out.println("Rejestracja udana !!");
        } else {
            System.out.println("Login zajety !!");
        }
    }

    private static void showDatabase() {
        List<User> userList = usersRepository.getUserList();
        for(User user : userList) {
            System.out.println(user);
        }
    }
}
