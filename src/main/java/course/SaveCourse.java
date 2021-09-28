package course;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SaveCourse extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String course_id=request.getParameter("course_id");  
        String c_name=request.getParameter("c_name");  
        String c_desp=request.getParameter("c_desp");  
        String c_fees=request.getParameter("c_fees");  
        String c_resource=request.getParameter("c_resource");  

        
         

          
        Course w=new Course();  
    
       
        w.setCourse_id(course_id);  
        w.setC_name(c_name);  
        w.setC_desp(c_desp);  
        w.setC_fees(c_fees);
        w.setC_resource(c_resource);

      
        
        
        int status=CourseDao.save(w);  
        if(status>0){  
              
            out.print("<p>Thankyou for your Registraion. <p>" ); 
            

            request.getRequestDispatcher("course.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to Register");  
        }  
          
        out.close();  
    }  
  
}  