<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
</head>
<body>
<p>Please enter your account number
    to access your data.
<form method="POST" action="Controller">
    <p>
        Account Number ${helper.errors.accountNumber}
        <input type="text" name="accountNumber"
               value="${helper.data.accountNumber}">
        <input type="submit" name="loginButton"
               value="Login">
    </p>
</form>
</body>
</html>