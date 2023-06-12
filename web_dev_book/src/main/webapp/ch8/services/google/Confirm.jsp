<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Confirm Page</title>
</head>
<body>
<p>
    This is a simple HTML page that has a form in it.
<p>
    The value of the address that was sent to
    this page is: <strong>${helper.data.address}</strong>

<p>
    If there is an error, please select <em>Edit</em>,
    otherwise please select <em>Process</em>.
<form action="Controller" method="post">
    <input type="submit" name="editButton"
           value="Edit">
    <input type="submit" name="processButton"
           value="Process">
</form>
</body>
</html>

