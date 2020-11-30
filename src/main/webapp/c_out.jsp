<%--
  Created by IntelliJ IDEA.
  User: AD钙
  Date: 2020/11/30
  Time: 下午 07:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c_out</title>
</head>
<body>

    <%--第1个out标签 --%>
    <%--userName属性的值为：
    <c:out value="${param.username}" default="unknown" />
    <br />
    &lt;%&ndash;第2个out标签 &ndash;%&gt;
    userName属性的值为：
    <c:out value="${param.username}">
        unknown
    </c:out>--%>

    <%--escapeXml: 将特殊的字符进行HTML转码后再输出，若值为false则不会转码--%>
    <c:out value="${param.username }" escapeXml="true">
        <meta http-equiv="refresh" 	content="0;url=http://www.baidu.com" />
    </c:out>

</body>
</html>
