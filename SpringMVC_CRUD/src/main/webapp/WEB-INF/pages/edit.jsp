<%--
  Created by IntelliJ IDEA.
  User: wjt
  Date: 2020/12/6
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<head>
    <title>员工修改页面</title>
</head>
<body>
<h1>员工修改页面</h1>
<%--modelAttribute:这个表单的所有内容显示绑定的是请求域中的emplotee的值--%>
<form:form action="${ctp }/emp/${employee.id }" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="id" value="${employee.id}"/>
    email:<form:input path="email"/><br/>
    gender:&nbsp;&nbsp;&nbsp;
       男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
       女:<form:radiobutton path="gender" value="0"/><br/>
    dept:
       <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id">
       </form:select><br/>
    <input type="submit" value="修改">
</form:form>
</body>
</html>
