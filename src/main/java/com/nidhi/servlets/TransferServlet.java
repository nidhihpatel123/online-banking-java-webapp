package com.nidhi.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {

        doPost(req, res);
    }

    //a method included in class HttpServlet to respond
    //to post requests from a client.
    public void doPost (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {

        req.getRequestDispatcher("/jsp/Transfer.jsp").forward(req, res);
    }
}
