<%@ page import="com.example.time_registration.model.entities.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.example.time_registration.model.enums.AppointmentType" %>
<%@ page import="com.example.time_registration.model.enums.AppointmentStatusEnum" %>
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

    function cancelAppointment(appointmentId) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/cancel', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = '/patient_home';
                } else {
                    console.error(xhr.statusText);
                }
            }
        };
        xhr.send('appointmentId=' + encodeURIComponent(appointmentId));
    }

    function showRescheduleDialog(appointmentId) {
        document.getElementById("appointmentId").value = appointmentId;

        document.getElementById("rescheduleDialog").style.display = "block";
    }

    function closeRescheduleDialog() {
        document.getElementById("rescheduleDialog").style.display = "none";
    }

    function rescheduleAppointment() {
        var appointmentId = document.getElementById("appointmentId").value;
        var newDateTime = document.getElementById("newDateTime").value;

        if (newDateTime) {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/reschedule', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        window.location.href = '/patient_home';
                    } else {
                        console.error(xhr.statusText);
                    }
                }
            };
            xhr.send('appointmentId=' + encodeURIComponent(appointmentId) + '&newDateTime=' + encodeURIComponent(newDateTime));
        }

        closeRescheduleDialog();
    }

    function showMessage(message, duration) {
        var messageElement = document.getElementById('message');
        messageElement.innerHTML = message;
        messageElement.style.display = 'block';

        setTimeout(function() {
            messageElement.innerHTML = '';
            messageElement.style.display = 'none';
        }, duration);
    }

</script>
<body>
`<h1>Тавтай морил ${user.name}</h1>`

<% if (request.getAttribute("successMessage") != null) { %>
<p id="message" style="display: none; background-color: green;"><%= request.getAttribute("successMessage") %></p>
<%-- Call the JavaScript function to display the message for 3 seconds --%>
<script>
    showMessage('<%= request.getAttribute("successMessage") %>', 3000);
</script>
<% } %>

<% if (request.getAttribute("errorMessage") != null) { %>
<p id="message" style="display: none; background-color: red;"><%= request.getAttribute("errorMessage") %></p>
<%-- Call the JavaScript function to display the message for 3 seconds --%>
<script>
    showMessage('<%= request.getAttribute("errorMessage") %>', 3000);
</script>
<% } %>

