<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h1>
    <fmt:message key="welcomeInfo"/>
</h1>
<form action="">
    <fmt:message key="usename"/>:<input/><br/>
    <fmt:message key="password"/>:<input/><br/>
    <input type="submit" value='<fmt:message key="loginBtn"/>'/>
</form>
</body>
</html>