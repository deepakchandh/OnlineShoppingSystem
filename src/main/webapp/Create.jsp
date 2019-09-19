<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create User</title>
</head>
<% 
String uname=request.getParameter("id"); 
out.print("Welcome "+ uname);
session.setAttribute("sessname",uname); 
%>
<body>
    <div style="padding-left:50px;font-family:monospace;">
        <h2>Create User</h2>
        <form action="/Task/webapi/userInfo" method="POST">
            <div style="width: 100px; text-align:left;">
                <div style="padding:15px;">
                    User ID: <input name="id" />
                </div>
                <div style="padding:10px;">
                    Name: <input name="name" />
                </div>
                <div style="padding:10px;">
                    password: <input name="age" type="password" />
                </div>
                <div style="padding:20px;text-align:center">
                    <input type="submit" value="Submit" />
                </div>
                
            </div>
        </form>
    </div>
</body>
</html>