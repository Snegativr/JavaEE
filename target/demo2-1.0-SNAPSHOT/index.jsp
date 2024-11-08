<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateBean" class="com.example.demo2.DateBean" scope="page"/>
<jsp:useBean id="valueBean" class="com.example.demo2.ValueBean" scope="session"/>
<jsp:setProperty name="valueBean" property="value" param="value"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <p class="text-center">The current date and time is:
                <jsp:getProperty name="dateBean" property="curDate" />
            </p>
        </div>
        <div class="card-body text-center">
            <form action="index.jsp" method="post">
                <label>Введіть значення</label>
                <input type="text" name="value" />
                <input type="submit" value="Зберегти" />
        </div>
        <div class="card-body">
            <p class="text-center">The current value is:
                <jsp:getProperty name="valueBean" property="value" />
            </p>
        </div>
    </div>
</div>

</body>
</html>
