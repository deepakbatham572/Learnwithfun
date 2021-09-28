package adminlogin;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
          
        String email=request.getParameter("email");  
        String number=request.getParameter("number");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        		
        String file=request.getParameter("file");  
          
        User e=new User();  
        e.setId(id);  
        e.setName(name);  
        e.setEmail(email);  
        e.setNumber(number);  
        e.setPassword(password); 
        e.setAddress(address);  
        e.setFile(file);  
        
        int status=UserDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
