package com.student.result;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OnlineStudentResultServlet")
public class OnlineStudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");

        String[] subjectNames = {
            "Subject 1", "Subject 2", "Subject 3",
            "Subject 4", "Subject 5"
        };

        String[] marks = {
            request.getParameter("mark1"),
            request.getParameter("mark2"),
            request.getParameter("mark3"),
            request.getParameter("mark4"),
            request.getParameter("mark5")
        };

        // Validate student details
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty()) {

            out.println("<h2 style='color:red;'>Error: Student Name and Register Number are required.</h2>");
            return;
        }

        int[] m = new int[5];

        // Validate marks
        for (int i = 0; i < 5; i++) {

            if (marks[i] == null || marks[i].trim().isEmpty()) {
                out.println("<h2 style='color:red;'>Error: " +
                            subjectNames[i] + " mark is required.</h2>");
                return;
            }

            try {
                m[i] = Integer.parseInt(marks[i]);

                if (m[i] < 0 || m[i] > 100) {
                    out.println("<h2 style='color:red;'>Error: " +
                                subjectNames[i] +
                                " mark must be between 0 and 100.</h2>");
                    return;
                }

            } catch (NumberFormatException e) {
                out.println("<h2 style='color:red;'>Error: " +
                            subjectNames[i] +
                            " mark must be numeric.</h2>");
                return;
            }
        }

        int total = 0;
        int highest = m[0];
        int lowest = m[0];

        for (int mark : m) {
            total += mark;

            if (mark > highest)
                highest = mark;

            if (mark < lowest)
                lowest = mark;
        }

        double average = total / 5.0;

        String grade;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";

        boolean pass = true;

        for (int mark : m) {
            if (mark < 40) {
                pass = false;
                break;
            }
        }

        String status = pass ? "PASS" : "FAIL";

        // Dynamic HTML result
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Result</title>");
        out.println("<style>");
        out.println("body{font-family:Arial;background:linear-gradient(135deg,#667eea,#764ba2);padding:40px;}");
        out.println(".card{background:white;width:700px;margin:auto;padding:30px;border-radius:20px;box-shadow:0 10px 30px rgba(0,0,0,.3);}");
        out.println("h1{text-align:center;color:#4b0082;}");
        out.println("table{width:100%;border-collapse:collapse;margin-top:20px;}");
        out.println("th,td{padding:14px;text-align:center;border:1px solid #ddd;}");
        out.println("th{background:#667eea;color:white;}");
        out.println(".pass{color:green;font-weight:bold;}");
        out.println(".fail{color:red;font-weight:bold;}");
        out.println(".summary{margin-top:20px;padding:15px;background:#f3f0ff;border-radius:10px;}");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class='card'>");

        out.println("<h1>🎓 Online Student Result</h1>");

        out.println("<p><b>Student Name:</b> " + name + "</p>");
        out.println("<p><b>Register Number:</b> " + regno + "</p>");

        out.println("<table>");
        out.println("<tr><th>Subject</th><th>Mark</th></tr>");

        for (int i = 0; i < 5; i++) {
            out.println("<tr>");
            out.println("<td>" + subjectNames[i] + "</td>");
            out.println("<td>" + m[i] + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<div class='summary'>");
        out.println("<p><b>Total:</b> " + total + " / 500</p>");
        out.println("<p><b>Average:</b> " + String.format("%.2f", average) + "</p>");
        out.println("<p><b>Highest Mark:</b> " + highest + "</p>");
        out.println("<p><b>Lowest Mark:</b> " + lowest + "</p>");
        out.println("<p><b>Grade:</b> " + grade + "</p>");

        if (pass)
            out.println("<p class='pass'>STATUS: PASS</p>");
        else
            out.println("<p class='fail'>STATUS: FAIL</p>");

        out.println("</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}