package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cbean;
import bean.Stbean;
import utility.Dbconnector;

public class Daoclass {

	
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * Daoclass class1 = new Daoclass(); // Cbean bean = new Cbean(); List<Cbean>
	 * List<Cbean> listofclasses = class1.getAllClasses();
	 * 
	 * for(Cbean bean: listofclasses) {
	 * 
	 * System.out.println(bean.getClassName()); }
	 * 
	 * 
	 * }
	 */
	 

	public List<Cbean> getAllClasses() {

		List<Cbean> listOfClasses = new ArrayList<Cbean>();

		try {
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from classes";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cbean bean = new Cbean();
				bean.setClassName(rs.getString(1));
				listOfClasses.add(bean);
				

			}

			con.close();

		}

		catch (Exception e) {

		}

		return listOfClasses;

	}

	public boolean insertClass(Cbean bean) {
		boolean insertStatus = false;

		try {
			Connection con = Dbconnector.getConnection();
			String query = "insert into classes values (?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getClassName());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				insertStatus = true;
			}

			System.out.println("Rows impacted: " + count);
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return insertStatus;

	}

	public int deleteClassByName(String name) {
		int deleteCount = 0;

		try {
			Connection con = Dbconnector.getConnection();
			String query = "delete classes where name =?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			deleteCount = pstmt.executeUpdate();
			System.out.println("Rows impacted: " + deleteCount);
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return deleteCount;

	}

}
