<%-- 
    Document   : thanks.jsp
    Created on : Sep 4, 2024, 8:18:56 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Murach's Java Servlet and JSP</title>
        <link rel="stylesheet" href="style/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the imformation that you entered:</p>

        <label>Email:</label>
        <span>${user.email}</span> <br>
        <label>First Name:</label>
        <span>${user.firstName}</span> <br>
        <label>Last Name:</label>
        <span>${user.lastName}</span> <br>
        <label>Date of Birth:</label>
        <span>${user.birthDate}</span> <br>
        <label>How did i hear:</label>
        <span>${hear}</span> <br>
        <label>Announcement Option:</label>
        <span>${value}</span> <br>
        <label>Contact Option:</label>
        <span>${contact}</span> <br>
    </form>
</body>
</html>
