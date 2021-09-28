package adminlogin;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
        out.println("<h1>Users List</h1>");  
          
        List<User> list=UserDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Number</th><th>Email</th><th>Address</th> <th>Password</th><th>File</th></tr>");  
        for(User e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td>  <td>"+e.getEmail()+"</td><td>"+e.getNumber()+"</td> <td>"+e.getPassword()+"</td><td>"+e.getAddress()+"</td> <td>"+e.getFile()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  