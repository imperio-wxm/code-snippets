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
<script>
    $(function () {
        $("#username").blur(function () {
            $.post("ajax.do", {'name': $("#username").val()}, function (data) {
                alert(data);
            });
        });
    });
</script>
<html>
<head>
    <title>ajax</title>
</head>
<body>
用户名：<input type="text" id="username"/>
</body>
</html>
