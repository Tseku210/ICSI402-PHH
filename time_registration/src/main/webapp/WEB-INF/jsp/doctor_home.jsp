<%@ page import="com.example.time_registration.model.entities.Appointment" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.time_registration.model.enums.AppointmentType" %>
<%@ page import="com.example.time_registration.model.enums.AppointmentStatusEnum" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../resources/css/doctor.module.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script>
    function cancelAppointment(appointmentId) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/doctor/cancel', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = '/doctor_home';
                } else {
                    console.error(xhr.statusText);
                }
            }
        };
        xhr.send('appointmentId=' + encodeURIComponent(appointmentId));
    }

    function doneAppointment(appointmentId) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/doctor/done', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = '/doctor_home';
                } else {
                    console.error(xhr.statusText);
                }
            }
        };
        xhr.send('appointmentId=' + encodeURIComponent(appointmentId));
    }

    function deleteAppointment(appointmentId) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/doctor/delete', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = '/doctor_home';
                } else {
                    console.error(xhr.statusText);
                }
            }
        };
        xhr.send('appointmentId=' + encodeURIComponent(appointmentId));
    }
</script>

<body>

<h1>Тавтай морил ${user.name}</h1>
<a href="/home/logout" id="logout">Logout</a>
<div class="tabs">
    <input type="radio" id="tab1" name="tab-control" checked>
    <input type="radio" id="tab2" name="tab-control">
    <input type="radio" id="tab3" name="tab-control">
    <ul>
        <li><label for="tab1" role="button"><svg viewBox="0 0 24 24"><path d="M14,2A8,8 0 0,0 6,10A8,8 0 0,0 14,18A8,8 0 0,0 22,10H20C20,13.32 17.32,16 14,16A6,6 0 0,1 8,10A6,6 0 0,1 14,4C14.43,4 14.86,4.05 15.27,4.14L16.88,2.54C15.96,2.18 15,2 14,2M20.59,3.58L14,10.17L11.62,7.79L10.21,9.21L14,13L22,5M4.93,5.82C3.08,7.34 2,9.61 2,12A8,8 0 0,0 10,20C10.64,20 11.27,19.92 11.88,19.77C10.12,19.38 8.5,18.5 7.17,17.29C5.22,16.25 4,14.21 4,12C4,11.7 4.03,11.41 4.07,11.11C4.03,10.74 4,10.37 4,10C4,8.56 4.32,7.13 4.93,5.82Z"/>
        </svg><br><span>Одоо захиалсан байгаа</span></label></li>
        <li><label for="tab2" role="button"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>clipboard-text-clock</title><path d="M21 11.11V5C21 3.9 20.11 3 19 3H14.82C14.4 1.84 13.3 1 12 1S9.6 1.84 9.18 3H5C3.9 3 3 3.9 3 5V19C3 20.11 3.9 21 5 21H11.11C12.37 22.24 14.09 23 16 23C19.87 23 23 19.87 23 16C23 14.09 22.24 12.37 21 11.11M12 3C12.55 3 13 3.45 13 4S12.55 5 12 5 11 4.55 11 4 11.45 3 12 3M6 7H18V9H6V7M9.08 17H6V15H9.08C9.03 15.33 9 15.66 9 16S9.03 16.67 9.08 17M6 13V11H11.11C10.5 11.57 10.04 12.25 9.68 13H6M16 21C13.24 21 11 18.76 11 16S13.24 11 16 11 21 13.24 21 16 18.76 21 16 21M16.5 16.25L19.36 17.94L18.61 19.16L15 17V12H16.5V16.25Z" /></svg><br><span>Цаг захиалгын түүх</span></label></li>
        <%--        <li><label for="tab3" role="button"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><title>timetable</title><path d="M14,12H15.5V14.82L17.94,16.23L17.19,17.53L14,15.69V12M4,2H18A2,2 0 0,1 20,4V10.1C21.24,11.36 22,13.09 22,15A7,7 0 0,1 15,22C13.09,22 11.36,21.24 10.1,20H4A2,2 0 0,1 2,18V4A2,2 0 0,1 4,2M4,15V18H8.67C8.24,17.09 8,16.07 8,15H4M4,8H10V5H4V8M18,8V5H12V8H18M4,13H8.29C8.63,11.85 9.26,10.82 10.1,10H4V13M15,10.15A4.85,4.85 0 0,0 10.15,15C10.15,17.68 12.32,19.85 15,19.85A4.85,4.85 0 0,0 19.85,15C19.85,12.32 17.68,10.15 15,10.15Z" /></svg>><br><span>Эмчилгээний цаг захиалгын түүх</span></label></li>--%>
        <li></li>
        <li></li>
    </ul>

    <div class="slider"><div class="indicator"></div></div>
    <div class="content">
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Нэр</th>
                    <th>Цаг захиалсан</th>
                    <th>Статус</th>
                    <th>Утас</th>
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
                        <div class="user-info">
                            <div class="user-info__basic">
                                <h6 class="mb-0"><%= appointment.getUser().getName() %></h6>
                            </div>
                        </div>
                    </td>
                    <td>
                        <h6 class="mb-0"><%= time %></h6>
                        <small><%= date %></small>
                    </td>
                    <td>
                        <span class="status-wait">Хүлээгдэж буй</span>
                    </td>
                    <td>
                        <h6 ><%= appointment.getUser().getPhoneNumber() %></h6>
                    </td>
                    <td>
                        <button class="btn-done" onclick="doneAppointment(<%= appointment.getId() %>)">Үзсэн</button>
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
                    <th>Нэр</th>
                    <th>Цаг захиалсан</th>
                    <th>Статус</th>
                    <th>Утас</th>
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
                        <div class="user-info">
                            <div class="user-info__basic">
                                <h6 class="mb-0"><%= appointment.getUser().getName() %></h6>
                            </div>
                        </div>
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
                        <h6 ><%= appointment.getUser().getPhoneNumber() %></h6>
                    </td>
                    <td>
                        <button class="btn-cancel" onclick="deleteAppointment(<%= appointment.getId() %>)">Устгах</button>
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
</body>

</html>

