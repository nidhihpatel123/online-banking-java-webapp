<%@ page import="com.nidhi.controllers.InquiryControl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String start = request.getParameter("startDate");
    String end = request.getParameter("endDate");

    InquiryControl createInquiry = new InquiryControl(start.replace("-","/"), end.replace("-","/"));
    ArrayList<Vector> info = createInquiry.searchTransction();
    int arraySize = info.size();
    Iterator<Vector> ite = info.iterator();

    Object[][] ComponentNames = new Object[arraySize][6];
    request.setAttribute("ComponentNames",ComponentNames);

    int rowNumber = 0;
    while (ite.hasNext()) {

        Vector result = ite.next();
        Object tnumber = result.get(0);
        Object tdate = result.get(1);
        Object tamount = result.get(2);
        Object ttype = result.get(3);
        Object faccount = result.get(4);
        Object taccount = result.get(5);


        ComponentNames[rowNumber][0] = tnumber;
        ComponentNames[rowNumber][1] = tamount;
        ComponentNames[rowNumber][2] = ttype;
        ComponentNames[rowNumber][3] = tdate;
        ComponentNames[rowNumber][4] = faccount;//"****" + ((String) faccount).substring(9, 8);
        ComponentNames[rowNumber][5] = taccount;//"****" + ((String) taccount).substring(4, 8);
        rowNumber = rowNumber + 1;


    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body background="../images/bg15.jpg">

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
<div class="scrollit">
    <table cellPadding=3 ALIGN='center' border="1px solid black">
        <tr>
            <th>Transaction Number</th>
            <th>Transaction Balance</th>
            <th>Transaction Type</th>
            <th>Transaction Date</th>
            <th>From Account</th>
            <th>To Account</th>
        </tr>
        <tr>
            <c:forEach var="line" items="${ComponentNames}">
        <tr>
            <td align="center">${line[0]}</td>
            <td align="center">${line[1]}</td>
            <td align="center">${line[2]}</td>
            <td align="center">${line[3]}</td>
            <td align="center">${line[4]}</td>
            <td align="center">${line[5]}</td>
        </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
