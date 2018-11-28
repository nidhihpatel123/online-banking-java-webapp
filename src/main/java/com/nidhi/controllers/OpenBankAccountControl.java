package com.nidhi.controllers; /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import com.nidhi.entities.CheckingAccount;
import com.nidhi.entities.SavingsAccount;
import com.nidhi.entities.Transaction;

import javax.swing.*;

public class OpenBankAccountControl
{




    public OpenBankAccountControl(String AcountType, String  AcountNumber, String  Name, String  UName, String  Balance) {
        //Use CheckingAccount object to invoke method openAcct()
        if (AcountType.equals("Checking")) {
            CheckingAccount CA = new CheckingAccount(AcountNumber, Name, UName, Balance);
            if (CA.openAcct()) {
                System.out.println("successful!");
                Transaction ts = new Transaction(Balance, "Deposit", "Checking", null, UName);
                ts.record();
                JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("fail!");
                JOptionPane.showMessageDialog(null, "Opening a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

	public OpenBankAccountControl (String AcountType, String  AcountNumber, String  Name, String  UName, String InterestRate, String  Balance) {
        if (AcountType.equals("Savings")) {
            SavingsAccount SA = new SavingsAccount(AcountNumber, Name, UName, InterestRate, Balance);
            if (SA.openSavAcct()) {
                System.out.println("successful!");
                Transaction ts = new Transaction(Balance,"Deposit","Savings",null,UName);
                ts.record();
                JOptionPane.showMessageDialog(null, "Opening a Savings Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);


            } else {
                System.out.println("fail!");
                JOptionPane.showMessageDialog(null, "Opening a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            }
        }


    }


    }
