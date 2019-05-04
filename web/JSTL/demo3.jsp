<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/29
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!--
    foreach:相当于java代码的for语句
                for(int i=0;i<=10;i++)
                {

                }
            属性：
                   begin：开始值(i>=)
                      end：结束值(i<=)
                       var：变量（i）
                     step：步长（i++）
              varStatus:循环状态对象
                    index:容器中的索引，从0开始
                    count:循环次数，从1开始

                List <User> list
                for（User  user:list）
                {

                }
                属性：
                     items:容器对象
                     var：容器中元素的临时变量
            varStatus:循环状态对象
                  index:容器中的索引，从0开始
                  count:循环次数，从1开始
-->
<head>
    <title>foreach标签</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list",list);
%>
<h3>打印1-10的数字</h3>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}
</c:forEach>
<hr>
<h3>遍历List集合</h3>
<c:forEach items="${list}" var="str"  varStatus="s">
    ${s.index} ${s.count} ${str} <br>
</c:forEach>
</body>
</html>
