<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gongxijun
  Date: 16-3-29
  Time: 下午8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Qunar.com</title>
</head>
<body>
<form method="post" action="buy.do">
    <div>
        <br/>
        购票日期： <input type="date" name="user_date"/>
        <br/><br/><br/>
        航空公司：
        <select name="flight_type">
            <option value="香港航空"> 香港航空</option>
            <option value="海南航空"> 海南航空</option>
        </select><br/>
        航 班 号: <input name="flight_id" type="text"><br/>
        姓 名：<input name="username" type="text"/><br/>
        身份证件：<input name="card_id" type="text"/><br/>
        <input type="submit" name="提 交">
    </div>
</form>
</body>
</html>
