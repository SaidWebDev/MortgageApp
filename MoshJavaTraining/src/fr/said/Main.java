package fr.said;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal= (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest= (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years= (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage= calculateMortagage(principal, annualInterest, years );
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("         ");
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);

        monthlyPayments(principal,annualInterest,years);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner= new Scanner(System.in);
        double value=0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between "+ min + " and " + max);
        }
        return value;
    }

    public static double calculateMortagage(
            int principal,
            float annualInterest,
            byte years){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short  numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static void monthlyPayments(int principal, float annualInterest, byte years ){
        int nbrOfMonths= years*12;
        double monthlyInterest= annualInterest/100/12;
        double onePlusCPowN= Math.pow((1+ monthlyInterest),nbrOfMonths);


        double monthlyPayment=0;
        for(int i=1; i<=nbrOfMonths; i++){
            double onePlusCPowP= Math.pow(1+ monthlyInterest,i);
            monthlyPayment= principal*((onePlusCPowN-onePlusCPowP)/(onePlusCPowN-1));
            System.out.println(NumberFormat.getCurrencyInstance().format(monthlyPayment));
        }

    }
}

