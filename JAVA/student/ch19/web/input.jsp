<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2022/5/26
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/select" method="post">
        输入用户名：<input type="text" name="uname"/><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
