<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/comman.css" rel="stylesheet" type="text/css">
<%
    String uname = "";
    uname = request.getParameter("userName");
    String CustomerName ="";
    CustomerName = request.getParameter("CustomerName");

%>
<html>
<head>
    <title>Title</title>
</head>
<body background="/images/bg15.jpg">
<FORM NAME="InquiryTransactionForm" ACTION="/InquiryTransaction" METHOD ="POST" >
<table cellPadding=3 ALIGN='center'>
    <tr bgcolor='#F1F1FD'>
        <td><label class="StyleLabel" name="start">Start Date: </label></td>
        <td ><input class="StyleText" name="startDate" type="date"></td>
    </tr>
    <br>
    <tr bgcolor='#F1F1FD'>
        <td><label  class="StyleLabel" name="end">End Date: </label></td>
        <td ><input class="StyleText" name="endDate" type="date"></td><br>
    </tr>

</table>
<br>
<CENTER><input class="StyleBtn" type="submit" value="Search Transaction"></CENTER>
</FORM>
</body>
</html>
