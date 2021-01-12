package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "form1" )
public class form1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/reg","root","mysql123");
            String email;
            String pass, re_password;
            email = request.getParameter("email");
            pass = request.getParameter("psw");
            re_password = request.getParameter("psw-repeat");
            String query_insertion_data;
            query_insertion_data = "select from reg.registration where email = ";
            String cont ;
            query_insertion_data.concat(email);
            PreparedStatement preparedStatement = con.prepareStatement("cont");
            preparedStatement.execute();
            if (preparedStatement.execute() == true)
            {
                response.sendRedirect("index.html");
            }
            else {
                response.sendRedirect("login page.html");
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
