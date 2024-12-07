package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Student;
import com.model.StudentManager;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP GET method.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP POST method.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes requests for both HTTP GET and POST methods.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StudentManager studentManager = new StudentManager();
        String message;

        try {
            // Retrieve student data from request parameters
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");

            // Create Student object and set values
            Student student = new Student();
            student.setId(id);
            student.setName(name);

            // Insert student into the database
            message = studentManager.insertData(student);
        } catch (Exception e) {
            // Handle any errors that might have occurred
            message = "Error: " + e.getMessage();
        }

        // Output the result message to the client
        out.println("<html><body>");
        out.println("<h2>" + message + "</h2>");
        out.println("<a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
