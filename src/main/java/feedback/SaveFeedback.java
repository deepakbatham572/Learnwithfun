package feedback;


import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SaveFeedback extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String user_id=request.getParameter("user_id"); 
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String f_id=request.getParameter("f_id");  
        String feedback=request.getParameter("feedback");  
        
         

          
        Feedback f=new Feedback();  
    
        f.setUser_id(user_id);
        f.setName(name);  
        f.setEmail(email);  
        f.setF_id(f_id);  
        f.setFeedback(feedback);
      
        
        
        int status=FeedbackDao.save(f);  
        if(status>0){  
              
            out.print("<p>Thankyou for your support .<p>" ); 
            

            request.getRequestDispatcher("feedback.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  

