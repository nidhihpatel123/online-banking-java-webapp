package com.nidhi.entities;
/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import com.nidhi.utilities.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account
{
	private String Username, Password, Password1, Name;

	public Account(String UN, String PassW, String PassW1, String NM) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
	}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

	public Account(String UN, String PassW, String newPassW1){
	Username = UN;
	Password = PassW;
	Password1 =newPassW1;
}

	public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done == true) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				System.out.println(Rslt.next());
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name) VALUES ('"+Username+ "','"+Password+"','"+Name+"')"; //Save the username, password and Name
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

//	public boolean changePassword(String NewPassword) {	//5
//		boolean done = false;
//		try {		//20
//		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
//		        Connection DBConn = ToDB.openConn();
//		        Statement Stmt = DBConn.createStatement();
//		        String SQL_Command = "SELECT * FROM com.nidhi.entities.Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
//		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
//		        if (Rslt.next()) {
//				    SQL_Command = "UPDATE com.nidhi.entities.Account SET Password='"+NewPassword+"' WHERE Username ='"+Username+"'"; //Save the username, password and Name
//				    Stmt.executeUpdate(SQL_Command);
//			        Stmt.close();
//			        ToDB.closeConn();
//                    done=true;
//				}
//		}
//	    catch(java.sql.SQLException e)		//5
//	    {         done = false;
//				 System.out.println("SQLException: " + e);
//				 while (e != null)
//				 {   System.out.println("SQLState: " + e.getSQLState());
//					 System.out.println("Message: " + e.getMessage());
//					 System.out.println("Vendor: " + e.getErrorCode());
//					 e = e.getNextException();
//					 System.out.println("");
//				 }
//	    }
//	    catch (java.lang.Exception e)
//	    {         done = false;
//				 System.out.println("Exception: " + e);
//				 e.printStackTrace ();
//	    }
//	    return done;
//	}

	public boolean changePassword(){
		boolean done = !Username.equals("") && !Password.equals("");
		System.out.println(done);
		try {
			if(done){
				DBConnection DBcc = new DBConnection();
				Connection conn = DBcc.openConn();
				Statement stat = conn.createStatement();
				String Sql_Command = "SELECT Username,Password FROM Account WHERE Username = '"+Username+"'AND Password= '"+Password+"'";
				ResultSet Result= stat.executeQuery(Sql_Command);
				System.out.println(Result);
				boolean found = Result.next();
				System.out.println(found);
				if(found){
					Sql_Command= "UPDATE Account SET Password= '"+Password1+"' WHERE Username = '"+Username+"'";
					System.out.println(Sql_Command);
					stat.executeUpdate(Sql_Command);

				}

				stat.close();
				DBcc.closeConn();

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

	public String signIn() {
		boolean done = !Username.equals("") && !Password.equals("");
		String returnUserName = "";
		try {
			if(done) {
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command = "SELECT Name,Username FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
				System.out.println(SQL_Command);

				ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				Boolean isFound = Rslt.next();
				if (isFound) {
                  returnUserName = Rslt.getString(1);

				}
				else {
					returnUserName = "";
				}
				Stmt.close();
				ToDB.closeConn();
			}
		}
		catch(SQLException e)
		{         returnUserName = "";
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
		{        returnUserName = "";
			System.out.println("Exception: " + e);
			e.printStackTrace ();
		}

		return returnUserName;
	}
}