<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Process Page</title>
</head>
<body>
<p>
    Thank you for your information. Your hobby of
    <strong>${param.hobby}</strong> and aversion of
    <strong>${param.aversion}</strong> will be added to our
    records, eventually.
<form action="Controller">
    <input type="hidden" name="hobby"
           value="${param.hobby}">
    <input type="hidden" name="aversion"
           value="${param.aversion}">
    <p>
        <input type="submit" name="editButton"
               value="Edit">
</form>
</body>
</html>



