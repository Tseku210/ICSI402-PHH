<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Complex Form - Process Page</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<P>Thank you for entering your data.
<ul>
    <li>Secret Code: ${helper.data.secretCode}
    <li>Level of Happiness: ${helper.data.happiness}
    <li>Extras:
        <ul>
            <core:forEach var="element" items="${helper.data.extra}">
            <li>${element}
                </core:forEach>
        </ul>
    <li>Comments: ${helper.data.comments}
    <li>Grade: ${helper.data.grade}
    <li>Teams:
        <ul>
            <core:forEach var="element" items="${helper.data.team}">
            <li>${element}
                </core:forEach>
        </ul>
</ul>
<form method="get" action="Controller">
    <input type="submit" name="editButton" value="Edit">
    </p>
</form>
</body>
</html>



