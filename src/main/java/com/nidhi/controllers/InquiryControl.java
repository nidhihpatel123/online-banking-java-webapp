package com.nidhi.controllers;


import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class InquiryControl {

    public String startDate;
    public String endDate;
    public String TransactionDate;


    public InquiryControl(String s,String e) {
     startDate = s;
     endDate = e;
     }

     public ArrayList<Vector> searchTransction(){
        ArrayList<Vector> arrayList = new ArrayList<Vector>();

        try {
        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
        Connection DBConn = ToDB.openConn();
        Statement Stmt = DBConn.createStatement();
        String SQL_command;
        SQL_command= "SELECT TransactionNumber,TransactionDate,TransactionAmount,TransactionType,FromAccount,ToAccount FROM Transactions WHERE TransactionDate >= '"+ startDate +"' AND TransactionDate <='"+endDate+"'";
        System.out.println(SQL_command);
        ResultSet result = Stmt.executeQuery(SQL_command);

        while (result.next()){
            String number = result.getString(1);
            String date = result.getString(2);
            Float Balance = result.getFloat(3);
            String type =result.getString(4);
            String fromAcc =result.getString(5);
            String toAcc = result.getString(6);

            Vector v2 = new Vector();
            v2.add(number);
            v2.add(date);
            v2.add(Balance);
            v2.add(type);
            v2.add(fromAcc);
            v2.add(toAcc);
            arrayList.add(v2);

        }

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
      return arrayList;
     }

}
