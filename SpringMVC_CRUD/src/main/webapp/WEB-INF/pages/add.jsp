<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4 0004
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--spring提供的表单标签库--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>员工添加</h1>
<%--表单标签：通过springMVC的表单标签可以实现将模型数据中的属性和HTML表单元素相绑定，以实现表单数据更便捷编辑和表单值的回显--%>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
<%--path就是原来HTML-input的name项，需要写
    作用：1 当作原生的name项
         2  自动回显隐含模型中某个对象对应的这个属性值--%>
    lastName:<form:input path="lastName"/><br/>
    email:<form:input path="email"/><br/>
    gender:
       男:<form:radiobutton path="gender" value="1"/><br/>
       女:<form:radiobutton path="gender" value="0"/><br/>
    department:
    <%--items:指定要遍历的集合,自动遍历，遍历出的每一个元素是一个department对象
       itemLabel="属性名"：指定遍历出的的这个对象的哪个属性是作为option标签体的值
       itemValue="属性值"：指定遍历出的的这个对象的哪个属性是作为要提交的value值--%>
    <form:select path="department.id"
                 items="${depts}" itemLabel="departmentName" itemValue="id"><br/>
    </form:select>
    <input type="submit" value="提交"/>
</form:form>









<%--<form action="">--%>
<%--    lastName:<input type="text" name="lastName"/><br/>--%>
<%--    email:<input type="text" name="email"><br/>--%>
<%--    gender:--%>
<%--       男：<input type="radio" name="gender" value="1">--%>
<%--       女：<input type="radio" name="gender" value="0"><br/>--%>
<%--    department:--%>
<%--       <select name="department.id">--%>
<%--           <c:forEach items="${depts}" var="deptItem">--%>
<%--               &lt;%&ndash;标签体中的是在页面的提示选项信息，value才是真正提交的值&ndash;%&gt;--%>
<%--               <option value="${deptItem.id}">${deptItem.departmentName}</option>--%>
<%--           </c:forEach>--%>
<%--       </select>--%>
<%--    <input type="submit" value="提交"/>--%>
<%--</form>--%>
</body>
</html>
