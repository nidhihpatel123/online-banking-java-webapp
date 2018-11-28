package com.nidhi.servlets; /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import com.nidhi.entities.Account;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

   private String Username, Password, Re_enterPassword, CustomerName;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException

   {
   	  super.init( config );
      Username = new String("");
      Password = new String("");
      Re_enterPassword = new String("");
      CustomerName = new String("");

   }

   //a method included in class HttpServlet to respond
   //to post requests from a client.
   public void doGet (HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {
	   System.out.println("Hello I am in DoGet");
   	doPost(req, res);
   }

   //a method included in class HttpServlet to respond
   //to post requests from a client.
   public void doPost (HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {
	   req.getRequestDispatcher("/jsp/SignUp.jsp").forward(req, res);
   }

   public void showSuccess()
   {
        StringBuffer Buf = new StringBuffer();
		Buf.append("<HTML><HEAD></HEAD>\n");
		Buf.append("<BODY bgcolor='#F1F1FD'>\n");
		Buf.append("<h4 ALIGN='center'>Congratulations! You have an account with us. Thank you! You can login now.</h4>\n");
			Buf.append("<FORM NAME=\"LoginPage\" ACTION=\"/LoginSrvlet\" METHOD =\"POST\">\n");

			   Buf.append("<TABLE cellPadding='3' ALIGN='center'>\n");
					Buf.append("<TR bgcolor='#ECFAEB'>\n");
					   Buf.append("<TD>USERNAME:</TD>\n");
					  Buf.append("<TD>\n");
						  Buf.append("<INPUT TYPE='text' NAME='UserName' Value=\""+Username+"\" SIZE='15' focused>\n");
					  Buf.append("</TD>\n");
					Buf.append("</TR>\n");

					Buf.append("<TR bgcolor='#ECFAEB'>\n");
					  Buf.append("<TD>PASSWORD:</TD>\n");
					  Buf.append("<TD>\n");
						   Buf.append("<INPUT TYPE='password' NAME='PassWord' Value='' SIZE='15'>\n");
						   Buf.append("<INPUT TYPE='button' NAME='submitBTN' VALUE='Login' onClick=\"checkInputs()\">\n");
					  Buf.append("</TD>\n");
					Buf.append("</TR>\n");
				Buf.append("</TABLE>\n");

		   Buf.append("</FORM>\n");
		Buf.append("</BODY>\n");

		Buf.append("<SCRIPT LANGUAGE=\"JavaScript\">\n");
		   Buf.append("function checkInputs()\n");
		   Buf.append("{\n");
			   Buf.append("var Prompts = \"\";\n");
			   Buf.append("Username = window.document.LoginPage.UserName.value;\n");
			   Buf.append("Password = window.document.LoginPage.PassWord.value;\n");
			   Buf.append("if (Username == \"\" || Password == \"\") {\n");
				  Buf.append("if (Username == \"\")\n");
					 Buf.append("Prompts +=\"Please enter your username!\\n\";\n");
				  Buf.append("if (Password == \"\")\n");
					 Buf.append("Prompts +=\"Please enter your password!\\n\";\n");
				  Buf.append("if (Prompts != \"\")\n");
					 Buf.append("window.alert(Prompts);\n");
			   Buf.append("} else {\n");
				  Buf.append("document.LoginPage.submit();\n");
			   Buf.append("}\n");
		   Buf.append("}\n");

		Buf.append("</SCRIPT>\n");
		Buf.append("</HTML>\n");
		output.println(Buf.toString());
   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}