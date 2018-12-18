<%@ page import="javax.swing.*" %>
<link href="/css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="com.nidhi.entities.CheckingAccount" %>
<%@ page import="com.nidhi.entities.Transaction" %>
<%@ page import="com.nidhi.entities.SavingsAccount" %>
<%@ page import="com.nidhi.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String uname = request.getParameter("userName");
String customerName = request.getParameter("CustomerName");
String withdrawFromAcc = request.getParameter("fromAccount");
String AccType = withdrawFromAcc.substring(0,8);
String balance = request.getParameter("AmountField");
String WithdrawStatus = "";
    System.out.println(uname);
    System.out.println(customerName);
    System.out.println(withdrawFromAcc);
    System.out.println(AccType);
    System.out.println(balance);


    if (AccType.equals("Select Account")) {
        WithdrawStatus = "Please choose Account type!";
    }
     else if (AccType.equals("Checking")) {
        String AccountNumber = withdrawFromAcc.substring(11,19);
        CheckingAccount checkingAdd = new CheckingAccount(AccountNumber, customerName, uname, balance);
        Boolean resultdonecheck2 = checkingAdd.Withdraw();

        if (resultdonecheck2) {
            WithdrawStatus = "Successfully Withdraw!";
            Transaction transct = new Transaction(balance,"Withdraw", AccountNumber,null,uname);
            transct.record();
        } else {
            WithdrawStatus = "UnSuccessfully Withdraw!";
        }
    } else if (AccType.equals("Savings ")) {
        String AccountNumber = withdrawFromAcc.substring(10,18);
        SavingsAccount sav = new SavingsAccount(AccountNumber, customerName, uname, "0.0", balance);
        Boolean resultdoneSav2 = sav.withdraw();
        if (resultdoneSav2) {
            WithdrawStatus =  "Successfully Withdraw!";
            Transaction transct = new Transaction(balance,"Withdraw", AccountNumber ,null,uname);
            transct.record();
        } else {
            WithdrawStatus= "UnSuccessfully Withdraw!";

        }


    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body background="../images/bg15.jpg">
<h1 class="msgresult"><%=WithdrawStatus%></h1>
</body>
</html>
