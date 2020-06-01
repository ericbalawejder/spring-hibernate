<%--
  Created by IntelliJ IDEA.
  User: ericbalawejder
  Date: 5/27/20
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.

  https://guides.gradle.org/building-java-web-applications/
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Web Demo</title>
</head>
<body>
<p>Say <a href="hello">Hello</a></p>

<form method="post" action="hello">
  <h2>Name:</h2>
  <input type="text" id="say-hello-text-input" name="name" />
  <input type="submit" id="say-hello-button" value="Say Hello" />
</form>
</body>
</html>
