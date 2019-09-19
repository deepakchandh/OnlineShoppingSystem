<!-- <html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
</body>
</html>-->
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Create User</title>
</head>
<body>
    <div style="padding-left:50px;font-family:monospace;">
            CRUD Operations</br></br>
        <a href="${pageContext.request.contextPath}/Create.jsp"><div style= "color:saffron">Create User</div></a>
        </br></br>
       
        <a href="${pageContext.request.contextPath}/userInfo"><div
                                style="color:saffron">Get User details</div></a></br></br>
        <a href="${pageContext.request.contextPath}/update.jsp"><div
                                style="color:saffron">Update User</div></a></br></br>
        <a href="${pageContext.request.contextPath}/delete.jsp"><div
                                style="color:saffron">Delete User</div></a></br></br>
    </div>
</body>
</html>

