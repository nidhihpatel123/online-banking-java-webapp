package com.nidhi.controllers; /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

//import com.nidhi.boundries.SelectBO;

import com.nidhi.boundries.BankingBO;
import com.nidhi.entities.Account;
import com.nidhi.utilities.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
    	String CustomerName = Acct.signIn();
        if (!CustomerName.equals("")) {
            System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

//           SelectBO selecto = new SelectBO();
//            selecto.show();
//           ManageAccountBOMy openBO = new ManageAccountBOMy(UName, CustomerName);
//           openBO.show();

           // ManageAccountControl openmanageCO = new ManageAccountControl(UName, CustomerName);
          // OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);

            String[] checkingAccountNumbers = getCheckingAccountNumbers(UName);
            String[] savingsAccountNUmbers = getSavingAccountNumbers(UName);

            BankingBO tabb = new BankingBO(UName,CustomerName,checkingAccountNumbers,savingsAccountNUmbers);

            //TransferBO mange = new TransferBO(UName, CustomerName,checkingAccountNumbers,savingsAccountNUmbers);

         } else{
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }

	}

	public String[] getCheckingAccountNumbers(String UName){
        String[] checkingAccountNumbers = new String[10];

        try{
            DBConnection ToDB = new DBConnection(); //Have a connection to the DB
            Connection DBConn = ToDB.openConn();
            Statement Stmt = DBConn.createStatement();
            String SQL_command;
            SQL_command = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CustomerID = '"+ UName +"' ";

            ResultSet Rst = Stmt.executeQuery(SQL_command);

            int count = 0;
            while (Rst.next()){
                if(count < 10){
                    String result = Rst.getString(1);
                    System.out.println(result);
                    checkingAccountNumbers[count] = result;
                }
                count ++;
            }

            Stmt.close();
            DBConn.close();
        }
        catch(java.sql.SQLException e){
            System.out.println("SQLException: " + e);
            while (e != null)
            {   System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
            e.printStackTrace ();
        }

        return checkingAccountNumbers;

    }

    public String[] getSavingAccountNumbers(String UName){

        String[] savingAccountNumbers = new String[10];

        try{
            DBConnection ToDB = new DBConnection(); //Have a connection to the DB
            Connection DBConn = ToDB.openConn();
            Statement Stmt = DBConn.createStatement();
            String SQL_command;
            SQL_command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerID = '"+UName +"' ";
            ResultSet Rst = Stmt.executeQuery(SQL_command);
            int count = 0;
            while (Rst.next()){
              if(count < 10){
                  String result = Rst.getString(1);
                  System.out.println(result);
                  savingAccountNumbers[count] = result;
              }
                count ++;
            }
            Stmt.close();
            DBConn.close();
        }
        catch(java.sql.SQLException e){
            System.out.println("SQLException: " + e);
            while (e != null)
            {   System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
            e.printStackTrace ();
        }

        return savingAccountNumbers;
    }
}