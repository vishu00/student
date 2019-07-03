package decipher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;



        public class SaveRecords extends HttpServlet
        {
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException //handles the POST request. It is invoked by the web container.

            {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();


                String name = request.getParameter("name");
                String fatherName = request.getParameter("fatherName");
                int age = Integer.parseInt(request.getParameter("age"));
                int standard = Integer.parseInt(request.getParameter("standard"));


                StudentRecord student = new StudentRecord();

                student.setName(name);
                student.setFatherName(fatherName);
                student.setAge(age);
                student.setStandard(standard);


                int status = StudentDao.save(student);
                if (status > 0)
                {
                     out.print("<p style='color:red;'>Record saved successfully!</p>");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
                else
                    {
                    out.println("Sorry unable to save record");
                }
                out.close();

            }
        }


