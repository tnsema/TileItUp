<%--
    Document   : Start
    Created on : 04 Mar 2024, 9:18:30 AM
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.co.semat.TileItUp.Model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <%
        List<Customer> list = (List<Customer>)session.getAttribute("list");

        for(Customer c: list){

        String name = c.getName();


    %>

        <p><%=name%></p>

    <%
        }
    %>



        <h1>Hi, my name is </h1>

        <a href="/faci">click</a>

        <form action="BettingServlet.do" method="post">

        <table>
            <tr><td>Name:</td> <td><input type="text" name="username"></td></tr>
            <tr><td>Betting Amount: </td> <td>R<input type="text" name="betAmount"></td></tr>
            <tr><td>'s score:</td> <td><input type="text" name="team1PredictedScore"></td></tr>
            <tr><td>'s score:</td> <td><input type="text" name="team2PredictedScore"></td></tr>
            <tr> <td><input type="submit" value="BET"></td></tr>
        </table>

        </form>

    </body>
</html>
