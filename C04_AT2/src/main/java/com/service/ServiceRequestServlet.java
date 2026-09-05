package com.service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServiceRequestServlet")
public class ServiceRequestServlet extends HttpServlet {

    private static int requestCounter = 1000;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemCategory = request.getParameter("problemCategory");
        String problemDescription = request.getParameter("problemDescription");
        String priority = request.getParameter("priority");

        if (isEmpty(employeeId) ||
            isEmpty(employeeName) ||
            isEmpty(department) ||
            isEmpty(problemCategory) ||
            isEmpty(problemDescription) ||
            isEmpty(priority)) {

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Error: All fields are mandatory.</h2>"
            );

            return;
        }

        ServiceRequest serviceRequest =
                new ServiceRequest(
                        employeeId,
                        employeeName,
                        department,
                        problemCategory,
                        problemDescription,
                        priority
                );

        String requestNumber = "SR-" + (++requestCounter);

        request.setAttribute("serviceRequest", serviceRequest);
        request.setAttribute("requestNumber", requestNumber);

        request.getRequestDispatcher("acknowledgement.jsp")
               .forward(request, response);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}