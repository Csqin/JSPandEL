<%@ page import="it.itcast.doman.User" %>
<%@ page import="java.util.*" %>

<%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/4/29
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        User user=new User();
        user.setName("张三");
        user.setAge(20);
        user.setBir(new Date());
        request.setAttribute("user",user);

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age",18);
        map.put("user",user);
        request.setAttribute("map",map);
%>
    <h3>获取 对象值 </h3>
    ${requestScope.user}<br>
    ${user.name}<br>
    ${user.age}<br>
    ${user.bir}<br>
    ${user.birC}<br>
    <h3>获取 List值 </h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    <hr>
    <h3>获取 Map值 </h3>
    ${map.name}<br>
    ${map["name"]}<br>
    ${map.user.name}
</body>
</html>
