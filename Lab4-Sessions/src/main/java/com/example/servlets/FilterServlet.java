package com.example.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "Registration", value = "/register")
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getParameter("fname").equals("") || servletRequest.getParameter("lname").equals("")
                || servletRequest.getParameter("group").equals("") || servletRequest.getParameter("emailId").equals("") || servletRequest.getParameter("password").equals("")){
            servletResponse.setContentType("text/html");
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<html><body>");
            writer.println("<h1> Error. You haven't filled all information</h1>" +
                    "<h1>Return back and fill</h1>");
            writer.println("<style>" +
                    "h1{color:red;}" +
                    "</style>");
            writer.println("</body></html>");
        }
        else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
