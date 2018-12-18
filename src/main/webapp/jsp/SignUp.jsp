<!--
/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet *
*	Date: September, 2012						      *
*******************************************************************************/
-->

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.nidhi.entities.*" %>
<link href="../css/comman.css" rel="stylesheet" type="text/css">

<%
	String Username = new String("");
	String Password = new String("");
	String Re_enterPassword = new String("");
	String FullName = new String("");
	
	Username = request.getParameter( "UsernameField" );
	Password = request.getParameter( "PasswordField" );
        Re_enterPassword = request.getParameter( "RePasswordField" );
        FullName = request.getParameter( "NameField" );
              
        Account Acct = new Account(Username, Password, Re_enterPassword, FullName);
%>
<%
	if (!Acct.signUp())
            System.out.println("com.nidhi.entities.Account creation failed because of existing username or invalid username. Please try again!");
        else { 
%>

		<HTML><HEAD></HEAD>
		<BODY background="../images/bg15.jpg">
		<h4 ALIGN='center'>Congratulations! You have an account with us. Thank you! You can login now.</h4>
		</BODY>
		<SCRIPT LANGUAGE="JavaScript"> 
		function checkInputs()
		{
		var Prompts = "";
		Username = window.document.LoginPage.UserName.value;
		Password = window.document.LoginPage.PassWord.value;
		if (Username == "" || Password == "") {
		if (Username == "")
		Prompts +="Please enter your username!\n";
		if (Password == "")
		Prompts +="Please enter your password!\n";
		if (Prompts != "")
		window.alert(Prompts);
		} else {
		document.LoginPage.submit();
		}
		}
		</SCRIPT>
		</HTML>

<%		}
%>
 
