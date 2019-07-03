package decipher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditRecords  extends HttpServlet

{

        protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
           ////handles the GET request. It is invoked by the web container.

        {

            response.setContentType("text/html");//setting the content type
            PrintWriter out=response.getWriter();//get the stream to write the data

            out.println("<h1>Update Student Record</h1>");

            String sid=request.getParameter("id");
            int id=Integer.parseInt(sid);

            StudentRecord student = StudentDao.getStudentById(id);

            out.print("<form action='/EditServlet2' method='post'>");

            out.print("<table>");

            out.print("<tr><td></td><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");

            out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+student.getName()+"'/></td></tr>");

            out.print("<tr><td>FatherName:</td><td><input type='text' name='fatherName' value='"+student.getFatherName()+"'/></td></tr>");


            out.print("<tr><td>Age:</td><td><input type='age' name='age' value='"+student.getAge()+"'/></td></tr>");

            out.print("<tr><td>Standard:</td><td><input type='standard' name='standard' value='"+student.getStandard()+"'/></td></tr>");

            out.print("</td></tr>");
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
            out.print("</table>");
            out.print("</form>");

            out.close();
        }
    }


