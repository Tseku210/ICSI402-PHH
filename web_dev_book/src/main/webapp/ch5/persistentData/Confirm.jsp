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
    The value of the hobby that was sent to
    this page is: <strong>${helper.data.hobby}</strong>
    <br>
    The value of the aversions that was sent to
    this page is: <strong>${helper.data.aversion}</strong>
    <br>
    The days per week for practicing the hobby that was sent to
    this page is: <strong>${helper.data.daysPerWeek}</strong>
<p>
    If there is an error, please select <em>Edit</em>,
    otherwise please select <em>Process</em>.
<form method="POST" action="Controller">
    <input type="submit" name="editButton"
           value="Edit">
    <input type="submit" name="processButton"
           value="Process">
</form>
</body>
</html>
