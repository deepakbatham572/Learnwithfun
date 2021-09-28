package contact;

import java.util.*;  
import java.sql.*;  
  
public class ContactDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Contact c){  
        int status=0;  
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into contact(user_id,name,email,number,message,contact_id) values (?,?,?,?,?,?)");  
            ps.setString(1,c.getUser_id());  

            ps.setString(2,c.getName());  
            ps.setString(3,c.getEmail());  
            ps.setString(4,c.getNumber());  
            ps.setString(5,c.getMessage());
            ps.setString(6,c.getContact_id());

           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
   
}


