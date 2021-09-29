<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<style>
    body{
        background: rgb(215,146,155);
        background: linear-gradient(90deg, rgba(215,146,155,1) 0%, rgba(131,149,180,1) 100%);
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
    input{
        width: 275px;
        height: 45px;
        font-family: 'Josefin Sans', sans-serif;
        font-size: 20px;
        /*border: 1px solid #d7929b;*/

    }
    .submit-btn{
        border-radius: 15px;
        background-color: #d7929b;
        color: white;
        height: 50px;
        width: 200px;
        border: 2px solid transparent;
    }
</style>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies.length==1 || cookies.length==0){
        response.sendRedirect("registration.jsp");
        session.invalidate();
    }

%>
<div class="register-box">
    <h1> LOGIN </h1>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <input type="text" name="login" placeholder="Login">
        <br> <br>

        <input type="text" name="password" placeholder="Password">
        <br> <br>

        <input class="submit-btn" type="submit" value="login">
    </form>
</div>
</body>
</html>