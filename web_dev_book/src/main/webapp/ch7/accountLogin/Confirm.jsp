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
      this page is: <b>${helper.data.hobby}</b>
      <br>
      The value of the aversions that was sent to 
      this page is: <b>${helper.data.aversion}</b>
    <p>
      If there is an error, please select <i>Edit</i>, 
      otherwise please select <i>Process</i>. 
    <form method="POST" action="Controller">
      <input type="submit" name="editButton" 
                           value="Edit">
      <input type="submit" name="processButton" 
                           value="Process">
    </form>
  </body>
</html>
