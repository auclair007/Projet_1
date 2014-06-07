<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
		body  {
			color: yellow;
			background-color: white;
			border: none;
		}
		
		.main {
			position: absolute;
			left: 50%;
			top: 0px;
			margin-left: -450px;
		}
		
		img {
			border: none;
		}
		
		.ico {
			position: absolute;
			filter: alpha(opacity = 20);
			opacity: 0.2;
			text-align: center;
			font-family: verdana, helvetica, arial, sans-serif;
			font-size: 100%;
			font-weight: bold;
			color: white;
			z-index:0;
		}
		
		a {
			text-decoration: none;
			cursor: pointer;
			color: #E35A20;
			outline:none;
		}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body background ="mur_du_son_2.jpg">
<H2>Paiement des charges URSSAF</H2>
<form action="${pageContext.request.contextPath}/ParamUrssaf" method="post">
<table border=0>
<tr>
	<td>Login</td>
	<td><input type="text" size="20" name="username"></td>
</tr>
<tr>
	<td>Pass</td>
	<td><input type="password" size="20" name="password"></td>
</tr>
<tr>
	<td colspan=2 align="center"><input type="submit" value="login"></td>
</tr>	
</table>
</form>
</body>
</html>