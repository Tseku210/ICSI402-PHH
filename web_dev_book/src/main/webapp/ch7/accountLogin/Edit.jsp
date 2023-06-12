<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Edit Page</title>
  </head>
  <body>
    <form method="POST" action="Controller">      
      <p>
        The account number is 
        <b>${helper.data.accountNumber}</b>.
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
      <p>
        <input type="submit" name="confirmButton" 
                             value="Confirm">     
    </form>
  </body>
</html>
