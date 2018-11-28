<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/24/18
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/comman.css" rel="stylesheet" type="text/css">
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
    String userName = request.getParameter("userName");
    String CustomerName = request.getParameter("CustomerName");
    String balance = request.getParameter("AmountField");
    String transferStatus = "";
    System.out.println(toAcc);
    System.out.println(fromAcc);

    TransferControl transfercheck = new TransferControl(toAcc,fromAcc,userName,CustomerName,balance);
   boolean resultFlag = transfercheck.transferLogic();
    if(resultFlag){
        transferStatus= "Successful Transfer!";
    }
    else {
        transferStatus= "Fail Transfer! Try again!";
    }

%>
<%

%>



<html>
<head>
    <title>Title</title>
</head>
<body background="../images/bg15.jpg">

<h1 class="msgresult"><%=transferStatus%></h1>
</body>
</html>
