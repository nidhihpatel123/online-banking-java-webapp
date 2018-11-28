package com.nidhi.servlets;

import com.nidhi.entities.Account;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private String Username, Password, CustomerName;
    private PrintWriter output;

    //a method called automatically to initialize the servlet
    public void init( ServletConfig config )
            throws ServletException

    {
        super.init( config );
        Username = new String("");
        Password = new String("");

    }

    //a method included in class HttpServlet to respond
    //to post requests from a client.
    public void doGet (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {
        System.out.println("Hello I am in DoGet");
        Username= req.getParameter("UserName");
        System.out.println(Username);
        doPost(req, res);
    }

    //a method included in class HttpServlet to respond
    //to post requests from a client.
    public void doPost (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {
        //obtains a character-based output stream that enables
        //text data to be sent to the client
        System.out.println("Hello I am in Do Post");
        output = res.getWriter();

        //specifies the MIME type of the response to the browser
        res.setContentType( "text/html" );

        //returns the value associated with a parameter sent to
        //the servlet as part of a post request
        Username = req.getParameter( "UserName" );
        Password = req.getParameter( "PassWord" );
        System.out.println(Username);
        System.out.println(Password);
        Account Acct = new Account(Username, Password);
        if (!Acct.signIn().equals("")) {

            CustomerName = Acct.signIn().toString();
            System.out.println(CustomerName);
            showSuccess();
        }
        else {
            output.println("Account creation failed because of existing username or invalid username. Please try again!");
        }
    };

    public void showSuccess()
    {
        StringBuffer Buf = new StringBuffer();
        Buf.append("<HTML><HEAD></HEAD>\n");
        Buf.append("<BODY bgcolor='#F1F1FD'>\n");
        Buf.append("<h4 ALIGN='center'>Congratulations! You have an account with us. Thank you! You can login now.</h4>\n");
        Buf.append("<FORM NAME=\"LoginPage\" ACTION=\"/LoginSrvlet\" METHOD =\"POST\">\n");

        Buf.append("<TABLE ALIGN='center'>\n");
        Buf.append("<TR>\n");
        Buf.append("<TD><button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px; text-decoration:none \"><a href=\"/app/Web/accountOverview.html\">Account Overview</a></button></TD>\n");
        Buf.append("<TD>\n");
        Buf.append("<button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px; text-decoration:none;\"><a href=\"/jsp/PreopenAccount.jsp\" TARGET='display'>Open Account</a></button>");
        Buf.append("</TD>\n");
        Buf.append("<TD>\n");
        Buf.append("<button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px; text-decoration: none\"><a href=\"/app/Web/withdraw.html\">Withdraw</a></button>");
        Buf.append("</TD>\n");
        Buf.append("<TD>\n");
        Buf.append("<button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px; text-decoration: none\"><a href=\"/app/Web/deposit.html\">Deposit</a></button>");
        Buf.append("</TD>\n");
        Buf.append("<TD>\n");
        Buf.append("<button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px;text-decoration: none\"><a href=\"/jsp/PreTransfer.jsp?userName=").append(Username).append("&CustomerName=").append(CustomerName).append("\" TARGET='display'>Transfer</a></button>");
        Buf.append("</TD>\n");
        Buf.append("<TD><button style=\"border: 1px solid black; height: 27px; width: 170px; font-size: 15px;text-decoration: none\"><a href=\"/app/Web/inquireTransaction.html\">Inquire Transaction</a></button></TD>\n");
        Buf.append("</TR>\n");
        Buf.append("</TABLE>\n");
        Buf.append("</FORM>\n");
        Buf.append("</BODY>\n");
        Buf.append("</HTML>\n");
        output.println(Buf.toString());
    }

    //this "cleanup" method is called when a servlet is terminated by the server
    public void destroy() {
        output.close();
    }
}