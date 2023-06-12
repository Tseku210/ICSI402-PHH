<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Edit Page</title>
</head>
<body>
<p>This is a simple HTML page that has a form in it.</p>
<form method="post" action="Controller">
  Secret Code
  <input type="password" name="secretCode"
         value="${helper.data.secretCode}">
  <br>
  Level of Happiness:
  <input type="radio" name="happiness" value="1"
  ${helper.checked.happiness["1"]}>Elated
  <input type="radio" name="happiness" value="2"
  ${helper.checked.happiness["2"]}>Ecstatic
  <input type="radio" name="happiness" value="3"
  ${helper.checked.happiness["3"]}>Joyous
  <br>
  Preferred Extras:
  <input type="checkbox" name="extra" value="sprinkles"
  ${helper.checked.extra.sprinkles}>
  Chocolate Sprinkles
  <input type="checkbox" name="extra" value="fudge"
  ${helper.checked.extra.fudge}>
  Hot Fudge
  <input type="checkbox" name="extra" value="cream"
  ${helper.checked.extra.cream}>
  Whipped Cream
  <br>
  Comments
  <textarea name="comments"
  >${helper.data.comments}</textarea>
  <br>
  Grade
  <select name="grade">
    <option value="4.00"
    ${helper.selected.grade["4.0"]}>A
    <option value="3.67"
    ${helper.selected.grade["3.67"]}>A-
    <option value="3.33"
    ${helper.selected.grade["3.33"]}>B+
    <option value="3.00"
    ${helper.selected.grade["3.0"]}>B
    <option value="2.67"
    ${helper.selected.grade["2.67"]}>B-
    <option value="2.33"
    ${helper.selected.grade["2.33"]}>C+
    <option value="2.00"
    ${helper.selected.grade["2.0"]}>C
  </select>
  <br>
  Team
  <select name="team" multiple size="2">
    <option value="heat"
    ${helper.selected.team.heat}>
      Heat
    <option value="marlins"
    ${helper.selected.team.marlins}>
      Marlins
    <option value="dolphins"
    ${helper.selected.team.dolphins}>
      Dolphins
    <option value="panthers"
    ${helper.selected.team.panthers}>
      Panthers
  </select>
  <br>
  <input type="submit" name="confirmButton"
         value="Confirm">
  <input type="reset"  value="Reset">
</form>
</body>
</html>
