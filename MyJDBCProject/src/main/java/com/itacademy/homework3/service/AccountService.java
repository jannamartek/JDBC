package com.itacademy.homework3.service;

import com.itacademy.homework3.model.Accounts;

import java.util.Scanner;

public class AccountService {
    public static Accounts inputAccount() {
        Accounts account = new Accounts();
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {
            try {
                System.out.println("Enter User's id: " + "\n" + "*require field");
                account.setUserId(scanner.nextInt());
                System.out.println("Enter balance account: " + "\n" + "*require field");
                account.setBalance(scanner.nextInt());
                System.out.println("Enter currency: " + "\n" + "Available currency:" +
                        " BYN, RUR, EUR, USD" + "\n" + "*require field");
                account.setCurrency(scanner.nextLine());
                account.setCurrency(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("There is no user with such ID in the system");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } while (!valid);
        return account;
    }
}