package com.dynamic.welcome;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String studentName = "Savitha";
        String courseName = "B.Tech Information Technology";

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy | hh:mm:ss a");

        String dateTime = now.format(formatter);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<title>Dynamic Welcome Portal</title>");

        out.println("<style>");

        out.println("*{");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("box-sizing:border-box;");
        out.println("font-family:'Segoe UI',Arial,sans-serif;");
        out.println("}");

        out.println("body{");
        out.println("min-height:100vh;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("padding:25px;");
        out.println("background:");
        out.println("radial-gradient(circle at 15% 15%,#37326d,transparent 30%),");
        out.println("radial-gradient(circle at 85% 85%,#15544f,transparent 30%),");
        out.println("#080b18;");
        out.println("color:white;");
        out.println("}");

        out.println(".card{");
        out.println("width:750px;");
        out.println("max-width:100%;");
        out.println("padding:45px;");
        out.println("background:#11162b;");
        out.println("border:1px solid #2d3555;");
        out.println("border-radius:30px;");
        out.println("text-align:center;");
        out.println("box-shadow:0 30px 80px rgba(0,0,0,.45);");
        out.println("}");

        out.println(".logo{");
        out.println("width:75px;");
        out.println("height:75px;");
        out.println("margin:auto;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("border-radius:22px;");
        out.println("background:linear-gradient(135deg,#6366f1,#14b8a6);");
        out.println("font-size:32px;");
        out.println("font-weight:900;");
        out.println("}");

        out.println(".tag{");
        out.println("display:inline-block;");
        out.println("margin-top:25px;");
        out.println("padding:8px 16px;");
        out.println("border-radius:30px;");
        out.println("background:#102b2c;");
        out.println("border:1px solid #245050;");
        out.println("color:#4de1d1;");
        out.println("font-size:10px;");
        out.println("font-weight:bold;");
        out.println("letter-spacing:1.5px;");
        out.println("}");

        out.println("h1{");
        out.println("margin-top:18px;");
        out.println("font-size:38px;");
        out.println("}");

        out.println(".name{");
        out.println("color:#4de1d1;");
        out.println("}");

        out.println(".subtitle{");
        out.println("margin:12px auto 30px;");
        out.println("max-width:580px;");
        out.println("color:#8d96b5;");
        out.println("font-size:13px;");
        out.println("line-height:1.7;");
        out.println("}");

        out.println(".details{");
        out.println("display:grid;");
        out.println("grid-template-columns:1fr 1fr;");
        out.println("gap:15px;");
        out.println("text-align:left;");
        out.println("}");

        out.println(".box{");
        out.println("padding:20px;");
        out.println("background:#171d38;");
        out.println("border:1px solid #29304c;");
        out.println("border-radius:17px;");
        out.println("}");

        out.println(".box span{");
        out.println("display:block;");
        out.println("margin-bottom:8px;");
        out.println("color:#7f89a8;");
        out.println("font-size:9px;");
        out.println("font-weight:bold;");
        out.println("letter-spacing:1.3px;");
        out.println("}");

        out.println(".box strong{");
        out.println("font-size:15px;");
        out.println("}");

        out.println(".time{");
        out.println("grid-column:1/-1;");
        out.println("margin-top:15px;");
        out.println("padding:22px;");
        out.println("text-align:center;");
        out.println("background:#171d38;");
        out.println("border:1px solid #29304c;");
        out.println("border-radius:17px;");
        out.println("}");

        out.println(".time span{");
        out.println("display:block;");
        out.println("margin-bottom:10px;");
        out.println("color:#4de1d1;");
        out.println("font-size:9px;");
        out.println("font-weight:bold;");
        out.println("letter-spacing:1.5px;");
        out.println("}");

        out.println(".time strong{");
        out.println("font-size:20px;");
        out.println("}");

        out.println(".footer{");
        out.println("margin-top:28px;");
        out.println("color:#59627e;");
        out.println("font-size:10px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<div class='logo'>W</div>");

        out.println("<div class='tag'>JAVA SERVLET • DYNAMIC CONTENT</div>");

        out.println("<h1>");
        out.println("Welcome, <span class='name'>" + studentName + "!</span>");
        out.println("</h1>");

        out.println("<p class='subtitle'>");
        out.println("This page is generated dynamically using Java Servlet, ");
        out.println("doGet(), HttpServletRequest, HttpServletResponse and PrintWriter.");
        out.println("</p>");

        out.println("<div class='details'>");

        out.println("<div class='box'>");
        out.println("<span>STUDENT NAME</span>");
        out.println("<strong>" + studentName + "</strong>");
        out.println("</div>");

        out.println("<div class='box'>");
        out.println("<span>COURSE NAME</span>");
        out.println("<strong>" + courseName + "</strong>");
        out.println("</div>");

        out.println("<div class='time'>");
        out.println("<span>CURRENT DATE & TIME</span>");
        out.println("<strong>" + dateTime + "</strong>");
        out.println("</div>");

        out.println("</div>");

        out.println("<div class='footer'>");
        out.println("Dynamic Welcome Portal • Apache Tomcat");
        out.println("</div>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}