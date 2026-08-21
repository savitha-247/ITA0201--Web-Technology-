package com.student.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {

    private int constructorCount = 0;
    private int initCount = 0;
    private int serviceCount = 0;
    private int destroyCount = 0;

    public LifecycleServlet() {
        constructorCount++;
        System.out.println("Constructor executed");
    }

    @Override
    public void init() throws ServletException {
        initCount++;
        System.out.println("init() executed");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        serviceCount++;
        System.out.println("service()/doGet() executed");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Lifecycle</title>");

        out.println("<style>");
        out.println("body{font-family:Arial;background:linear-gradient(135deg,#667eea,#764ba2);padding:50px;}");
        out.println(".card{background:white;width:650px;margin:auto;padding:35px;border-radius:20px;box-shadow:0 10px 30px rgba(0,0,0,.3);}");
        out.println("h1{text-align:center;color:#4b0082;}");
        out.println("table{width:100%;border-collapse:collapse;margin-top:25px;}");
        out.println("th,td{padding:15px;text-align:center;border:1px solid #ddd;}");
        out.println("th{background:#667eea;color:white;}");
        out.println(".info{background:#f0f0ff;padding:15px;border-radius:10px;margin-top:20px;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>🔄 Servlet Lifecycle</h1>");

        out.println("<div class='info'>");
        out.println("<b>Refresh this page multiple times</b> to observe the lifecycle.");
        out.println("</div>");

        out.println("<table>");
        out.println("<tr><th>Lifecycle Method</th><th>Execution Count</th></tr>");

        out.println("<tr><td>Constructor</td><td>" + constructorCount + "</td></tr>");
        out.println("<tr><td>init()</td><td>" + initCount + "</td></tr>");
        out.println("<tr><td>service()/doGet()</td><td>" + serviceCount + "</td></tr>");
        out.println("<tr><td>destroy()</td><td>" + destroyCount + "</td></tr>");

        out.println("</table>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        destroyCount++;
        System.out.println("destroy() executed");
    }
}