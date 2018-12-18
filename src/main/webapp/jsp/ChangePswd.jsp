<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 12/8/18
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nidhi.entities.*" %>
<%
String uname = "";
String pswd = "";
String new_pswd ="";
uname = request.getParameter("username");
pswd = request.getParameter("pswd");
new_pswd = request.getParameter("new_pswd");
    System.out.println(uname);
    System.out.println(new_pswd);
String status= "";

Account acc = new Account(uname, pswd, new_pswd);
    System.out.println(acc);
acc.changepswd();
    System.out.println(acc.changepswd());
if(acc.changepswd()){
    status= "Password successfully changed";
}
else {
    status= "try Again!";
}

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=status%></h1>
</body>
</html>
