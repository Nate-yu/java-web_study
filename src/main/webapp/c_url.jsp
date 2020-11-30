<%--
  Created by IntelliJ IDEA.
  User: AD钙
  Date: 2020/11/30
  Time: 下午 07:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c_url</title>
</head>
<body>

    <%--以下使用的如register.jsp页面并未提供，主要是为了查看c:url的转码功能--%>

    使用绝对路径构造URL:<br />
    <c:url var="myURL" value="http://localhost:8080/java-web_study/register.jsp">
        <c:param name="username" value="张三" />
        <c:param name="country" value="中国" />
    </c:url>
    <a href="${myURL}">register.jsp</a><br />
    使用相对路径构造URL:<br />
    <c:url var="myURL" value="register.jsp?username=Tom&country=France" />
    <a href="${ myURL}">register.jsp</a>

</body>
</html>
