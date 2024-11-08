<jsp:useBean id="valueBean" class="com.example.demo2.ValueBean" scope="session"/>
<jsp:setProperty name="valueBean" property="value" param="value"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div class="card-body">
        <p class="text-center">The current value is:
            <jsp:getProperty name="valueBean" property="value" />
        </p>
    </div>
</head>
<body>

</body>
</html>
