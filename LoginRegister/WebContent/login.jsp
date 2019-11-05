<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
 <div align="center">
  <h1>User Login Form</h1>
  <form action="LoginServlet" method="post">
   <table style="with: 100%">
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" placeholder="username"/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" placeholder="password" /></td>
    </tr>
   </table>
   <input style="margin-top:15px;" type="submit" value="Submit" />
   
  </form>
  
  <form id = "button" action = "register.jsp" method = "post">
  	<input  type = "submit" value = "Register"/>
  </form>
  
 </div>
</body>
</html>