<%@ page import="it.itcast.doman.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>案例</title>
</head>
<body>

<%

    List list = new ArrayList();
    list.add(new User("Csqin",20,new Date()));
    list.add(new User("张三",21,new Date()));
    list.add(new User("李四",22,new Date()));
    request.setAttribute("list",list);

%>
<h3>遍历User对象数据到表格中</h3>
<table border="1" width="500" align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>bir</th>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count %2 ==0}">
            <tr bgcolor="#ffe4c4">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birC}</td>
            </tr>
        </c:if>

        <c:if test="${s.count %2  !=0}">
            <tr bgcolor="aqua">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birC}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>
</body>
</html>
