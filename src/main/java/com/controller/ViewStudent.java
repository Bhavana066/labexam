package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Student;
import com.model.StudentManager;

/**
 * Servlet implementation class ViewStudent
 */
@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP GET method.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentManager studentManager = new StudentManager();
        List<Student> students = studentManager.getAllStudents();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Student List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th></tr>");
        
        for (Student student : students) {
            out.println("<tr>");
            out.println("<td>" + student.getId() + "</td>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("<a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
