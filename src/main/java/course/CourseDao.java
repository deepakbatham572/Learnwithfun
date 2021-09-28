package course;

import java.util.*;  
import java.sql.*;  
  
public class CourseDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Course w){  
        int status=0;  
        try{  
            Connection con=CourseDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into course(course_id,c_name,c_desp,c_fees,c_resource) values (?,?,?,?,?)");  

            ps.setString(1,w.getCourse_id());  
            ps.setString(2,w.getC_name());  
            ps.setString(3,w.getC_desp());  
            ps.setString(4,w.getC_fees());
            ps.setString(5,w.getC_resource());


           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
   
}