<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="com.nidhi.controllers.TablePanelControl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.swing.*" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("userName");

    TablePanelControl accoverview = new TablePanelControl(username);
    ArrayList<Vector> userInfo = accoverview.getInformation();
    Iterator<Vector> it = userInfo.iterator();
    int arraySize = userInfo.size();
    Object[] columnNames = {"AccountType", "AccountNumber", "Balance"};
    request.setAttribute("columnNames", columnNames);
    Object[][] ComponentNames = new Object[arraySize][3];
    request.setAttribute("ComponentNames",ComponentNames);

    int rowNumber = 0;
    while (it.hasNext()) {
        Vector info = it.next();
        Object actType = info.get(0);
        Object actNumber = (String) info.get(1);
        Object accBala = info.get(2);
        ComponentNames[rowNumber][0] = actType;
        ComponentNames[rowNumber][1] = "****" + ((String) actNumber).substring(4, 8);
        ComponentNames[rowNumber][2] = accBala;
        rowNumber = rowNumber + 1;
    }


%>
<html>
<head>
    <title>Title</title>
</head>
<body background="/images/bg15.jpg">
<h1 class="msgresult">Hello! <%=username%>,Here is Your Account Overview:</h1>
<table cellPadding=4 ALIGN='center' border="1px solid black">
    <tr>
        <th>Account Type</th>
        <th>Account Number</th>
        <th>Account Balance</th>
    </tr>
        <c:forEach var="line" items="${ComponentNames}">
    <tr>
        <td align="center">${line[0]}</td>
        <td align="center">${line[1]}</td>
        <td align="center">${line[2]}</td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
