package decipher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ViewRecords extends HttpServlet
{

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<a href='/'>Add New Student</a>");
            out.println("<h1>Students Record List</h1>");

            List<StudentRecord> list=StudentDao.getAllStudents();

            out.print("<table border='1' width='100%'");
            
            out.print("<tr><th>Id</th><th>Name</th><th>FatherName</th><th>Age</th><th>Standard</th><th>Edit</th><th>Delete</th></tr>");

            for(StudentRecord student:list)
            {
                out.print("<tr><td>"+student.getId()+"</td><td>"+student.getName()+"</td><td>"+student.getFatherName()+"</td><td>"+student.getAge()+"</td><td>"+student.getStandard()+"</td><td><a href='EditServlet?id="+student.getId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+student.getId()+"'>delete</a></td></tr>");
            }
            out.print("</table>");

            out.close();
        }
    }

