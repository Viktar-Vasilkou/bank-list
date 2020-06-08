<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 07.06.20
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>home</title>
  </head>
  <body>
  <form action="/SimpleServlet" method="GET">
    <p>
      Richest user: <button name="action" value="richest">GET</button>
    </p>
    <p>
      Account Sum: <button name="action" value="sum">GET</button>
    </p>
  </form>
  </body>
</html>
