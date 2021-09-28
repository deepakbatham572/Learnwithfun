package adminlogin;


	
	import java.io.IOException;  
	import java.io.PrintWriter;  
	  
	import javax.servlet.ServletException;  
	import javax.servlet.annotation.WebServlet;  
	import javax.servlet.http.HttpServlet;  
	import javax.servlet.http.HttpServletRequest;  
	import javax.servlet.http.HttpServletResponse;  
	  
	public class SaveUser extends HttpServlet {  
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        String name=request.getParameter("name");  
	        String email=request.getParameter("email");  
	        String number=request.getParameter("number");  
	        String password=request.getParameter("password");  
	        String address=request.getParameter("address");  
	        String file=request.getParameter("file");  

	          
	        User e=new User();  
	    
	       
	        e.setName(name);  
	        e.setEmail(email);  
	        e.setNumber(number);  
	        e.setPassword(password); 
	        e.setAddress(address);  
	        e.setFile(file);  
	          
	        int status=UserDao.save(e);  
	        if(status>0){  
	            out.print("<h3><h3>");  
	            out.print("<p>Registration successfull !! Please go to login page<p>" ); 
	            

	            request.getRequestDispatcher("signup.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  


