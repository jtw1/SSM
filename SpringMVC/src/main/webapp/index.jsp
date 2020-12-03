<%@ page language="java" pageEncoding="utf-8"%>
<html>
<body>
<a href="hello">helloWorld</a>
<h2>Hello World!</h2>
<h1>RequestMappingTestController测试</h1>
<a href="haha/handle01">test01-写在方法上的RequestMapping</a>
<h1>RequestMappingTestController属性测试</h1>

<a href="haha/handle02">handle02</a><br/>
<form action="haha/handle02" method="post">
    <input type="submit"/>
</form>
<a href="haha/handle03">handle03</a>
<%--发起图书的增删改查请求,使用Rest风格的URL地址查询一号图书
  /
  /book/1   GET    book/1   DELET  删除一号图书
  /book/1   PUT    更新一号图书
  /book/1   POST   添加一号图书
--%>
<h1>图书的增删改查请求</h1>
<a href="book/1">查询图书</a><br/>

<%--<a href="book/1">保存图书</a><br/>--%>
<form action="book" method="post">
    <input type="submit" value="添加一号图书">
</form>
<%--发送delete请求--%>
<form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除一号图书">
</form>
<%--发送put请求--%>
<form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新一号图书">
</form>
<a href="haha/toLoginPage">去登陆页面</a><br/>
<a href="handlePlus">下载资源，各种高清无码。。。</a>


</body>
</html>
