<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/28
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 获取值</title>
</head>
<body>
获取El数据<<br>
<% request.setAttribute("name","张三");  int [] a={1,2,3}; request.setAttribute("a",a);%>
${requestScope.name}<br>
${empty requestScope.a}
<hr>
</body>
</html>
