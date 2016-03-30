<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gongxijun
  Date: 16-3-30
  Time: 上午2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Qunar.com</title>
</head>
<body>
<p>
    <c:forEach items="${List}" var="item"> 　　
        <table>
        <tr>
            <td>航空公司: </td>
            <td>${item.getFight_type()}</td>
        </tr>
        <tr>
            <td>航班号： </td>
            <td>${item.getFight_id()}</td>
        </tr>
        <tr>
            <td>身份证： </td>
            <td>${item.getCard_id()}</td>
        </tr>
        <tr>
            <td>年龄： </td>
            <td>${item.getAge()}</td>
        </tr>
        <tr>
            <td>起飞时间： </td>
            <td>${item.getFight_date()}</td>
        </tr>
        </table>
    +-----------------------分割线---------------------+<br/><br/>
        <br/>
    </c:forEach>
</p>
</body>
</html>
