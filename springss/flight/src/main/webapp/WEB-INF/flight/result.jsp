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
        航空公司: "${item.getFight_type()}"<br>
        航班号： "${item.getFight_id()}"<br/>
        身份证： "${item.getCard_id()}"<br/>
        年龄： "${item.getAge()}"<br/>
        起飞时间： "${item.getFight_date()}"<br/>
        +-----------------------分割线---------------------+<br/><br/>
        <br/>
    </c:forEach>
</p>
</body>
</html>
