package com.pluralsight;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class MainApp {

    public static HashMap<String,VendorTransaction> history = new HashMap<>();

    public static void main(String[] args) throws IOException {
        showHome();

    }
//HomeScreen

    public static void showHome() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome. What would you like to do?");
        System.out.println("[1] Make a deposit");
        System.out.println("[2] Make a payment");
        System.out.println("[3] Access Ledger");
        System.out.println("[4] Exit");

        int selection = Integer.parseInt(keyboard.nextLine());

        if (selection == 1){
            makeDeposit();
        //make deposit method
        }else if (selection == 2) {
            makePayment();
        //make payment method
        }else if(selection == 3) {
            accessLedger();
        //access ledger method
        }else if(selection == 4) {
            System.out.printf("Goodbye.");
        }else{
            System.out.println("Sorry, that's not an option");
            showHome();
        }


    }

    public static void makeDeposit() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("src/main/resources/VendorHistory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileReader fileReader = new FileReader("src/main/resources/VendorHistory.csv");

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

        bufferedWriter.write(date + "|" + vendor + "|" + description + "|" + Float.toString(amount));

        bufferedWriter.close();
    }


    public static void makePayment() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("src/main/resources/VendorHistory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileReader fileReader = new FileReader("src/main/resources/VendorHistory.csv");
        System.out.println("You have opted to make a payment.");

        System.out.println("Who are you making this payment to?");
        String vendor = keyboard.nextLine().trim();
        System.out.println("Enter date of transaction [mm/dd/yyyy].");
        String date = keyboard.nextLine().trim();
        System.out.println("Enter a brief description of this transaction.");
        String description = keyboard.nextLine().trim();
        System.out.println("Enter amount.");
        float amount = keyboard.nextFloat();

        bufferedWriter.write(date + "|" + vendor + "|" + description + "|" + Float.toString(amount));

        bufferedWriter.close();
    }


    public static void accessLedger() throws IOException {
        FileReader filereader = new FileReader("src/main/resources/VendorHistory.csv");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String input = bufferedReader.readLine();

        while(bufferedReader.readLine() !=null){
        System.out.println(input);


    }
    bufferedReader.close();
//Ledger -- right away when selected.
//-- have an option to only show deposits.
//--have an option to only show payments

}

}

