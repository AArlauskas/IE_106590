package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LabServlet", urlPatterns = {"/lab-servlet"})
public class LabServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name");
            if(name == null) throw new NullPointerException();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lab 2 Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hello " + name + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (NullPointerException e)
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lab 2 Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Name was not provided. Can't say hello. </h2>");
            out.println("</body>");
            out.println("</html>");
        }
        finally {
            out.close();
        }

    }
}
