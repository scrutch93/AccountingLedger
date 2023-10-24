package com.pluralsight;
import java.io.*;
import java.util.Scanner;
public class MainApp {


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

        FileWriter fileWriter = new FileWriter("text.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileReader fileReader = new FileReader("text.csv");

        BufferedReader bufferedReader = new BufferedReader(fileReader);


        System.out.println("You have opted to make a deposit.");

        System.out.println("Who are you making this deposit to?");
        String vendor = keyboard.nextLine();
        System.out.println("Enter date of transaction.");
        String date = keyboard.nextLine();
        System.out.println("Enter a brief description of this transaction.");
        String description = keyboard.nextLine();
        System.out.println("Enter amount.");
        float amount = keyboard.nextFloat();


    }


    public static void makePayment(){
        System.out.println("You have opted to make a payment.");

        System.out.println("Who are you making this payment to?");
        //
        System.out.println("Enter date of transaction.");

        System.out.println("Enter a brief description of this transaction.");

        System.out.println("Enter amount.");

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

