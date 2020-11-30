<%--
  Created by IntelliJ IDEA.
  User: AD钙
  Date: 2020/11/30
  Time: 下午 07:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web域相关对象</title>
</head>
<body>
    <% pageContext.setAttribute("userName","nate"); %>
    <% request.setAttribute("bookName","java web"); %>
    <% session.setAttribute("userName","bin"); %>
    <% application.setAttribute("bookName","java"); %>

    表达式\${pageScope.userName}的值为：${pageScope.userName} <br/>
    表达式\${requestScope.bookName}的值为：${requestScope.bookName} <br/>
    表达式\${sessionScope.userName}的值为：${sessionScope.userName} <br/>
    表达式\${applicationScope.bookName}的值为：${applicationScope.bookName}<br/>
    表达式\${userName}的值为：${userName}
</body>
</html>
