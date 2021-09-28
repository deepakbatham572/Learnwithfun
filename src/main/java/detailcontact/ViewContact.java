package detailcontact;



import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewContact")  
public class ViewContact extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
        out.println("<h1>Users Contact Detail</h1>");  
          
        List<Contact> list=ContactDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>User_Id</th><th>Name</th><th>Email</th><th>Number</th><th>Message</th> <th>Contact_id</th></tr>");  
        for(Contact c:list){  
         out.print("<tr><td>"+c.getUser_id()+"</td><td>"+c.getName()+"</td>  <td>"+c.getEmail()+"</td><td>"+c.getNumber()+"</td> <td>"+c.getMessage()+"</td><td>"+c.getContact_id()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  
