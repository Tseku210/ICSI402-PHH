<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>Confirmation Page with Edit/Process Options</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<p>This is a simple HTML page that has a form in it.</p>
<ul>
    <li>Secret Code: ${helper.data.secretCode}
    <li>Level of Happiness: ${helper.data.happiness}
    <li>Extras:
        <ul>
            <core:forEach var="extra" items="${helper.data.extra}">
            <li>${extra}
                </core:forEach>
        </ul>
    <li>Comments: ${helper.data.comments}
    <li>Grade: ${helper.data.grade}
    <li>Teams:
        <ul>
            <core:forEach var="team" items="${helper.data.team}">
            <li>${team}
                </core:forEach>
        </ul>
</ul>
<form method="post" action="Controller">
    <p>
        <input type="submit" name="editButton" value="Edit">
        <input type="submit" name="processButton" value="Process">
    </p>
</form>
</body>
</html>
