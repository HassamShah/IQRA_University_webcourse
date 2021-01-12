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


@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//connecting to DB and send data that is being collected form user...
        try {
            //following line will load and connect JDBC api to MYSQL databse
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/reg", "root", "mysql123");

    //data types and that are use to store data comming from client side.
    String email;
    String pass, re_password;
    email = request.getParameter("email");
    pass = request.getParameter("psw");
    re_password = request.getParameter("psw-repeat");
    String query_insertion_data;

    //following query will allow the the data to be sent to DB
    query_insertion_data = "insert into reg.registraton (email,password,recheck_password) VALUES (?,?,?)";
    PreparedStatement preparedStatement = con.prepareStatement(query_insertion_data);
    preparedStatement.setString(1, email);
    preparedStatement.setString(2, pass);
    preparedStatement.setString(3, re_password);
    preparedStatement.execute();
}
        //catching if any exception happen during the data sending and retrieving method
catch (Exception e)
{
    System.out.println(e);
}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
