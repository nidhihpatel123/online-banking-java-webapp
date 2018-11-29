package com.nidhi.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {

        doPost(req, res);
    }

    public void doPost (HttpServletRequest req, HttpServletResponse res )
            throws ServletException, IOException
    {

        req.getRequestDispatcher("/jsp/Withdraw.jsp").forward(req, res);
    }
}
