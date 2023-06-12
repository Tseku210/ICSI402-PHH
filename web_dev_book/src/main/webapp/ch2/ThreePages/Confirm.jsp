<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Confirmation Page with Edit/Process Options</title>
</head>
<body>
<p>The value of the hobby that was sent to
    this page is: <strong>${param.hobby}</strong>
<p>
    If there is an error, please select <em>Edit</em>,
    otherwise please select <em>Process</em>.
<form action="Edit.jsp">
    <input type="hidden" name="hobby"
           value="${param.hobby}">
    <input type="submit" name="editButton"
           value="Edit">
</form>
<form action="Process.jsp">
    <input type="hidden" name="hobby"
           value="${param.hobby}">
    <input type="submit" name="processButton"
           value="Process">
</form>
</body>
</html>
