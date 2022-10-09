package com.itacademy.homework3.service;

import com.itacademy.homework3.model.Transactions;

import java.util.Scanner;

public class TransactionService {
    public static Transactions inputTransaction() {
        Transactions transaction = new Transactions();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Account id: " + "\n" + "*require field");
            transaction.setAccountId(scanner.nextInt());
            System.out.println("Enter amount: " + "\n" + "*require field");
            transaction.setAmount(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Invalid data, Please, try again");
        }
        return transaction;
    }

        public static Transactions withdrawTransaction () {
            Transactions transaction = new Transactions();
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter AccountId : " + "\n" + "*require field");
                transaction.setAccountId(scanner.nextInt());
                System.out.println("Enter amount: ");
                transaction.setAmount(scanner.nextInt());
                return transaction;
            } catch (Exception e) {
                System.out.println("Invalid data, Please, try again");
            }
            return transaction;
        }
    }
