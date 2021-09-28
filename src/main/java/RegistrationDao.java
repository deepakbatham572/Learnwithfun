import java.util.*;  
import java.sql.*;  
  
public class RegistrationDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Registration e){  
        int status=0;  
        try{  
            Connection con=RegistrationDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user1(name,email,number,password,address,file) values (?,?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getNumber());  
            ps.setString(4,e.getPassword());  
            ps.setString(5,e.getAddress());  
            ps.setString(6,e.getFile());  

              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
   
}

