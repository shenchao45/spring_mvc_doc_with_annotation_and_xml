<%--
  Created by IntelliJ IDEA.
  User: shenchao
  Date: 2017/2/3
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>abc</h1><br>
${user}
<br>
<form action="/testModelAttribute" method="post" >
    <input type="hidden" name="id" value="1">
    xm<input type="text" name="name">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
