<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Page</title>
</head>
<body>
<p>
    This is a simple HTML page that has a form in it.
<form action="Controller" method="post">
    <p>
        If there is a value for the address
        in the query string, then it is used to
        initialize the address text element.
    <p>
        Address ${helper.errors.address}
        <input type="text" name="address"
               value="${helper.data.address}">
    <p>
        <input type="submit" name="confirmButton"
               value="Confirm">
</form>
</body>
</html>
