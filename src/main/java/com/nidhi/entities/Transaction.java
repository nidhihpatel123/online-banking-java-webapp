package com.nidhi.entities;

import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {

     private String TransactionNumber, TransactionType, TransactionTime, TransactionDate, FromAccount, ToAccount, CustomerID;
     private  float TransactionAmount= 1;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


     public Transaction ( String T_amount, String T_type,String T_Form_Acc, String T_To_Account,String T_CustID ){

         TransactionAmount = Float.parseFloat(T_amount);
         TransactionType= T_type;
         FromAccount= T_Form_Acc;
         ToAccount= T_To_Account;
         CustomerID= T_CustID;

     }

     public void record () {
         TransactionNumber = String.valueOf((int) (Math.random() * (999999 - 111111)) + 111111);
         Calendar cal = Calendar.getInstance();
         String FullDate = sdf.format(cal.getTime());
         TransactionDate = FullDate.substring(0,10);
         TransactionTime = FullDate.substring(11,19);
         boolean done = false;
         try{
             if (!done) {
                 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
                 Connection DBConn = ToDB.openConn();
                 Statement Stmt = DBConn.createStatement();
                 String SQL_command;
                 SQL_command = "SELECT TransactionNumber FROM Transactions WHERE TransactionNumber = '"+TransactionNumber+"' ";
                 ResultSet Rst = Stmt.executeQuery(SQL_command);
                 done= !Rst.next();
                 if(done){

                     SQL_command = "INSERT INTO " +
                             "Transactions(" +
                             "TransactionNumber," +
                             "TransactionAmount," +
                             "TransactionType," +
                             "TransactionDate," +
                             "TransactionTime," +
                             "ToAccount," +
                             "FromAccount," +
                             "CustomerID) " +
                             "VALUES('" + TransactionNumber + "','"
                             + TransactionAmount + "','"
                             + TransactionType + "','"
                             + TransactionDate + "','"
                             + TransactionTime + "','"
                             + ToAccount + "','"
                             + FromAccount + "','"
                             + CustomerID+"')";
//                     SQL_command = "INSERT " +
//                             "INTO " +
//                             "Transactions " +
//                             "(TransactionNumber," +
//                             "TransactionAmount," +
//                             "TransactionType," +
//                             "TransactionDate," +
//                             "TransactionTime," +
//                             "ToAccount," +
//                             "CustomerID )" + " " +
//                             "VALUES ( " +
//                             TransactionNumber + ","
//                             +TransactionAmount+","+"+" +
//                             "TransactionType+"+
//                             TransactionDate +
//                             TransactionTime + " +
//                             "+ToAccount+"+ "+CustomerID+")";
                     System.out.println(SQL_command);
                     Stmt.executeUpdate(SQL_command);
                 }
                 Stmt.close();
                 DBConn.close();
             }

         }
         catch(SQLException e)
         {         done = false;
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
         {         done = false;
             System.out.println("Exception: " + e);
             e.printStackTrace ();
         }
     }

//     public boolean searchTransction (TransactionNumber) {
//
//         boolean done = !TransactionNumber.equals("");
//
//         DBConnection ToDB = new DBConnection(); //Have a connection to the DB
//         Connection DBConn = ToDB.openConn();
//         Statement Stmt = DBConn.createStatement();
//         String SQL_command;
//         SQL_command = "SELECT TransactionNumber FROM Transactions WHERE TransactionNumber = '"+TransactionNumber+"' ";
//         ResultSet Rst = Stmt.executeQuery(SQL_command);
//         done= Rst.next();
//         if(done){
//
//             SQL_command = "SELECT TransactionNumber, ToAccount, FromAccount FROM Transactions WHERE TransactionNumber = '"+TransactionNumber+"' ";
//             ResultSet rst = Stmt.executeQuery(SQL_command);
//
//         }
//
//     }


    }

