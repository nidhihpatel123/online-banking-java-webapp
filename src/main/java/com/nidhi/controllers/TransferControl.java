package com.nidhi.controllers;

import com.nidhi.entities.CheckingAccount;
import com.nidhi.entities.SavingsAccount;
import com.nidhi.entities.Transaction;

import javax.swing.*;

public class TransferControl {
    String toAccount;
    String fromAccount;
    String UName;
    String Name;
    String Balance;

    public TransferControl(String ToAccount,String FromAccount,String uName, String name, String balance){
        toAccount = ToAccount;
        fromAccount = FromAccount;
        UName =  uName;
        Name = name;
        Balance = balance;

    }

    public void transfer(){
        String fromAccountType = fromAccount.substring(0,8);
        String toAccountType = toAccount.substring(0,8);

        if (fromAccount.equals("Select Account") || toAccount.equals("Select Account")) {
            JOptionPane.showMessageDialog(null, "Please choose Account type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
        if(fromAccountType.equals("Checking") && toAccountType.equals("Savings ")){
            String fromAccountNumber = fromAccount.substring(11,19);
            String toAccountNumber = toAccount.substring(10,18);
            CheckingAccount check = new CheckingAccount(fromAccountNumber, Name, UName, Balance);
            Boolean withdrawstatus = check.Withdraw();
            Boolean depositstatus = false;
            if(withdrawstatus){
                SavingsAccount savacc = new SavingsAccount(toAccountNumber, Name, UName,"0.0", Balance);
                depositstatus = savacc.deposit();
            }
            if (withdrawstatus && depositstatus) {
                JOptionPane.showMessageDialog(null, "Successfully Transfer!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                Transaction transct = new Transaction(Balance, "Transfer",fromAccountNumber,toAccountNumber,UName);
                transct.record();
            } else {
                JOptionPane.showMessageDialog(null, "UnSuccessfully Transfer!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        if(fromAccountType.equals("Savings ") && toAccountType.equals("Checking")){
            String fromAccountNumber = fromAccount.substring(10,18);
            String toAccountNumber = toAccount.substring(11,19);

            SavingsAccount savacc = new SavingsAccount(fromAccountNumber, Name, UName,"0.0", Balance);
            Boolean withdrawstatus = savacc.withdraw();
            Boolean depositstatus = false;
            if(withdrawstatus){
                CheckingAccount check = new CheckingAccount(toAccountNumber, Name, UName, Balance);
                depositstatus = check.deposit();
            }

            if (withdrawstatus && depositstatus) {
                JOptionPane.showMessageDialog(null, "Successfully Transfer!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                Transaction transct = new Transaction(Balance, "Transfer",fromAccountNumber,toAccountNumber,UName);
                transct.record();
            } else {
                JOptionPane.showMessageDialog(null, "UnSuccessfully Transfer!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
}
