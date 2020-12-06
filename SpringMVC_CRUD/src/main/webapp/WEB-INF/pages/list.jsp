<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4 0004
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<head>
    <title>员工列表页面</title>
    <script type="text/javascript" src="${ctp }/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>

<h1>员工列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <%--表头--%>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>department</th>
        <th>Edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <%--遍历获取表格数据--%>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="${ctp }/emp/${emp.id}">Edit</a>
            </td>
            <td>
                <a href="${ctp }/emp/${emp.id}" class="delBtn">delete</a>
                <%--删除键以按钮的形式--%>
<%--                <form action="${ctp }/emp/${emp.id}" method="post">--%>
<%--                    <input type="hidden" name="_method" value="DELETE"/>--%>
<%--                    <input type="submit" value="删除">--%>
<%--                </form>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${ctp }/toaddpage">添加员工</a>
<%--删除功能以超链接的形式--%>
<form id="deleteForm" action="${ctp }/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<script type="text/javascript">
    $(function () {
       $(".delBtn").click(function () {
           //改变表单的action指向
           $("#deleteForm").attr("action",this.href);
           //提交表单，相当于发了一个这个地址(this.href)的DELETE请求
           $("#deleteForm").submit();
           return false;
       });
    })
</script>
</body>
</html>
