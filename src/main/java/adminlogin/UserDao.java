package adminlogin;

import java.util.*;  
import java.sql.*;  
  
public class UserDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
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
   
    public static int update(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user1 set name=?,email=?,number=?,password=?,address=?,file=? where id=?");  
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
    public static int delete(int user_id){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user1 where user_id=?");  
            ps.setInt(1,user_id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static User getEmployeeById(int id){  
        User e=new User();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user1 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setNumber(rs.getString(4));  
                e.setPassword(rs.getString(5)); 
                e.setAddress(rs.getString(6));  
                e.setFile(rs.getString(7));  

            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<User> getAllEmployees(){  
        List<User> list=new ArrayList<User>();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user1");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                User e=new User();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setNumber(rs.getString(4));  
                e.setPassword(rs.getString(5)); 
                e.setAddress(rs.getString(6));  
                e.setFile(rs.getString(7));    
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}

