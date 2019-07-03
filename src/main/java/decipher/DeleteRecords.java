package decipher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRecords extends HttpServlet
    {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException
        {
            int id=Integer.parseInt(request.getParameter("id"));
            StudentDao.delete(id);
            response.sendRedirect("ViewServlet");
        }
    }

