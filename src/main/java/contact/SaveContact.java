package contact;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SaveContact extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String user_id=request.getParameter("user_id");  

        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String number=request.getParameter("number");  
        String message=request.getParameter("Message");  
        String contact_id=request.getParameter("Contact_id");  
        
         

          
        Contact c=new Contact();  
    
        c.setUser_id(user_id);
        c.setName(name);  
        c.setEmail(email);  
        c.setNumber(number);  
        c.setMessage(message);
        c.setContact_id(contact_id);
      
        
        
        int status=ContactDao.save(c);  
        if(status>0){  
              
            out.print("<p>Thankyou for contact, Our team will reach soon.<p>" ); 
            

            request.getRequestDispatcher("contact.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  
