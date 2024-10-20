<!-- error.jsp -->
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Oops! An error occurred.</h1>
    <p>Error message: <%= exception.getMessage() %></p>
    <p>Exception Type: <%= exception.getClass().getName() %></p>
    <p>Please contact support for further assistance.</p>
</body>
</html>
