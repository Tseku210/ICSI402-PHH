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
            <h2 class="title">Нэвтрэх</h2>
            <form action="/login" method="POST">
                <div class="imgcontainer">
                    <img src="../resources/images/profile.png" alt="Avatar" class="avatar">
                </div>
                <% if (request.getAttribute("errorMessage") != null) { %>
                <p class="error" >${errorMessage}</p>
                <% } %>
                <div class="content-container">
                    <div>
                        <label for="uname"><b>Нэвтрэх нэр:</b></label>
                        <input id="uname" type="text" placeholder="Хэрэглэгчийн нэрээ оруулна уу" name="username" required>
                        <label for="psw"><b>Нууц үг:</b></label>
                        <input id="psw" type="password" placeholder="Нууц үгээ оруулна уу" name="password" required>
                        <label><b>Хэрэглэгчийн төрөл:</b></label>
                        <select name="userRole" id="role">
                            <option value="DOCTOR">эмч</option>
                            <option value="NURSE">сувилагч</option>
                            <option value="PATIENT">хэрэглэгч</option>
                        </select>
                        <br>
                        <label>
                            <input type="checkbox" checked="checked" name="remember"> Remember me
                        </label>
                    </div>
                    <div class="btns">
                        <button class="btn-login" type="submit">Нэвтрэх</button>
                        <button class="btn-register" onclick="openPage('register')">Бүртгүүлэх</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>


</body>
</html>