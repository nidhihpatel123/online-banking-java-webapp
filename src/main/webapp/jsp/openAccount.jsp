<%@ page import="com.nidhi.controllers.OpenBankAccountControl" %>
<%@ page import="com.nidhi.entities.CheckingAccount" %>
<%@ page import="com.nidhi.entities.Transaction" %>
<%@ page import="javax.swing.*" %>
<link href="/css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="com.nidhi.entities.SavingsAccount" %><%--
<lin
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String accountType = request.getParameter("selectAccountType");
    String username = request.getParameter("username");
    String customer = request.getParameter("customer");
    String accnum = request.getParameter("accnum");
    String depositAmount = request.getParameter("depositAmount");
    String  InterestRate = "0.0";
    String msg ="";

    System.out.println(accountType);
    System.out.println(username);
    System.out.println(customer);
    System.out.println(accnum);
    System.out.println(depositAmount);

    if (accountType.equals("Checking")) {
        CheckingAccount CA = new CheckingAccount(accnum, customer, username, depositAmount);
        if (CA.openAcct()) {
           msg = "Successfully Account created";
            System.out.println(msg);
            Transaction ts = new Transaction(depositAmount, "Deposit", "Checking", null, username);
            ts.record();

        } else {
            msg = "Account creation fail!";
            System.out.println("fail!");

        }
    }
    if (accountType.equals("Savings")) {
        SavingsAccount SA = new SavingsAccount(accnum, customer, username,InterestRate, depositAmount);
        if (SA.openSavAcct()) {
            System.out.println("successful!");
            msg = "Successfully Account created";
            Transaction ts = new Transaction(depositAmount, "Deposit", "Savings", null, username);
            ts.record();

        } else {
            msg = "Account creation fail!";
            System.out.println("fail!");

        }
    }

%>

<html>
<head>
    <title>Title</title>
</head>
<body background="../images/bg15.jpg">
<h1><%=msg%></h1>
</body>
</html>
