package com.itacademy.homework3.service;

import com.itacademy.homework3.model.Users;

import java.util.Scanner;

public class UserService {
    public static Users inputUsers() {
        Users user = new Users();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter user name: " + "\n" + "*require field");
            user.setName(scanner.nextLine());
            if (!user.getName().isEmpty()) {
                System.out.println("Enter user address:" + "\n" + "*optional field");
                user.setAddress(scanner.nextLine());
                return user;
            } else {
                System.out.println("Field name cannot be empty. Please, try again.");
            }
        }
    }
}

