<%--
  Created by IntelliJ IDEA.
  User: wxmimperio
  Date: 2016/8/7
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form action="/upload.do" method="post" enctype="multipart/form-data">
        File: <input type="file" name="file" />
        <input type="submit" value="上传" />
    </form>
</body>
</html>
