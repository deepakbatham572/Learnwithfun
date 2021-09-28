package courseregister;


import java.util.*;  
import java.sql.*;  
  
public class CourseRegisterDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(CourseRegister k){  
        int status=0;  
        try{  
            Connection con=CourseRegisterDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into addcourse(id,coursename,yourname) values (?,?,?)");  

            ps.setString(1,k.getId());  
            ps.setString(2,k.getCoursename());  
            ps.setString(3,k.getYourname());  
            


           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
   
}