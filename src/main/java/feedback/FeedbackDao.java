package feedback;

import java.util.*;  
import java.sql.*;  
  
public class FeedbackDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Feedback f){  
        int status=0;  
        try{  
            Connection con=FeedbackDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into feedback(user_id,name,email,f_id,feedback) values (?,?,?,?,?)");  
            ps.setString(1,f.getUser_id());
            ps.setString(2,f.getName());  
            ps.setString(3,f.getEmail());  
            ps.setString(4,f.getF_id());  
            ps.setString(5,f.getFeedback());

           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
   
}