<%@ page import="com.service.ServiceRequest" %>

<%
    ServiceRequest serviceRequest =
        (ServiceRequest) request.getAttribute("serviceRequest");

    String requestNumber =
        (String) request.getAttribute("requestNumber");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Service Request Acknowledgement</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef4f8;
            margin: 0;
            padding: 40px;
        }

        .container {
            width: 600px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            color: #176b87;
        }

        .success {
            background: #dff6e8;
            color: #176b45;
            padding: 15px;
            text-align: center;
            border-radius: 8px;
            margin: 20px 0;
            font-weight: bold;
        }

        .request-number {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            color: #176b87;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        td:first-child {
            font-weight: bold;
            color: #174a63;
            width: 40%;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Service Request Submitted</h1>

    <div class="success">
        Your IT service request has been submitted successfully!
    </div>

    <div class="request-number">
        Request Number: <%= requestNumber %>
    </div>

    <table>

        <tr>
            <td>Employee ID</td>
            <td><%= serviceRequest.getEmployeeId() %></td>
        </tr>

        <tr>
            <td>Employee Name</td>
            <td><%= serviceRequest.getEmployeeName() %></td>
        </tr>

        <tr>
            <td>Department</td>
            <td><%= serviceRequest.getDepartment() %></td>
        </tr>

        <tr>
            <td>Problem Category</td>
            <td><%= serviceRequest.getProblemCategory() %></td>
        </tr>

        <tr>
            <td>Priority</td>
            <td><%= serviceRequest.getPriority() %></td>
        </tr>

        <tr>
            <td>Problem Description</td>
            <td><%= serviceRequest.getProblemDescription() %></td>
        </tr>

    </table>

</div>

</body>
</html>