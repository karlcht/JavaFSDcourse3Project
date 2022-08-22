package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import bean.LoginBean;
import utility.Dbconnector;

public class DaoLogin {

	
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * DaoLogin admin = new DaoLogin(); LoginBean bean = new LoginBean();
	 * 
	 * bean = admin.getUserByUserName("Admin");
	 * 
	 * System.out.println(bean.getUsername());
	 * System.out.println(bean.getPassword());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public LoginBean getUserByUserName(String userName) {
		LoginBean bean = new LoginBean();

		try {
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from Learners_login where username =" + "'" + userName + "'";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {

				bean.setUsername(rs.getString(1));
				bean.setPassword(rs.getInt(2));

			} 
			else {
				bean = null;
			}

		}

		catch (Exception e) {

		}

		return bean;

	}

}
