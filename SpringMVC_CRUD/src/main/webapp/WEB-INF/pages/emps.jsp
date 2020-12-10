<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/10 0010
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<%new Date();%>
<a href="${ctp }/getallajax">ajax获取所有员工</a><br/>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        //发送Ajax获取所有员工
        $.ajax({
            url:"${ctp }/getallajax",
            type:"GET",
            success:function (data) {
                //console.log(data);
                $.each(data,function () {
                    var empInfo=this.lastName+"-->"+this.birth+"-->"+this.gender;
                    $("div").append(empInfo+"<br/>");
                })
            }
            }

        )
    });
</script>
</body>
</html>
