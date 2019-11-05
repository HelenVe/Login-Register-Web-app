<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
 <div align="center" >
  <h1>User Registration Form</h1>
  <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
   <table>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" placeholder="John"/></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" placeholder="Smith"/></td>
    </tr>
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" placeholder="jsmith"/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Email Address</td>
     <td><input type="email" name="address"  placeholder="jsmith@gmail.com"/></td>
    </tr>
     </table>
   <input type="submit" value="Submit" id="button" />
  </form>
 </div>
</body>
</html>