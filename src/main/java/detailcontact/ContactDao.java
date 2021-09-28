package detailcontact;


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
     
    public static List<Contact> getAllEmployees(){  
        List<Contact> list=new ArrayList<Contact>();  
          
        try{  
            Connection con=ContactDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from contact");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Contact c=new Contact();  
                c.setUser_id(rs.getString(1));  
                c.setName(rs.getString(2));  
                c.setEmail(rs.getString(3));  
                c.setNumber(rs.getString(4));  
                c.setMessage(rs.getString(5)); 
                c.setContact_id(rs.getString(6));   
                list.add(c);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}


