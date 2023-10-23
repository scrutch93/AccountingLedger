package com.pluralsight;
import java.util.Scanner;
public class MainApp {


    public static void main(String[] args) {
        showHome();

    }
//HomeScreen

    public static void showHome() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome. What would you like to do?");
        System.out.println("[1] Make a deposit");
        System.out.println("[2] Make a payment");
        System.out.println("[3] Access Ledger");
        System.out.println("[4] Exit");

        int selection = Integer.parseInt(keyboard.nextLine());

        if (selection == 1){
        //make deposit method
        }else if (selection == 2) {
        //make payment method
        }else if(selection == 3) {
        //access ledger method
        }else if(selection == 4) {
            System.out.printf("Goodbye.");
        }else{
            System.out.println("Sorry, that's not an option");
            showHome();
        }


    }


//Ledger -- right away when selected.
//-- have an option to only show deposits.
//--have an option to only show payments

}

