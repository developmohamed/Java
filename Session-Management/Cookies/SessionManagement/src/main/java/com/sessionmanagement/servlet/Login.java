/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionmanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohamed
 */
@WebServlet("/loginServlet")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Calllllllllllllllll");

        String userName = "mohamed";
        String password = "123";

        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        if (user.equals(userName) && pass.equals(password)) {

            Cookie loginCookie = new Cookie("user", user);

            loginCookie.setMaxAge(40);

            response.addCookie(loginCookie);

            response.sendRedirect("index.jsp");

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");

            PrintWriter pr = response.getWriter();
            pr.write("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);

        }

    }

}
