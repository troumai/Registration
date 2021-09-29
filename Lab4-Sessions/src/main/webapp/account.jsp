<%@ page import="com.example.entities.User" %>
<%@ page import="com.example.entities.TripleDes" %><%--
  Created by IntelliJ IDEA.
  User: troum
  Date: 21.09.2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<style>
    body{
        background: rgb(215,146,155);
        background: linear-gradient(90deg, rgba(215,146,155,1) 0%, rgba(131,149,180,1) 100%);
        font-family: 'Josefin Sans', sans-serif;
    }
    .register-box{
        max-width: 500px;
        margin: 0 auto;
        margin-top: 170px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        text-align: center;
        background-color: white;
        border-radius: 10px;
        padding-bottom: 50px;
    }
    h1{
        padding-top: 40px;
        font-family: 'Josefin Sans', sans-serif;
        color: #d7929b;
        font-weight: bold;
        text-transform: uppercase;
    }
    h2{
        color: gray;
    }
    .buttons{
        display: flex;
        justify-content: space-evenly;
        width: 100%;
    }
    .submit-btn{
        margin-top: 15px;
        border-radius: 15px;
        background-color: #d7929b;
        font-family: 'Josefin Sans', sans-serif;
        font-size: 20px;
        color: white;
        height: 45px;
        width: 150px;
        border: 2px solid transparent;
        text-transform: uppercase;
    }
</style>

<%
    User user = (User) session.getAttribute("userSession");
    TripleDes td = new TripleDes();
%>

<div class="register-box">
    <h1>Profile</h1>
    <h2>Name: <%=td.decrypt(user.getName())%> </h2>
    <h2>Surname: <%=td.decrypt(user.getSurname())%></h2>
    <h2>Group: <%=td.decrypt(user.getGroup())%></h2>
    <h2>Email: <%=td.decrypt(user.getEmail())%></h2>
    <div class="buttons">
        <form action="<%=request.getContextPath()%>/logout" method="post">
            <input type="submit" value="Log out" class="submit-btn">
        </form>
    </div>
</div>
</body>
</html>
