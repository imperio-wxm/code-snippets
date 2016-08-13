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
        $("#btn").click(function () {
            $.post("json.do", function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<tr><td>" + data[i].name + "</td><td>"
                            + data[i].age + "</td><td>" + data[i].gender + "</td></tr>";
                }
                $("#context").html(html);
            });
        });
    });
</script>
<html>
<head>
    <title>json</title>
</head>
<body>
获取json：<input type="button" id="btn" value="获取"/>

<table width="80%" align="center">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>

    <tbody id="context">
    </tbody>
</table>
</body>
</html>
