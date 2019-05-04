<%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/29
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>

<!--
		2. choose:相当于java代码的switch语句
			1. 使用choose标签声明         			相当于switch声明
            2. 使用when标签做判断         			相当于case
            3. 使用otherwise标签做其他情况的声明    	相当于default
!-->
<%
        request.setAttribute("number",2);
%>
<c:choose>
    <c:when test="${number ==1}">星期一</c:when>
    <c:when test="${number ==2}">星期二</c:when>
    <c:when test="${number ==3}">星期三</c:when>
    <c:when test="${number ==4}">星期四</c:when>
    <c:when test="${number ==5}">星期五</c:when>
    <c:when test="${number ==6}">星期六</c:when>
    <c:when test="${number ==7}">星期天</c:when>
    <c:otherwise>数字输入有错</c:otherwise>

</c:choose>
</body>
</html>
