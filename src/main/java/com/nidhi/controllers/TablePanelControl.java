package com.nidhi.controllers;

import com.nidhi.boundries.TablePanel;
import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class TablePanelControl {

    private TablePanel tab;
    private String uName;

    public TablePanelControl(String UName) {
        uName = UName;
    }

    public ArrayList<Vector> getInformation() {

        ArrayList<Vector> arr = new ArrayList<Vector>();


        try {

            DBConnection dbconn = new DBConnection();
            Connection conn = dbconn.openConn();
            Statement stat = conn.createStatement();

            String SQL_command = "SELECT CheckingAccountNumber, Balance FROM CheckingAccount WHERE CustomerID = '" + uName + "' ";
            ResultSet result = stat.executeQuery(SQL_command);
            while (result.next()) {
                String checkingAccountNUmber = result.getString(1);
                float Balance = result.getFloat(2);
                Vector v = new Vector();
                v.add(0,"Checking");
                v.add(1, checkingAccountNUmber);
                v.add(2, Balance);
                arr.add(v);
            }

            String SQL_Command2 = "SELECT SavingsAccountNumber, Balance FROM SavingsAccount WHERE CustomerID = '" + uName + "'";
            ResultSet result2 = stat.executeQuery(SQL_Command2);
            while(result2.next()){

                String savingsAccountNumber = result2.getString(1);
                float Balance = result2.getFloat(2);
                 Vector v2 = new Vector();
                 v2.add(0,"Savings");
                 v2.add(1, savingsAccountNumber);
                 v2.add(Balance);
                 arr.add(v2);

            }


        } catch (java.sql.SQLException e) {
            System.out.println("SQLException: " + e);
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }


        return arr;
    }

    public String[] getSavingaccountNu(String UName) {

        String[] Savingsnumbers = new String[10];

        try {

            DBConnection dbconn = new DBConnection();
            Connection conn = dbconn.openConn();
            Statement stat = conn.createStatement();

            String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerID = '" + UName + "'";
            ResultSet result = stat.executeQuery(SQL_Command);

            int count = 0;
            while (result.next()) {

                if(count <10) {
                    String myresult = result.getString(1);
                    Savingsnumbers[count] = myresult;
                    count++;
                }
            }


        }
    catch (java.sql.SQLException e) {
            System.out.println("SQLException: " + e);
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }
    catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }


    return Savingsnumbers;
    }


    public String[] getCheckingAccountNu(String UName){
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
}
