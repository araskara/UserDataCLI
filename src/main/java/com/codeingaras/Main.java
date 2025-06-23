package com.codeingaras;

import com.codeingaras.dao.UserDAO;
import com.codeingaras.model.User;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        userDAO.createTable();

//        userDAO.insertUser(new User("Aras"));
//        userDAO.insertUser(new User("Babek"));
//        userDAO.insertUser(new User("David"));
//        userDAO.deleteUser(1);
//        userDAO.updateUser(3,"John Doe");

        System.out.println("Welcome to CRUD Dashboard!");

        while(true){

            System.out.println("\nMenu: ");
            System.out.println("1. List Users");
            System.out.println("2. Create User");
            System.out.println("3. Delete User");
            System.out.println("4. Update User");
            System.out.println("0. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            switch(choice){

                case 0:
                    scanner.close();
                    return;

                case 1:
                    List<User> users = userDAO.getAllUsers();
                    for (User user : users) {
                        System.out.println( "ID: "+ user.getId() + " Name: "+ user.getName() );
                    }
                    break;

                case 2:
                    System.out.println("Enter user name: ");
                    String name = scanner.next();
                    userDAO.insertUser(new User(name));
                    System.out.println("User created!");
                    break;

                case 3:
                    System.out.println("Enter user id: ");
                    int id = scanner.nextInt();
                    userDAO.deleteUser(id);
                    break;

                case 4:
                    System.out.println("Enter user id (Number!): ");
                    int idEntered = scanner.nextInt();
                    System.out.println("Enter NEW name: ");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    userDAO.updateUser(idEntered, newName);
                    System.out.println("User updated!");
                    break;




            }

        }




//        List<User> users = userDAO.getAllUsers();
//        for (User user : users) {
//            System.out.println( "ID: "+ user.getId() + " Name: "+ user.getName() );
//        }

    }
}



