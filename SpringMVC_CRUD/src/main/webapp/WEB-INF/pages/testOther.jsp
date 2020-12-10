<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/10 0010
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
<form action="${ctp}/testRequestBody" method="post">
    <input name="username" value="tomcat"/>
    <input name="password" value="123456"/>
    <input type="submit" value="提交"/>
</form>
<a href="${ctp }/testRequestBody">ajax发送json数据</a>
</body>
<script type="text/javascript">
    $("a:first").click(function () {
      //点击发送Ajax请求，请求带的数据是json
        var emp={lastName:"张三",email:"aaa@163.com",gender:0};
        alert(typeof emp);
        //js对象
        var empStr=JSON.stringify(emp);
        alert(empStr);
        $.ajax({
            url:"${ctp }/testRequestBody",
            type:"POST",
            data:empStr,
            contentType:"application/json",
            success:function (data){
                alert(data);
            }
        });
        return false;
    });
</script>
</html>
