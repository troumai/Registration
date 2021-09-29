package com.example.servlets;

import com.example.entities.TripleDes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private String login;
    private String pwd;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TripleDes td = new TripleDes();

            login = td.encrypt(req.getParameter("login"));
            pwd = td.encrypt(req.getParameter("password"));

            HttpSession session = req.getSession(false);
            Cookie[] cookies = req.getCookies();
            if(cookies.length==1){
                session.invalidate();
                resp.sendRedirect("index.jsp");
            }
            if(cookies[1].getValue().equals(login) && cookies[2].getValue().equals(pwd)){
                resp.sendRedirect("account.jsp");
            }
            else resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
