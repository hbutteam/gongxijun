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
        <table>
        <tr>
        <td>购票日期：</td> <td> <input type="date" name="user_date"/></td>
        </tr><br/>
        <tr><br/>
        <TD>航空公司：</TD><TD>
        <select name="flight_type">
            <option value="香港航空"> 香港航空</option>
            <option value="海南航空"> 海南航空</option>
        </select></TD>
            <br/>
        </tr>

         <tr>
        <td>航 班 号:</td>
                <td><input name="flight_id" type="text"><br/></td></tr>
        <tr>
        <td>姓 名：</td><td><input name="username" type="text"/></td>
            <br/></tr>
            <tr>
        <TD>身份证件：</TD>
            <TD><input name="card_id" type="text"/></TD><br/></tr>
          <tr><TD><input type="submit" name="提 交"></TD></tr>
        </table>
    </div>
</form>
</body>
</html>
