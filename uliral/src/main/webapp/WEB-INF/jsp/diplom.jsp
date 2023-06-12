<%@ page import="com.example.uliral.model.entities.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.uliral.model.entities.Diplom" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../resources/css/index.module.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<script>
    let btn = document.getElementById("addbtn");
    function openModal(){
        document.getElementById("kk").style.display = "block";
    }

    function closeModal() {
        document.getElementById("kk").style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == document.getElementById("kk")) {
            document.getElementById("kk").style.display = "none";
        }
    }

    function deleteStudent(studentId) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/diplom/delete', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = '/diplom';
                } else {
                    console.error(xhr.statusText);
                }
            }
        };
        xhr.send('diplomId=' + encodeURIComponent(studentId));
    }
</script>
<body>
<h1>Тавтай морил</h1>
<div class="tabs">
    <input type="radio" id="tab1" name="tab-control" checked>
    <input type="radio" id="tab2" name="tab-control">
    <input type="radio" id="tab3" name="tab-control">
    <input type="radio" id="tab4" name="tab-control">
    <ul>
        <li><label for="tab1" role="button">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>account-school</title><path d="M16 8C16 10.21 14.21 12 12 12C9.79 12 8 10.21 8 8L8.11 7.06L5 5.5L12 2L19 5.5V10.5H18V6L15.89 7.06L16 8M12 14C16.42 14 20 15.79 20 18V20H4V18C4 15.79 7.58 14 12 14Z" /></svg>
            <br><a href="/">Оюутан</a></label></li>
        <li>
            <label for="tab2" role="button">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>certificate</title><path d="M4,3C2.89,3 2,3.89 2,5V15A2,2 0 0,0 4,17H12V22L15,19L18,22V17H20A2,2 0 0,0 22,15V8L22,6V5A2,2 0 0,0 20,3H16V3H4M12,5L15,7L18,5V8.5L21,10L18,11.5V15L15,13L12,15V11.5L9,10L12,8.5V5M4,5H9V7H4V5M4,9H7V11H4V9M4,13H9V15H4V13Z" /></svg>
                <br><a href="/diplom">Диплом</a>
            </label>
        </li>
        <%--        <li><label for="tab3" role="button"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>timetable</title><path d="M14,12H15.5V14.82L17.94,16.23L17.19,17.53L14,15.69V12M4,2H18A2,2 0 0,1 20,4V10.1C21.24,11.36 22,13.09 22,15A7,7 0 0,1 15,22C13.09,22 11.36,21.24 10.1,20H4A2,2 0 0,1 2,18V4A2,2 0 0,1 4,2M4,15V18H8.67C8.24,17.09 8,16.07 8,15H4M4,8H10V5H4V8M18,8V5H12V8H18M4,13H8.29C8.63,11.85 9.26,10.82 10.1,10H4V13M15,10.15A4.85,4.85 0 0,0 10.15,15C10.15,17.68 12.32,19.85 15,19.85A4.85,4.85 0 0,0 19.85,15C19.85,12.32 17.68,10.15 15,10.15Z" /></svg>><br><span>??????????? ??? ????????? ????</span></label></li>--%>
        <li>
            <label for="tab3" role="button">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>school</title><path d="M12,3L1,9L12,15L21,10.09V17H23V9M5,13.18V17.18L12,21L19,17.18V13.18L12,17L5,13.18Z" /></svg>
                <br><a href="/internship">Дадлага</a>
            </label>
        </li>
        <li>
            <label for="tab4" role="button">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>clipboard-text</title><path d="M17,9H7V7H17M17,13H7V11H17M14,17H7V15H14M12,3A1,1 0 0,1 13,4A1,1 0 0,1 12,5A1,1 0 0,1 11,4A1,1 0 0,1 12,3M19,3H14.82C14.4,1.84 13.3,1 12,1C10.7,1 9.6,1.84 9.18,3H5A2,2 0 0,0 3,5V19A2,2 0 0,0 5,21H19A2,2 0 0,0 21,19V5A2,2 0 0,0 19,3Z" /></svg>
                <br><a href="/assignment">Бие даалт</a>
            </label>
        </li>
        <button onclick="openModal()" class="btn-add">Диплом нэмэх</button>
    </ul>
<%--    <div class="slider"><div class="indicator"></div></div>--%>
    <form method="GET" action="/diplom" class="filter-form">
        <input class="input" type="text" id="search" name="search" placeholder="Search">
        <input class="btn-add btn-filter" type="submit" value="Filter">
    </form>
    <div class="content">
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Оюутны дугаар</th>
                    <th>Зэрэг</th>
                    <th>Төгссөн жил</th>
                    <th>Үйлдлүүд</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Diplom> diploms = (List<Diplom>) request.getAttribute("diploms");
                    if (diploms != null && !diploms.isEmpty()) {
                        int counter = 1;
                        for (Diplom diplom : diploms) {
                %>
                <tr>
                    <td>
                        <h6 class="mb-0"><%= counter++ %></h6>
                    </td>
                    <td>
                        <h6 class="mb-0"><%= diplom.getStudent().getStudent_id() %></h6>
                        <small><%= diplom.getUniversityName() %></small>
                    </td>
                    <td>
                        <span class="status-wait"><%= diplom.getDegreeName() %></span>
                    </td>
                    <td>
                        <h6 class="mb-0">
                            <%= diplom.getGraduationYear() %>
                        </h6>
                    </td>
                    <td>
                        <button class="btn-cancel" onclick="deleteStudent('<%= diplom.getId() %>')">Устгах</button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </section>
    </div>
</div>
<div id="kk" class="modal">
    <div class="modalContent">
        <span onclick="closeModal()" class="closebtn">&times;</span>
        <h2>Оюутан нэмэх</h2>
        <form action="/diplom/add" method="post">
            <div>
                <p>Сурагчийн дугаар</p>
                <input class="input" type="text" id="studentId" name="studentId">
            </div>
            <div>
                <p>Төгссөн сургууль</p>
                <input class="input" type="text" id="university" name="university">
            </div>
            <div>
                <p>Зэрэг</p>
                <input class="input" type="text" id="degree" name="degreeName">
            </div>
            <div>
                <p>Төгссөн жил</p>
                <input class="input" type="text" id="year" name="graduationYear">
            </div>
            <button class="btn btn-add"  type="submit">Нэмэх</button>
        </form>

    </div>
</div>
</body>
</html>