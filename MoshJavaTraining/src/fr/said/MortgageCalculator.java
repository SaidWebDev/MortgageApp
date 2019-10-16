package fr.said;

public class MortgageCalculator {

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

     public  double calculateMortagage(){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short  numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public int getYears() {
        return this.getYears();
    }
    public double getPrincipal() {
        return this.principal;
    }

    public double getAnnualInterest() {
        return this.annualInterest;
    }

}
