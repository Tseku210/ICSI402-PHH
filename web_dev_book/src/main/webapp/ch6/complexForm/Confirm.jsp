<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Complex Form - Confirm Page</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="core" %>
<p>
    This page displays the values from some
    complex form elements.
</p>
<ul>
    <li>Secret Code: ${helper.data.secretCode}
    <li>Level of Happiness: ${helper.data.happiness}
    <li>Extras:
        <ul>
            <core:forEach var="extra"
                          items="${helper.data.extra}">
            <li>${extra}
                </core:forEach>
        </ul>
    <li>Comments: ${helper.data.comments}
    <li>Grade: ${helper.data.grade}
    <li>Teams:
        <ul>
            <core:forEach var="team"
                          items="${helper.data.team}">
            <li>${team}
                </core:forEach>
        </ul>
</ul>
<form method="get" action="Controller">
    <p>
        <input type="submit" name="editButton"
               value="Edit">
        <input type="submit" name="processButton"
               value="Process">
    </p>
</form>
</body>
</html>
