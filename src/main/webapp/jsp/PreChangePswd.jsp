<%--
  Created by IntelliJ IDEA.
  User: nidhipatel
  Date: 12/12/18
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String username= "";
    username = request.getParameter("User");
String password = "";
    password = request.getParameter("Pass");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form name="changepswd" action="/jsp/ChangePswd.jsp" method="get">
    <input type="hidden" value=<%=username%> name="username">
    <table >
        <tr>
            <td>
                <label name="pswdlabel"> Existing-Password: </label>
                <input type="text" name="pswd" value=<%=password%>>
            </td>
        </tr>
        <tr>
            <td>
                <label name="new_pswdlabel"> New-Enter Password:</label>
                <input type="text" name="new_pswd">
            </td>
        </tr>
        <tr>
            <td>
                <label name="re_new_pswdlabel"> Re-Enter Password:</label>
                <input type="text" name="rechack_pswd">
            </td>
        </tr>

        <tr>
            <input type="button" VALUE="Change Password" style="border: 1px solid black; height: 27px; width: 150px;color: grey; font-size: 15px" ONCLICK="checkform()">
        </tr>
    </table>
</form>
</body>

<script language="JavaScript">
    document.changepswd.username.focus();
    function  checkform() {
        var prompt = "";
        pswd = window.document.changepswd.pswd.value;
        newpswd = window.document.changepswd.new_pswd.value;
        repswd = window.document.changepswd.rechack_pswd.value;

        if(pswd == "" || newpswd == "" || repswd == ""){

            if(pswd == ""){
                prompt+= "Enter password \n";
            }
            if(newpswd == "" ){
                prompt+= "Enter the new password! \n";
            }
            if(repswd == "" ){
                prompt+= "Re-Enter new password again! \n";
            }
            if(newpswd.length <= 3){
                prompt+= "password should hav atleast 4 digit! \n"
            }
            if(prompt != ""){
                window.alert(prompt);
            }
        } else if( newpswd != repswd){
            window.alert("Password should be match");
        } else {
            document.changepswd.submit();
        }
    }
</script>
</html>
