package com.driver;

import java.util.Arrays;
import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this .name=name;
        this.balance=balance;
        this.minBalance=minBalance;



    }

    public String getName() {
        return name;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random random=new Random();
        int currSum=0;
        int accountNumber[]=new int [digits];
        //store random number  to first n-1 place using rand object
        for(int i=0;i<digits-1;i++)
        {
            accountNumber[i] = random.nextInt(10);
            currSum+=accountNumber[i];
        }
        //random number at n-1 place
        accountNumber[digits-1]=(sum-currSum+10)%10;
        //+10mbecause no negative number occur and value between 0 to 9;
        if(accountNumber[digits-1]<0&&accountNumber[digits-1]>9)
        {
            throw new Exception("Account Number can not be generated");
        }
        return Arrays.toString(accountNumber).replaceAll("[^0-9]"," ");


    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance=balance+amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
          if(amount<minBalance)
          {
              throw  new Exception("Insufficient Balance");
          }
          else{
              balance-=amount;
          }
    }

}