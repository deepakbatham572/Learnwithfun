package detailfeedback;

import java.util.*;

import detailcontact.Contact;
import detailcontact.ContactDao;

import java.sql.*;

public class FeedbackDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/learnwithfun", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static List<Feedback> getAllEmployees() {
		List<Feedback> list = new ArrayList<Feedback>();

		try {
			Connection con = ContactDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from feedback");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Feedback f = new Feedback();

				f.setUser_id(rs.getString(1));
				f.setName(rs.getString(2));
				f.setEmail(rs.getString(3));
				f.setF_id(rs.getString(4));
				f.setFeedback(rs.getString(5));

				list.add(f);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}