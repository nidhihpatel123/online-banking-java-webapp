<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 11/28/18
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/comman.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Title</title>
</head>
<BODY background="/images/bg15.jpg">
<FORM NAME="TransferForm" ACTION="/openAccountServlet" METHOD ="POST" >
<table TABLE cellPadding=3 ALIGN='center' id="openAccountTable">
    <tr>
        <td style="padding-bottom: 20px;">
        <select class="Styledrop" NAME="selectAccountType">
            <option selected value="Select Account type"> Select Account Type</option>
            <option name="savings">Savings</option>
            <option name="checking">Checking</option>
        </select>
            <br>
        </td>
    </tr>

    <TR bgcolor='#F1F1FD'>
    <TD class="StyleLabel">Username:</TD>
    <TD>
        <INPUT class="StyleText" TYPE='text' NAME='username' Value='' SIZE='15'>
    </TD>
</TR><br>
    <TR bgcolor='#F1F1FD'>
        <TD class="StyleLabel">Customer Name:</TD>
        <TD>
            <INPUT class="StyleText" TYPE='text' NAME='customer' Value='' SIZE='15'>

            <br>
        </TD>
    </TR>
    <TR bgcolor='#F1F1FD'>
        <TD class="StyleLabel">Account Number:</TD>
        <TD>
            <INPUT class="StyleText" TYPE='number' NAME='accnum' Value='' SIZE='15'>
        </TD>
    </TR><br>
    <TR bgcolor='#F1F1FD'>
        <TD class="StyleLabel">Opening Deposit:</TD>
        <TD>
            <INPUT class="StyleText" TYPE='number' NAME='depositAmount' Value='' SIZE='15'>
        </TD>
    </TR>
</table>
<br>
    <CENTER><input class="StyleBtn" type="submit" value="Open Account"/></CENTER>

</FORM>
</body>
</html>
