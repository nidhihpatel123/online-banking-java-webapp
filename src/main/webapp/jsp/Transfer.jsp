<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/24/18
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.nidhi.controllers.*" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="com.nidhi.entities.*" %>

<%
    String toAcc = request.getParameter("toAccount");
    String fromAcc = request.getParameter("fromAccount");
    String UserID = request.getParameter("userName");
    String CustomerName = request.getParameter("CustomerName");
    String balance = request.getParameter("AmountField");
    String  Acctype = request.getParameter("line");


    System.out.println(balance);
    System.out.println(UserID);
    System.out.println(CustomerName);
    System.out.println(toAcc);
    System.out.println(fromAcc);

    TransferControl transfercheck = new TransferControl(toAcc,fromAcc,UserID,CustomerName,balance);

%>
<%

%>



<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>User Name is</h1>
<h1><%=CustomerName%></h1>
</body>
</html>
