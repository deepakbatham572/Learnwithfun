package courseregister;



import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SaveCourseRegister extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String id=request.getParameter("id");  
        String coursename=request.getParameter("coursename");  
        String yourname=request.getParameter("yourname");  
        

        
         

          
        CourseRegister k=new CourseRegister();  
    
       
        k.setId(id);  
        k.setCoursename(coursename);  
        k.setYourname(yourname);  
     

      
        
        
        int status=CourseRegisterDao.save(k);  
        if(status>0){  
              
            out.print("<p>Thankyou for your Registraion. <p>" ); 
            

            request.getRequestDispatcher("add.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to Register");  
        }  
          
        out.close();  
    }  
  
}  
