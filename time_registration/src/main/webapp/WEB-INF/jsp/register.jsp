<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<script type="text/javascript">
    function openPage(pageURL)
    {
        window.location.href = pageURL;
    }
</script>
<body>
<div class="container">
    <div class="image-container">
        <img src="../resources/images/login.png" alt="tng" width="100%">
    </div>
    <img src="../resources/images/logo.png" alt="logo" width="100" id="logo" />
    <div class="form-container">
        <div class="form-content">
            <h2 class="title">Бүртгүүлэх</h2>
            <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error" >${errorMessage}</p>
            <% } %>
            <form action="/register" method="POST">
                <div class="content-container">
                    <label for="fname"><b>Хэрэглэгчийн бүтэн нэр:</b></label>
                    <input id="fname" type="text" placeholder="Өөрийн нэрээ оруулна уу" name="name" required>
                    <label for="uname"><b>Хэрэглэгчийн нэр:</b></label>
                    <input id="uname" type="text" placeholder="Хэрэглэгчийн нэрээ оруулна уу" name="username" required>
                    <label for="phone"><b>Утасны дугаар:</b></label>
                    <input id="phone" type="text" placeholder="Утасны дугаараа оруулна уу" name="phoneNo" required>
                    <label for="psw"><b>Нууц үг:</b></label>
                    <input id="psw" type="password" placeholder="Нууц үгээ оруулна уу" name="password" required>
                    <label for="psw2"><b>Нууц үг давтах:</b></label>
                    <input id="psw2" type="password" placeholder="Нууц үгээ давтаж оруулна уу" required>
                    <div class="btns">
                        <button class="btn-login" type="submit">Бүртгүүлэх</button>
                        <button class="btn-register" onclick="openPage('login')">Нэвтрэх</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>


</body>
</html>