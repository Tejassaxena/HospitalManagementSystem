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
                  <h1>Add Patient </h1>
                  <h1>Add New Employee</h1>

                  <form:form method="post" action="addCustomer" modelAttribute="customerDetail">
                    <table>
                      <tr>
                        <td>External Id : </td>
                        <td>
                          <form:input path="externalId" />
                        </td>
                      </tr>
                      <tr>
                        <td>Partner Function : </td>
                        <td>
                          <form:input path="partnerFunction" />
                        </td>
                      </tr>
                      <tr>
                        <td>Name : </td>
                        <td>
                          <form:input path="name" />
                        </td>
                      </tr>
                      <tr>
                        <td>Address: </td>
                        <td>
                          <form:input path="address" />
                        </td>
                      </tr>
                      <tr>
                        <td>City: </td>
                        <td>
                          <form:input path="city" />
                        </td>
                      </tr>
                      <tr>
                        <td>Region : </td>
                        <td>
                          <form:input path="region" />
                        </td>
                      </tr>
                      <tr>
                        <td>Postal Code : </td>
                        <td>
                          <form:input path="postalCode" />
                        </td>
                      </tr>
                      <tr>
                        <td>Country : </td>
                        <td>
                          <form:input path="country" />
                        </td>
                      </tr>
                      <tr>
                        <td>Source System : </td>
                        <td>
                          <form:input path="sourceSystem" />
                        </td>
                      </tr>
                      <tr>
                        <td>Date Created : </td>
                        <td>
                          <form:input path="dateCreated" />
                        </td>
                      </tr>
                      <tr>
                        <td>Date Updated : </td>
                        <td>
                          <form:input path="dateUpdated" />
                        </td>
                      </tr>
                      <tr>
                        <td>Status : </td>
                        <td>
                          <form:input path="isActive" />
                        </td>
                      </tr>


                      <tr>
                        <td> </td>
                        <td><input type="submit" value="Save" /></td>
                        <td><a href="/showDashboard">Home</a></td>
                      </tr>
                      <!-- <tr>    
          <td> </td>    
          <td><input type="submit" value="Home" onclick="/showDashboard" /></td>    
          
         </tr>     -->
                    </table>
                  </form:form>
                </div>

                <div class="column">

                </div>
              </div>

            </body>

            </html>