<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Complex Form - Edit Page</title>
    <link rel="stylesheet" href="/${request.contextPath}/complex.css"
          type="text/css">
</head>
<body>
<form method="get" action="Controller">
    Secret Code
    <input type="password" name="secretCode"><br>
    Level of Happiness:<br>
    <input type="radio" name="happiness"
           value="1" checked>
    Elated
    <input type="radio" name="happiness"
           value="2">
    Ecstatic
    <input type="radio" name="happiness"
           value="3">
    Joyous<br>
    Preferred Extras:<br>
    <input type="checkbox" name="extra"
           value="sprinkles">
    Chocolate Sprinkles
    <input type="checkbox" name="extra"
           value="fudge" checked>
    Hot Fudge
    <input type="checkbox" name="extra"
           value="cream">
    Whipped Cream<br>
    Comments<textarea name="comments"></textarea>
    <br>
    Grade
    <select name="grade">
        <option value="4.0">A
        <option value="3.67">A-
        <option value="3.33" selected>B+
        <option value="3.00">B
        <option value="2.67">B-
        <option value="2.33">C+
        <option value="2.00">C
    </select>
    <br>
    Team
    <select name="team" multiple size="2">
        <option value="heat">Heat
        <option value="marlins" selected>Marlins
        <option value="dolphins" selected>Dolphins
        <option value="panthers">Panthers
    </select>
    <br>
    <input type="submit" name="confirmButton"
           value="Confirm">
</form>
</body></html>
