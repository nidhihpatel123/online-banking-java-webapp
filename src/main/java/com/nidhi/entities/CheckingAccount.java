package com.nidhi.entities; /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: October, 2013													      *
*******************************************************************************/


import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CheckingAccount
{   //Instance Variables
	private String CheckingAccountNumber, CustomerName, CustomerID;
	private float Balance = -1;

	public CheckingAccount(String CA_Num, String Cust_Name, String Cust_ID, String Bal) { //Constructor One with three parameters
		CheckingAccountNumber = CA_Num;
		CustomerName = Cust_Name;
		CustomerID = Cust_ID;
		Balance = Float.parseFloat(Bal);
	}

	public CheckingAccount(String CA_Num) { //Constructor Two with one parameter
		CheckingAccountNumber = CA_Num;
	}

    public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
                        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+CheckingAccountNumber+"','"+CustomerName+"',"+Balance+", '"+CustomerID+"')"; //Save the username, password and Name
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
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command for Balance
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

    public float getBalance(String ChkAcctNumber) {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+ChkAcctNumber+"'"; //SQL query command for Balance
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

		boolean done= !CheckingAccountNumber.equals("") && !CustomerID.equals("") && !(Balance == 0);

		try{
			if(done){
				DBConnection DBconn = new DBConnection();
				Connection conn = DBconn.openConn();
				Statement stat = conn.createStatement();
				String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber = '"+CheckingAccountNumber+"' AND CustomerID ='"+CustomerID+"'";
				System.out.println(SQL_Command);
				ResultSet reslt = stat.executeQuery(SQL_Command);

				if (reslt.next()){
					Float Existing_balance = reslt.getFloat(1);
					System.out.println("Checking Account Existing Balance was"+ "" + Existing_balance);
					Balance = Existing_balance + Balance;
					SQL_Command = "UPDATE CheckingAccount SET Balance = '" + Balance + "' WHERE CheckingAccountNumber = '"+CheckingAccountNumber+"'";
					System.out.println("Checking Account New Balance is"+ "" + Balance);
					System.out.println(SQL_Command);
					stat.executeUpdate(SQL_Command);
					stat.close();
					DBconn.closeConn();


				}


			}

		}
		catch (SQLException e){
			System.out.println("SQLException" + e);
			done= false;
			System.out.println("SQLExceptionState" + e.getSQLState());
			System.out.println("message" + e.getMessage());
			System.out.println("vendor" + e.getErrorCode());
			e.getNextException();
			System.out.println("");
		}

		catch (Exception e){

			System.out.println("Exception" + e);
			e.printStackTrace();
		}

		return done;
	}

	public boolean Withdraw(){

		boolean done = !CheckingAccountNumber.equals("") && !CustomerID.equals("") && !(Balance == 0);

		try{
			if(done){
				DBConnection DBconn = new DBConnection();
				Connection Conn = DBconn.openConn();
				Statement Stat = Conn.createStatement();

				String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber = '"+CheckingAccountNumber+"' AND CustomerID= '"+CustomerID+"' ";
				System.out.println(SQL_Command);
				ResultSet rslt = Stat.executeQuery(SQL_Command);
				if(rslt.next()){
					Float Existing_Balance = rslt.getFloat(1);
					System.out.println("Checking Account Existing Balance was"+ + Existing_Balance);
					if(Balance > Existing_Balance){
						done = false;
					}
					else{
						Balance= Existing_Balance - Balance;
						SQL_Command = "UPDATE CheckingAccount SET Balance = '"+Balance+"' WHERE  CheckingAccountNumber = '"+CheckingAccountNumber+"'";
						System.out.println("Checking Account New Balance is"+ + Existing_Balance);
						System.out.println(SQL_Command);
						Stat.executeUpdate(SQL_Command);
					}


					Stat.close();
					DBconn.closeConn();

				}

			}
		}
		catch (SQLException e){
			done = false;
			System.out.println("SQLException" + e);
			while (e != null){
				System.out.println("SqlExceptionState" + e.getSQLState());
				System.out.println("Message"+ e.getMessage());
				System.out.println("Vendor"+ e.getErrorCode());

				e = e.getNextException();
				System.out.println("");

			}
		}
		catch (Exception e){
			done = false;
			System.out.println("Exception" + e);

			e.printStackTrace();

		}
	       return done;
	}

}