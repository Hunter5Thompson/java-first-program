package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;


public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for(int i = 0; i < credits.length; i++){
            sum += credits[i];
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for(int i = 0; i < debits.length; i++){
            sum += debits[i];
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate(){
        int result = (int) (sumOfCredits() - sumOfDebits());
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter credits as a string, separated by commas: ");
        String creditsAsString = scanner.nextLine();
        System.out.println("Enter debits as a string, separated by commas: ");
        String debitsAsString = scanner.nextLine();
        scanner.close();

        String[] credits = creditsAsString.split(",");
        String[] debits = debitsAsString.split(",");

        float[] creditsAsFloat = new float[credits.length];
        for (int i = 0; i < credits.length; i++) {
            creditsAsFloat[i] = Float.parseFloat(credits[i]);
        }

        float[] debitsAsFloat = new float[debits.length];
        for (int i = 0; i < debits.length; i++) {
            debitsAsFloat[i] = Float.parseFloat(debits[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(creditsAsFloat, debitsAsFloat);
        float netSavings = calculator.calculate();

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
    }

