<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="ISO-8859-1">
                            <title>Insert title here</title>
                        </head>
                        <meta charset="ISO-8859-1">
                        <title>Insert title here</title>
                        <style>
                            #rcorners1 {
                                border-radius: 25px;
                                background: #73AD21;
                                padding: 20px;
                                width: 200px;
                                height: 150px;
                            }

                            * {
                                box-sizing: border-box;
                            }

                            body {
                                margin: 0;
                            }

                            /* Style the header */
                            .header {
                                background-color: #f1f1f1;
                                padding: 20px;
                                text-align: center;
                            }

                            /* Style the top navigation bar */
                            .topnav {
                                overflow: hidden;
                                background-color: #333;
                            }

                            /* Style the topnav links */
                            .topnav a {
                                float: left;
                                display: block;
                                color: #f2f2f2;
                                text-align: center;
                                padding: 14px 16px;
                                text-decoration: none;
                            }

                            /* Change color on hover */
                            .topnav a:hover {
                                background-color: #ddd;
                                color: black;
                            }

                            /* Create three equal columns that floats next to each other */
                            .column {
                                float: left;
                                width: 33.33%;
                                padding: 15px;
                            }

                            /* Clear floats after the columns */
                            .row:after {
                                content: "";
                                display: table;
                                clear: both;
                            }

                            /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
                            @media screen and (max-width:600px) {
                                .column {
                                    width: 100%;
                                }
                            }
                        </style>
                        </head>

                        <body>

                            <div class="header">
                                <h1>Customer Service</h1>

                            </div>

                            <jsp:include page="navbar.jsp" />

                            <div class="row">
                                <div class="column">

                                </div>

                                <div class="column">

                                    </br>
                                    <h1>Book An Appointment</h1>


                                    <form:form method="post" action="/bookAppointmentByDocID"
                                        modelAttribute="appDetailRequest">
                                        <table>
                                            <tr>
                                                <td>Doctor Id : </td>
                                                <td>
                                                    <form:input path="docID" value="${existedDoctor.doctorID}" readonly="true"/>
                                                         
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td>Patient Id : </td>
                                                <td>
                                                    <form:input path="patientID" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Patient Name : </td>
                                                <td>
                                                    <form:input path="patientName" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Address : </td>
                                                <td>
                                                    <form:input path="address" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>contact: </td>
                                                <td>
                                                    <form:input path="contact" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Age: </td>
                                                <td>
                                                    <form:input path="age" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Weight : </td>
                                                <td>
                                                    <form:input path="weight" />
                                                </td>
                                            </tr>



                                            <tr>
                                                <td> </td>
                                                <td><input type="submit" value="Book Appointment" /></td>
                                                <td><a href="/showDashboard">Home</a></td>
                                            </tr>

                                        </table>
                                    </form:form>
                                </div>

                                <div class="column">

                                </div>
                            </div>

                        </body>

                        </html>