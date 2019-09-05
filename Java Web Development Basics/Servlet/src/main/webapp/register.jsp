<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register user</title>
</head>
<body>
    <form action="/users" method="post">
        <div class="">
            <label>
                Username:
                <input type="text" name="username">
            </label>
        </div>

        <div class="">
            <label>
                Age:
                <input type="number" name="age">
            </label>
        </div>
        <button>Register</button>
    </form>
</body>
</html>
