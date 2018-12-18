<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/css/comman.css" rel="stylesheet" type="text/css">
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.nidhi.controllers.*" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="com.nidhi.entities.SavingsAccount" %>

<!--
/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/
-->
<%
    String uname = "";
    uname = request.getParameter("userName");
    String CustomerName ="";
    CustomerName = request.getParameter("CustomerName");
    TablePanelControl tbPanel = new TablePanelControl(uname);
    String[] SavingaccNumbers =  tbPanel.getSavingaccountNu(uname);
    request.setAttribute("SavingAccNumbers",SavingaccNumbers);
    String[] CheckingaccNumbers = tbPanel.getCheckingAccountNu(uname);
    request.setAttribute("CheckingaccNumbers",CheckingaccNumbers);

%>

<HTML><HEAD></HEAD>
<BODY background="/images/bg15.jpg">
<FORM NAME="TransferForm" ACTION="jsp/Deposit.jsp" METHOD ="POST" >
    <INPUT TYPE='hidden' NAME='CustomerName' VALUE=<%=CustomerName%>>
    <INPUT TYPE='hidden' NAME='userName' VALUE=<%=uname%>>

    <TABLE cellPadding=3 ALIGN='center'>


        <TR bgcolor='#ECFAEB'>
            <TD class="StyleLabel">Deposit To Account:</TD>
            <TD>
                <select class="Styledrop" NAME="toAccount">
                    <option selected value="Select To Account"> Select To Account</option>
                    <c:forEach var="line" items="${SavingAccNumbers}">
                        <c:if test="${line != null || 'null'}">
                            <option name="Saving" value="Savings - ${line}"> ****${line.substring(4,8)} - Savings</option>
                        </c:if>

                    </c:forEach>
                    <c:forEach var="obj" items="${CheckingaccNumbers}">
                        <c:if test="${obj != null || 'null'}">
                            <option name="checking" value="Checking - ${obj}"> ****${obj.substring(4,8)} - Checking</option>
                        </c:if>
                    </c:forEach>
                </select>
            </TD>
        </TR>
        <TR bgcolor='#F1F1FD'>
            <TD class="StyleLabel">Amount to Deposit:</TD>
            <TD>
                <INPUT class="StyleText" TYPE='text' NAME='AmountField' Value='' SIZE='15'>
            </TD>
        </TR>
    </TABLE><BR>

    <CENTER><input class="StyleBtn" type="submit" value="Deposit"/></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE='JavaScript'>
</SCRIPT>