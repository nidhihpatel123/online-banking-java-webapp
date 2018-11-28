package com.nidhi.entities; /******************************************************************************
 *	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
 *	Date: October, 2013													      *
 *******************************************************************************/


import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SavingsAccount
{   //Instance Variables
    private String SavingsAccountNumber, CustomerName, CustomerID;
    private float Balance;
    private float InterestRate = 20;

    public SavingsAccount(String SA_Num, String Cust_Name, String Cust_ID,String Inter_Rate, String Bal) { //Constructor One with three parameters
        SavingsAccountNumber= SA_Num;
        CustomerName = Cust_Name;
        InterestRate = Float.parseFloat(Inter_Rate);
        CustomerID = Cust_ID;
        Balance = Float.parseFloat(Bal);
    }

//    public  SavingsAccount(String Cust_ID){
//        CustomerID = Cust_ID;
//    }

   public SavingsAccount(String SA_Num) { SavingsAccountNumber = SA_Num; }



    public boolean openSavAcct() {
        boolean done = false;
        try {
            if (!done) {
                DBConnection ToDB = new DBConnection(); //Have a connection to the DB
                Connection DBConn = ToDB.openConn();
                Statement Stmt = DBConn.createStatement();
                String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
                ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
                done = !Rslt.next();
                if (done) {
                    SQL_Command = "INSERT INTO SavingsAccount(SavingsAccountNumber, CustomerName, Balance, InterestRate,CustomerID)"+
                            " VALUES ('"+SavingsAccountNumber+"','"+CustomerName+"',"+Balance+","+InterestRate+" ,'"+CustomerID+"')"; //Save the username, password and Name
                    System.out.println(SQL_Command);
                    Stmt.executeUpdate(SQL_Command);
                }
                Stmt.close();
                ToDB.closeConn();
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
        return done;
    }
    public float getBalance() {  //Method to return a CheckingAccount balance
        try {
            DBConnection ToDB = new DBConnection(); //Have a connection to the DB
            Connection DBConn = ToDB.openConn();
            Statement Stmt = DBConn.createStatement();
            String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command for Balance
            ResultSet Rslt = Stmt.executeQuery(SQL_Command);

            while (Rslt.next()) {
                Balance = Rslt.getFloat(1);
            }
            Stmt.close();
            ToDB.closeConn();
        }
        catch(SQLException e)
        {
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
        return Balance;
    }

    public float getBalance(String SAVAcctNumber) {  //Method to return a CheckingAccount balance
        try {
            DBConnection ToDB = new DBConnection(); //Have a connection to the DB
            Connection DBConn = ToDB.openConn();
            Statement Stmt = DBConn.createStatement();
            String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+ SAVAcctNumber+"'"; //SQL query command for Balance
            ResultSet Rslt = Stmt.executeQuery(SQL_Command);

            while (Rslt.next()) {
                Balance = Rslt.getFloat(1);
            }
            Stmt.close();
            ToDB.closeConn();
        }
        catch(SQLException e)
        {
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
        return Balance;
    }


    public boolean deposit(){

        boolean done= !SavingsAccountNumber.equals("") && !CustomerName.equals("") && !CustomerID.equals("") && !(Balance == 0);
        try{
            if(done){
                DBConnection Dbconn = new DBConnection();
                Connection conn = Dbconn.openConn();
                Statement stat = conn.createStatement();

                String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"' AND CustomerID = '"+CustomerID+"'";
                ResultSet Rest = stat.executeQuery(SQL_Command);
                if(Rest.next()){
                    Float Existing_Balance = Rest.getFloat(1);
                    Balance = Existing_Balance + Balance;
//                    float interestRate = 5;
//                    float newBalanceWithInterest = calculateIntersest(Balance,interestRate);
                    SQL_Command= "UPDATE SavingsAccount SET Balance = '"+Balance+"' WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"'";
                    stat.executeUpdate(SQL_Command);

                    conn.close();
                    Dbconn.closeConn();

                }


            }
        }

        catch (SQLException e){
            System.out.println("SQLException"+ e);
             while(e != null){
                 System.out.println("SQLExceptionState" + e.getSQLState());
                 System.out.println("message" + e.getMessage());
                 System.out.println("Vendor:" + e.getErrorCode());

                 e= e.getNextException();
                 System.out.println("");

                 }
        }

        catch(Exception e){

            System.out.println("Exception" + e);

            e.getStackTrace();

        }
      return done;
    }

    public boolean withdraw(){

        boolean done =  !SavingsAccountNumber.equals("") && !CustomerID.equals("") && !(Balance == 0);

        try{

            if(done){

                DBConnection dbcon = new DBConnection();
                Connection conn = dbcon.openConn();
                Statement stat = conn.createStatement();

                String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"'";
                ResultSet result= stat.executeQuery(SQL_Command);
                System.out.println(result);
                if(result.next()){
                    Float Existing_Balance = result.getFloat(1);
                    System.out.println("Saving Account Existing Balace Was " + Existing_Balance);
                    if(Balance > Existing_Balance){
                        done = false;
                    }
                    else {
                        Balance = Existing_Balance - Balance;
                        SQL_Command= "UPDATE SavingsAccount SET Balance = '"+Balance+"' WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"'";
                        System.out.println(SQL_Command);
                        System.out.println("Saving Account New Balance is "+ Balance);
                        stat.executeUpdate(SQL_Command);
                        done = true;
                    }

                    stat.close();
                    dbcon.closeConn();



                }




            }

        }
        catch (SQLException e){
            done = false;
            System.out.println("SQLException"+ e);
            while(e != null){
                System.out.println("SQLExceptionState" + e.getSQLState());
                System.out.println("message" + e.getMessage());
                System.out.println("Vendor:" + e.getErrorCode());

                e= e.getNextException();
                System.out.println("");

            }
        }

        catch(Exception e){
            done = false;
            System.out.println("Exception" + e);

            e.getStackTrace();

        }
        return done;
    }
    public float calculateInterest(String SavingsAccountNumber ){

        float interestRate = 20;

        try{

                DBConnection dbcon = new DBConnection();
                Connection conn = dbcon.openConn();
                Statement stat = conn.createStatement();
                String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"'";
                ResultSet result= stat.executeQuery(SQL_Command);
                System.out.println(result);
                if(result.next()){
                    float Existing_Balance = result.getFloat(1);
                    float interstValue = (InterestRate * Existing_Balance)/100;
                    Balance = Existing_Balance + interstValue;
                    SQL_Command = "UPDATE SavingsAccount SET Balance = '"+Balance+"' WHERE SavingsAccountNumber = '"+SavingsAccountNumber+"'";
                    int returnValue = stat.executeUpdate(SQL_Command);
                    if(returnValue == 1){
                        Transaction ts = new Transaction(Float.toString(interstValue),"Interest",SavingsAccountNumber,null,CustomerName);
                        ts.record();
                    }
                    stat.close();
                    dbcon.closeConn();


            }

        }
        catch (SQLException e){
            System.out.println("SQLException"+ e);
            while(e != null){
                System.out.println("SQLExceptionState" + e.getSQLState());
                System.out.println("message" + e.getMessage());
                System.out.println("Vendor:" + e.getErrorCode());

                e= e.getNextException();
                System.out.println("");


            }
        }

        catch(Exception e){

            System.out.println("Exception" + e);

            e.getStackTrace();


        }
        return interestRate;
    }

//    public float calculateIntersest(float balance, float interstRate){
//        float interest =  (balance * interstRate)/100;
//        float newBalance = balance + interest;
//        return newBalance;
//    }
}