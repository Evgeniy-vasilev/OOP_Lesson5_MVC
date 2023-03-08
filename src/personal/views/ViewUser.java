package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private final UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE -> create();
                    case READ -> read();
                    case LIST -> list();
                    case UPDATE -> updateUser();
                    case DELETE -> deleteUser();
                    case HELP -> help();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteUser() throws Exception {
        String userid = prompt("Введите ID контакта для удаления: ");
        User _user = userController.readUser(userid);
        userController.deleteUser(_user);
    }

    private void updateUser() throws Exception {
        String readId = prompt("Введите ID контакта для редактирования: ");
        userController.updateUser(readId, inputUser());
    }

    private void list() {
        List<User> listUsers = userController.readAllUsers();
        for (User user : listUsers) {
            System.out.println(user + "\n");
        }
    }

    private void read() throws Exception {
        String id = prompt("ID пользователя: ");
        User user = userController.readUser(id);
        System.out.println(user);
    }

    private void create() throws Exception {
        userController.saveUser(inputUser());
    }

    private User inputUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }

    private void help() {
        System.out.println("Список команд: ");
        for (Commands com : Commands.values()) {
            System.out.println(com);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