<a href="/patient/logout" id="logout">Logout</a>
<div class="tabs">
    <input type="radio" id="tab1" name="tab-control" checked>
    <input type="radio" id="tab2" name="tab-control">
    <input type="radio" id="tab3" name="tab-control">
    <ul>
        <li>
            <label for="tab1" role="button">
            <svg viewBox="0 0 24 24"><path d="M14,2A8,8 0 0,0 6,10A8,8 0 0,0 14,18A8,8 0 0,0 22,10H20C20,13.32 17.32,16 14,16A6,6 0 0,1 8,10A6,6 0 0,1 14,4C14.43,4 14.86,4.05 15.27,4.14L16.88,2.54C15.96,2.18 15,2 14,2M20.59,3.58L14,10.17L11.62,7.79L10.21,9.21L14,13L22,5M4.93,5.82C3.08,7.34 2,9.61 2,12A8,8 0 0,0 10,20C10.64,20 11.27,19.92 11.88,19.77C10.12,19.38 8.5,18.5 7.17,17.29C5.22,16.25 4,14.21 4,12C4,11.7 4.03,11.41 4.07,11.11C4.03,10.74 4,10.37 4,10C4,8.56 4.32,7.13 4.93,5.82Z"/></svg>
            <br>
            <span>Одоо захиалсан байгаа</span></label>
        </li>
        <li>
            <label for="tab2" role="button"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <title>clipboard-text-clock</title><path d="M21 11.11V5C21 3.9 20.11 3 19 3H14.82C14.4 1.84 13.3 1 12 1S9.6 1.84 9.18 3H5C3.9 3 3 3.9 3 5V19C3 20.11 3.9 21 5 21H11.11C12.37 22.24 14.09 23 16 23C19.87 23 23 19.87 23 16C23 14.09 22.24 12.37 21 11.11M12 3C12.55 3 13 3.45 13 4S12.55 5 12 5 11 4.55 11 4 11.45 3 12 3M6 7H18V9H6V7M9.08 17H6V15H9.08C9.03 15.33 9 15.66 9 16S9.03 16.67 9.08 17M6 13V11H11.11C10.5 11.57 10.04 12.25 9.68 13H6M16 21C13.24 21 11 18.76 11 16S13.24 11 16 11 21 13.24 21 16 18.76 21 16 21M16.5 16.25L19.36 17.94L18.61 19.16L15 17V12H16.5V16.25Z" /></svg>
                <br><span>Цаг захиалгын түүх</span>
            </label>
        </li>
        <%--        <li><label for="tab3" role="button"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>timetable</title><path d="M14,12H15.5V14.82L17.94,16.23L17.19,17.53L14,15.69V12M4,2H18A2,2 0 0,1 20,4V10.1C21.24,11.36 22,13.09 22,15A7,7 0 0,1 15,22C13.09,22 11.36,21.24 10.1,20H4A2,2 0 0,1 2,18V4A2,2 0 0,1 4,2M4,15V18H8.67C8.24,17.09 8,16.07 8,15H4M4,8H10V5H4V8M18,8V5H12V8H18M4,13H8.29C8.63,11.85 9.26,10.82 10.1,10H4V13M15,10.15A4.85,4.85 0 0,0 10.15,15C10.15,17.68 12.32,19.85 15,19.85A4.85,4.85 0 0,0 19.85,15C19.85,12.32 17.68,10.15 15,10.15Z" /></svg>><br><span>Эмчилгээний цаг захиалгын түүх</span></label></li>--%>
        <li></li>
        <li></li>
        <button onclick="openModal()" class="btn-add">Цаг захиалах</button>
    </ul>

    <div class="slider"><div class="indicator"></div></div>
    <div class="content">
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Цаг захиалсан</th>
                    <th>Статус</th>
                    <th>Төрөл</th>
                    <th>Үйлдлүүд</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Appointment> waitingAppointments = (List<Appointment>) request.getAttribute("waitingAppointments");
                    if (waitingAppointments != null && !waitingAppointments.isEmpty()) {
                        int counter = 1;
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        for (Appointment appointment : waitingAppointments) {
                            LocalDateTime dateTime = appointment.getTime();
                            String time = dateTime.format(timeFormatter);
                            String date = dateTime.format(dateFormatter);
                %>
                <tr>
                    <td>
                        <h6 class="mb-0"><%= counter++ %></h6>
                    </td>
                    <td>
                        <h6 class="mb-0"><%= time %></h6>
                        <small><%= date %></small>
                    </td>
                    <td>
                        <span class="status-wait">Хүлээгдэж буй</span>
                    </td>
                    <td>
                        <h6 class="mb-0">
                            <% if (appointment.getType().equals(AppointmentType.TREATMENT)) { %>
                            Эмчилгээнд орох
                            <% } else { %>
                            Үзлэгт орох
                            <% } %>
                        </h6>
                    </td>
                    <td>
                        <button class="btn-hold" onclick="showRescheduleDialog(<%= appointment.getId() %>)">Хойшлуулах</button>
                        <button class="btn-cancel" onclick="cancelAppointment(<%= appointment.getId() %>)">Цуцлах</button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </section>
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Цаг захиалсан</th>
                    <th>Статус</th>
                    <th>Төрөл</th>
                    <th>Үйлдлүүд</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Appointment> otherAppointments = (List<Appointment>) request.getAttribute("otherAppointments");
                    if (otherAppointments != null && !otherAppointments.isEmpty()) {
                        int counter = 1;
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        for (Appointment appointment : otherAppointments) {
                            LocalDateTime dateTime = appointment.getTime();
                            String time = dateTime.format(timeFormatter);
                            String date = dateTime.format(dateFormatter);
                %>
                <tr>
                    <td>
                        <h6 class="mb-0"><%= counter++ %></h6>
                    </td>
                    <td>
                        <h6 class="mb-0"><%= time %></h6>
                        <small><%= date %></small>
                    </td>
                    <td>
                        <% if (appointment.getStatusString().equals(AppointmentStatusEnum.DONE)) { %>
                        <span class="status-done">Үзүүлсэн</span>
                        <% } else if (appointment.getStatusString().equals(AppointmentStatusEnum.CANCELLED)) { %>
                        <span class="status-cancel">Цуцалсан</span>
                        <% } else { %>
                        <span class="status-unknown">Тодорхойгүй</span>
                        <% } %>

                    </td>
                    <td>
                        <h6 class="mb-0">
                            <% if (appointment.getType().equals(AppointmentType.TREATMENT)) { %>
                            Эмчилгээнд орох
                            <% } else { %>
                            Үзлэгт орох
                            <% } %>
                        </h6>
                    </td>
                    <td>
                        <button class="btn-cancel" onclick="cancelAppointment(<%= appointment.getId() %>)">Цуцлах</button>
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
        <h2>Цаг захиалга</h2>

        <form action="/add" method="post">
            <div>
                <p>Үзлэг авах өдөр</p>
                <input type="datetime-local" id="time" name="date">
            </div>
            <div>
                <p>Үзлэгийн төрөл</p>
                <div class="wrapper">
                    <input type="radio" name="type" value="examination" id="option-1" checked/>
                    <input type="radio" name="type" value="treatment" id="option-2" />
                    <label for="option-1" class="option option-1">
                        <div class="dot"></div>
                        <span>Үзлэг</span>
                    </label>
                    <label for="option-2" class="option option-2">
                        <div class="dot"></div>
                        <span>Эмчилгээ</span>
                    </label>
                </div>
            </div>
            <button class="btn btn-add" type="submit">Захиалах</button>
        </form>

    </div>
</div>
<div id="rescheduleDialog" class="modal">
    <div class="modalContent" >
        <h2>Шинэчлэх</h2>
        <div>
            <p>Шинэ огноо:</p>
            <input type="datetime-local" id="newDateTime" name="date" required>
        </div>
        <div class="btns" >
            <button class="btn btn-cancel" onclick="closeRescheduleDialog()">Болих</button>
            <button class="btn btn-add" onclick="rescheduleAppointment()">Шинэчлэх</button>
        </div>
    </div>
</div>
<input type="hidden" id="appointmentId" />
</body>

</html>