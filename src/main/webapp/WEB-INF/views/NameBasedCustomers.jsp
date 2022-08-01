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
						<link rel="stylesheet"
							href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
							integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
							crossorigin="anonymous">
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

							<!-- <div class="row">
								<div class="column"></div>

								<div class="column">
									<h1>Customer List</h1>
									
								</div>

								<div class="column"></div>
							</div> -->

							<h1>Customer List</h1>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">External Id</th>
										<th scope="col">Patner Function</th>
										<th scope="col">Name</th>
										<th scope="col">Address</th>
										<th scope="col">City</th>
										<th scope="col">Region</th>
										<th scope="col">Postal Code</th>
										<th scope="col">Country</th>
										<th scope="col">Source System</th>
										<th scope="col">Date Created</th>
										<th scope="col">Date Updated</th>
										<th scope="col">Status</th>
										<th scope="col">Edit</th>

									</tr>
								</thead>
								<c:forEach var="emp" items="${NameBasedCustomerList}">
									<tr>
										<td>${emp.externalId}</td>
										<td>${emp.partnerFunction}</td>
										<td>${emp.name}</td>
										<td>${emp.address}</td>
										<td>${emp.city}</td>
										<td>${emp.region}</td>
										<td>${emp.postalCode}</td>
										<td>${emp.country}</td>
										<td>${emp.sourceSystem}</td>
										<td>${emp.dateCreated}</td>
										<td>${emp.dateUpdated}</td>
										<td>${emp.isActive}</td>
										<td><a href="getDeleteCustomerByID/${emp.customerId}">Delete</a></td>


										<!-- <td><a href="getEditCustomerPage/${emp.customerId}">Edit</a></td>
										<td><a href="deleteemp/${emp.customerId}">Delete</a></td> -->
									</tr>
								</c:forEach>
							</table>

							<a href="/showDashboard">Home</a></br>
						</body>

						</html>