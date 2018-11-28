package com.nidhi.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/openAccountServlet")
public class openAccountServlet extends HttpServlet {

    public void doGet(HttpServletRequest Req, HttpServletResponse Res)
            throws ServletException, IOException{

        doPost(Req,Res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse Res)
            throws ServletException, IOException {

        req.getRequestDispatcher("jsp/openAccount.jsp");

    }
}
