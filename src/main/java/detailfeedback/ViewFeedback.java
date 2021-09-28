package detailfeedback;




import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewFeedback")  
public class ViewFeedback extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
        out.println("<h1>Users Feedback Detail</h1>");  
          
        List<Feedback> list=FeedbackDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>User_Id</th><th>Name</th><th>Email</th><th>F_id</th><th>Feedback</th></tr>");  
        for(Feedback f:list){  
         out.print("<tr><td>"+f.getUser_id()+"</td><td>"+f.getName()+"</td>  <td>"+f.getEmail()+"</td><td>"+f.getF_id()+"</td> <td>"+f.getFeedback()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  

