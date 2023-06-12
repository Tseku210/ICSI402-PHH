<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <title>Edit Page</title>
</head>
<body>
<p>
  This is a simple HTML page that has a form in it.
<form action="Controller">
  <p>
    If there are values for the hobby and aversion
    in the query string, then they are used to
    initialize the hobby and aversion text elements.
  <p>
    Hobby ${helper.errors.hobby}
    <input type="text" name="hobby"
           value="${helper.data.hobby}">
    <br>
    Aversion ${helper.errors.aversion}
    <input type="text" name="aversion"
           value="${helper.data.aversion}">
    <br>
    Days per week for practicing hobby ${helper.errors.daysPerWeek}
    <input type="text" name="daysPerWeek"
           value="${helper.data.daysPerWeek}">
  <p>
    <input type="submit" name="confirmButton"
           value="Confirm">
</form>
</body>
</html>
