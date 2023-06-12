<!DOCTYPE HTML>
<html>
<head>
  <meta charset='utf-8'>
  <title>Initialized JSP</title>
</head>
<body>
<form>
  <p>
    This is a simple HTML page that has a form in it.
  <p>
    The hobby was received as: <strong>${param.hobby}</strong>
  <p>
    Hobby: <input type='text' name='hobby'
                  value='${param.hobby}'>
    <input type='submit' name='confirmButton'
           value='Confirm'>
</form>
</body>
</html>