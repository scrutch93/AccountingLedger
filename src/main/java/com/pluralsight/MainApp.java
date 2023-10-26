package com.pluralsight;
import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Float;
import java.time.format.DateTimeFormatter;

import static java.lang.Float.parseFloat;

public class MainApp {

    public static HashMap<String, VendorTransaction> history = new HashMap<String, VendorTransaction>();

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome.");
        loadLedger();
        showHome();

    }
//HomeScreen

    public static void showHome() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] Make a deposit");
        System.out.println("[2] Make a payment");
        System.out.println("[3] Access Ledger");
        System.out.println("[4] Exit");

        int selection = Integer.parseInt(keyboard.nextLine());

        if (selection == 1) {
            makeDeposit();
            //make deposit method
        } else if (selection == 2) {
            makePayment();
            //make payment method
        } else if (selection == 3) {
            accessLedger();
            //access ledger method
        } else if (selection == 4) {
            System.out.printf("Goodbye.");
        } else {
            System.out.println("Sorry, that's not an option");
            showHome();
        }


    }

    public static void makeDeposit() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("src/main/resources/VendorHistory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //FileReader fileReader = new FileReader("src/main/resources/VendorHistory.csv");

        //BufferedReader bufferedReader = new BufferedReader(fileReader);

        System.out.println("You have opted to make a deposit.");

        System.out.println("Who are you making this deposit to?");
        String vendor = keyboard.nextLine().trim();
        System.out.println("Enter date of transaction [mm/dd/yyyy].");
        String date = keyboard.nextLine().trim();
        System.out.println("Enter a brief description of this transaction.");
        String description = keyboard.nextLine().trim();
        System.out.println("Enter amount.");
        float amount = keyboard.nextFloat();

        bufferedWriter.write(date + "|" + vendor + "|" + description + "|" + Float.toString(amount) + "|" + "Deposit");

        bufferedWriter.close();
        System.out.println("Deposit has been recorded.");
        loadLedger();
        showHome();
    }


    public static void makePayment() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("src/main/resources/VendorHistory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //FileReader fileReader = new FileReader("src/main/resources/VendorHistory.csv");
        System.out.println("You have opted to make a payment.");

        System.out.println("Who are you making this payment to?");
        String vendor = keyboard.nextLine().trim();
        System.out.println("Enter date of transaction [mm/dd/yyyy].");
        String date = keyboard.nextLine().trim();
        System.out.println("Enter a brief description of this transaction.");
        String description = keyboard.nextLine().trim();
        System.out.println("Enter amount.");
        float amount = keyboard.nextFloat();

        bufferedWriter.write("\n"+ date + "|" + vendor + "|" + description + "|" + Float.toString(amount) + "|" + "Payment");

        bufferedWriter.close();

        System.out.println("Your payment has been recorded.");
        loadLedger();
        showHome();

    }

    public static void loadLedger() throws IOException {

        FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] transaction = input.split("\\|");
            if (!transaction[1].equals("Name")) {
                String date = transaction[0];
                String name = transaction[1].trim();
                String description = transaction[2];
                float amount = Float.parseFloat(transaction[3].trim());
                String action = transaction[4];

                history.put(name, new VendorTransaction(date, name, description, amount, action));

            }

        }
        bufferedReader.close();

    }

    public static void accessLedger() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Ledger. What would you like to do?");
        System.out.println("[1] All history");
        System.out.println("[2] Deposits");
        System.out.println("[3] Payments");
        System.out.println("[4] Reports");
        System.out.println("[5] Return home");

        int selection = keyboard.nextInt();


        if (selection == 1) {


            FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String input;
            System.out.println("----------------------");
            while ((input = bufferedReader.readLine()) != null) {
//                String[] transaction = input.split("\\|");
//                if (!transaction[1].equals("Name")) {
//                    String date = transaction[0];
//                    String name = transaction[1];
//                    String description = transaction[2];
//                    float amount = Float.parseFloat(transaction[3].trim());
//                    String action = transaction[4];
//
//                    history.put(date, new VendorTransaction(date, name, description, amount, action));

                    System.out.println(input);


                }
                bufferedReader.close();
            System.out.println("----------------------");

            accessLedger();
            }

         else if (selection == 2) {
            //showDeposits
            showDeposits();

        } else if (selection == 3) {
            //showPayments
            showPayments();

        } else if (selection == 4) {
            //showReports
            showReports();
        } else {
            showHome();
        }


    }


    public static void showDeposits() throws IOException {
        System.out.println("Here is your deposit history: ");
        System.out.println("----------------------");
        FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.contains("Deposit")) {
                System.out.println(input);
            }

        }
        System.out.println("----------------------");

    }

    public static void showPayments() throws IOException {
        System.out.println("Here is your payment history: ");
        System.out.println("----------------------");
        FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.contains("Payment")) {
                System.out.println(input);
            }

        }
        System.out.println("----------------------");
    }

    public static void showReports() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Select from the following options");
        System.out.println("[1] Month to Date");
        System.out.println("[2] Previous Month");
        System.out.println("[3] Previous Year");
        System.out.println("[4] Search by Vendor");
        System.out.println("[5] Return to Previous Screen");
        System.out.println("[6] Home screen");

        int selection = keyboard.nextInt();
        if (selection == 1) {

        } else if (selection == 2) {

        } else if (selection == 3) {

        } else if (selection == 4) {
            vendorSearch();
        } else if (selection == 5) {
            accessLedger();
        } else if (selection == 6) {
            showHome();
        } else {
            System.out.println("That's not a valid entry.");
            showReports();
        }


    }

    public static void vendorSearch() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter vendor name: ");
        String responseOfName = keyboard.nextLine();
        System.out.println("----------------------");
        FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.contains(responseOfName)) {
                System.out.println(input);
            }

        }
        System.out.println("----------------------");
}

}