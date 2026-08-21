package com.student.registration;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        // Validate empty fields
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty()) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body{font-family:Arial;background:linear-gradient(135deg,#ff758c,#ff7eb3);"
                    + "display:flex;justify-content:center;align-items:center;height:100vh;}");
            out.println(".box{background:white;padding:40px;border-radius:20px;text-align:center;"
                    + "box-shadow:0 10px 30px rgba(0,0,0,0.2);}");
            out.println("h2{color:#e63946;}");
            out.println("a{display:inline-block;margin-top:20px;padding:12px 25px;background:#6c63ff;"
                    + "color:white;text-decoration:none;border-radius:10px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='box'>");
            out.println("<h2>⚠ Please Fill All Fields!</h2>");
            out.println("<p>Every field is required for registration.</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            return;
        }

        // Successful result
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Successful</title>");

        out.println("<style>");

        out.println("*{box-sizing:border-box;}");

        out.println("body{margin:0;font-family:Arial,sans-serif;"
                + "background:linear-gradient(135deg,#667eea,#764ba2);"
                + "min-height:100vh;display:flex;justify-content:center;"
                + "align-items:center;padding:30px;}");

        out.println(".container{width:600px;background:white;border-radius:25px;"
                + "padding:35px;box-shadow:0 15px 40px rgba(0,0,0,0.25);}");

        out.println(".header{text-align:center;background:linear-gradient(135deg,#667eea,#764ba2);"
                + "color:white;padding:25px;border-radius:18px;margin-bottom:25px;}");

        out.println(".header h1{margin:0;font-size:28px;}");

        out.println(".success{font-size:45px;margin-bottom:10px;}");

        out.println(".details{background:#f7f8ff;border-radius:15px;padding:20px;}");

        out.println(".row{display:flex;justify-content:space-between;"
                + "padding:15px;border-bottom:1px solid #ddd;}");

        out.println(".row:last-child{border-bottom:none;}");

        out.println(".label{font-weight:bold;color:#555;}");

        out.println(".value{color:#667eea;font-weight:bold;}");

        out.println(".button{display:block;text-align:center;margin-top:25px;"
                + "padding:14px;background:#667eea;color:white;"
                + "text-decoration:none;border-radius:12px;font-weight:bold;}");

        out.println(".button:hover{background:#764ba2;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<div class='header'>");
        out.println("<div class='success'>✓</div>");
        out.println("<h1>Registration Successful!</h1>");
        out.println("<p>Student details submitted successfully</p>");
        out.println("</div>");

        out.println("<div class='details'>");

        out.println("<div class='row'>");
        out.println("<span class='label'>Student Name</span>");
        out.println("<span class='value'>" + name + "</span>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<span class='label'>Register Number</span>");
        out.println("<span class='value'>" + regno + "</span>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<span class='label'>Email</span>");
        out.println("<span class='value'>" + email + "</span>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<span class='label'>Department</span>");
        out.println("<span class='value'>" + department + "</span>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<span class='label'>Semester</span>");
        out.println("<span class='value'>" + semester + "</span>");
        out.println("</div>");

        out.println("</div>");

        out.println("<a class='button' href='index.html'>Register Another Student</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}