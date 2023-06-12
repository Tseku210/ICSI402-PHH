<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Process Page</title>
</head>
<body>
<p>
    Thank you for your information. Here is the map for the address.
<p>
    ${googleMap}
<form action="Controller">
    <input type="submit" name="editButton"
           value="New">
</form>
<form method="POST" action="Controller">
    <input type="submit" name="editButton"
           value="Edit">
</form>
</body>
</html>



