<%@ page import="org.omg.CORBA.Request" %>
<%@ page import="javax.swing.*" %>
<%@ page import="com.nidhi.entities.CheckingAccount" %>
<%@ page import="com.nidhi.entities.Transaction" %>
<%@ page import="com.nidhi.entities.SavingsAccount" %><%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String depositToAcc = request.getParameter("toAccount");
String AccType = depositToAcc.substring(0,8);
String balance = request.getParameter("AmountField");
String uname= request.getParameter("userName");
String customerName = request.getParameter("CustomerName");
String depositStatus= "";
System.out.println(depositToAcc);
System.out.println(AccType);



        if (depositToAcc.equals("Select Account")) {
           depositStatus = "Please choose Account type!";
        }
        else if (AccType.equals("Checking")) {
            String AccountNumber = depositToAcc.substring(11,19);
            CheckingAccount checkingAdd = new CheckingAccount(AccountNumber, customerName, uname, balance);
            Boolean resultdonecheck = checkingAdd.deposit();

            if (resultdonecheck) {
                depositStatus = "Successfully Deposit!";
                Transaction transct = new Transaction(balance,"deposit", null ,AccountNumber,uname);
                transct.record();

            } else {
                depositStatus = "UnSuccessfully Deposit!";
            }
        } else if (AccType.equals("Savings ")) {
            String AccountNumber = depositToAcc.substring(10,18);
            SavingsAccount sav = new SavingsAccount(AccountNumber, customerName, uname, "0.0", balance);
            Boolean resultdoneSav = sav.deposit();
            if (resultdoneSav) {
                depositStatus =  "Successfully Deposit!";
                Transaction transct = new Transaction(balance,"deposit", null ,AccountNumber,uname);
                transct.record();
            } else {
                depositStatus= "UnSuccessfully Deposit!";

            }
        }
%>




<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=depositStatus%></h1>
</body>
</html>
