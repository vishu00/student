package decipher;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class UpdateRecords extends HttpServlet
{
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();

            String sid=request.getParameter("id");
            int id=Integer.parseInt(sid);

            String name=request.getParameter("name");

            String fatherName=request.getParameter("fatherName");

            int age = Integer.parseInt(request.getParameter("age"));

            int standard = Integer.parseInt(request.getParameter("standard"));


            StudentRecord student=new StudentRecord();
            student.setId(id);
            student.setName(name);
            student.setFatherName(fatherName);
            student.setAge(age);
            student.setStandard(standard);

            int status=StudentDao.update(student);

            if(status>0){
                response.sendRedirect("ViewServlet");
            }else{
                out.println("Sorry! unable to update record");
            }

            out.close();
        }

    }

