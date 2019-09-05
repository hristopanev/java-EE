<%@ page import="java.util.Date" %>
<%@ page import="constants.ViewConstants" %>
<%@ page import="static constants.ViewConstants.VIEW_MODEL_ATTRIBUTE_NAME" %>
<%@ page import="viewmodels.HomeViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <h1>It works <p><%= request.getAttribute("currentDate")%></p></h1>
    <% viewmodels.HomeViewModel viewModel = (HomeViewModel) request.getAttribute(VIEW_MODEL_ATTRIBUTE_NAME); %>
    <h2>Hello <%= viewModel.getName()%> </h2>
    <h2><%= viewModel.getAge()%> </h2>

</body>
</html>