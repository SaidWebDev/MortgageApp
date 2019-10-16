package fr.said;

import java.text.NumberFormat;

public class Mortgage {

    private  MortgageCalculator calculator;

    public Mortgage(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule(){
        int nbrOfMonths= calculator.getYears()*12;
        double monthlyInterest= calculator.getAnnualInterest()/100/12;
        double onePlusCPowN= Math.pow((1+ monthlyInterest),nbrOfMonths);


        double monthlyPayment=0;
        for(int i=1; i<=nbrOfMonths; i++){
            double onePlusCPowP= Math.pow(1+ monthlyInterest,i);
            monthlyPayment= calculator.getPrincipal()*((onePlusCPowN-onePlusCPowP)/(onePlusCPowN-1));
            System.out.println(NumberFormat.getCurrencyInstance().format(monthlyPayment));
        }
    }

    public void printMortgage(){
        double mortgage= calculator.calculateMortagage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("         ");
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
