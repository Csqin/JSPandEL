<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/29
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if表达式</title>
</head>
<body>

<!--
1. if:相当于java代码的if语句
1. 属性：
* test 必须属性，接受boolean表达式
* 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
* 一般情况下，test属性值会结合el表达式一起使用
2. 注意：
* c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
!-->
    <%
        List list = new ArrayList();
        list.add("aaaa");
        request.setAttribute("list",list);
        request.setAttribute("number",4);
    %>

    <c:if test="${not empty  list}">
            <h2>lsit集合不为空</h2>
    </c:if>


    <c:if test="${number %2 !=0 }">
               ${number}为奇数
    </c:if>


    <c:if test="${number %2 ==0 }">
        ${number}为偶数
    </c:if>

</body>
</html>
