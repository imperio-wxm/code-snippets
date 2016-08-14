<%--
  Created by IntelliJ IDEA.
  User: wxmimperio
  Date: 2016/8/7
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/login.do" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
