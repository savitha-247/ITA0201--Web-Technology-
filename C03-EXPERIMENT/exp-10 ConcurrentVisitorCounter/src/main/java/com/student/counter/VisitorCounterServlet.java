package com.student.counter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VisitorCounterServlet")
public class VisitorCounterServlet extends HttpServlet {

    // Unsafe shared variable
    private int unsafeCounter = 0;

    // Thread-safe shared variable
    private AtomicInteger safeCounter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Unsafe counter
        int temp = unsafeCounter;
        Thread.yield();
        unsafeCounter = temp + 1;

        // Thread-safe counter
        int safeValue = safeCounter.incrementAndGet();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Concurrent Visitor Counter</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:linear-gradient(135deg,#667eea,#764ba2);padding:50px;}");
        out.println(".card{background:white;width:700px;margin:auto;padding:35px;border-radius:20px;box-shadow:0 10px 30px rgba(0,0,0,.3);}");
        out.println("h1{text-align:center;color:#4b0082;}");
        out.println("table{width:100%;border-collapse:collapse;margin-top:25px;}");
        out.println("th,td{padding:15px;text-align:center;border:1px solid #ddd;}");
        out.println("th{background:#667eea;color:white;}");
        out.println(".unsafe{color:red;font-weight:bold;}");
        out.println(".safe{color:green;font-weight:bold;}");
        out.println(".info{background:#f3f0ff;padding:15px;margin-top:20px;border-radius:10px;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>👥 Concurrent Visitor Counter</h1>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Counter Type</th>");
        out.println("<th>Visitor Count</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td class='unsafe'>Unsafe Counter</td>");
        out.println("<td>" + unsafeCounter + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td class='safe'>Thread-Safe Counter</td>");
        out.println("<td>" + safeValue + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<div class='info'>");
        out.println("<b>Unsafe:</b> Shared integer may cause race conditions.");
        out.println("<br><br>");
        out.println("<b>Thread-Safe:</b> AtomicInteger safely updates the shared counter.");
        out.println("</div>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}