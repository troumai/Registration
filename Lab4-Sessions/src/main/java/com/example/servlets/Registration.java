package com.example.servlets;

import com.example.entities.TripleDes;
import com.example.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="Registration", value = "/register")
public class Registration extends HttpServlet {

    User newUser = new User();

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TripleDes td = new TripleDes();
            resp.setContentType("text/html");
            newUser.setName(td.encrypt(req.getParameter("fname")));
            newUser.setSurname(td.encrypt(req.getParameter("lname")));
            newUser.setEmail(td.encrypt(req.getParameter("emailId")));
            newUser.setGroup(td.encrypt(req.getParameter("group")));
            newUser.setPassword(td.encrypt(req.getParameter("password")));
            this.doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cookie userLogin =  new Cookie("login", newUser.getEmail());
        Cookie userPassword = new Cookie("password", newUser.getPassword());

        userPassword.setMaxAge(60*1);
        userLogin.setMaxAge(60*1);

        session.setAttribute("userSession", newUser);

        resp.addCookie(userLogin);
        resp.addCookie(userPassword);

        resp.sendRedirect("account.jsp");
    }

    @Override
    public void destroy() {

    }
}
