package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cbean;
import bean.LearnersBean;
import utility.Dbconnector;

public class DaoLearners {

	/*
	 * public static void main(String [] args) {
	 * 
	 * DaoLearners std = new DaoLearners(); LearnersBean bean = new LearnersBean();
	 * bean.setClassroom("Ass"); bean.setStudentName("Thomas");
	 * bean.setTeacherName("Miss");
	 * 
	 * Boolean listOflearners =std.insertAll(bean);
	 * System.out.println(listOflearners);
	 * 
	 * 
	 * for (LearnersBean bean1:bean) {
	 * 
	 * System.out.println(bean1.getClassroom() + " & name: " +
	 * bean.getStudentSurname());
	 * 
	 * 
	 * }
	 */

	public List<LearnersBean> getAll() {

		List<LearnersBean> listOfTable = new ArrayList<LearnersBean>();

		// Always initialise the variable prior to using it !!!!!
		// Else you will run the risk of it having a value and executing a false
		// positive !!

		//listOfTable = null;

		try {
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from Learners";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				LearnersBean bean = new LearnersBean();
				bean.setClassroom(rs.getString(1));
				;
				bean.setSubject(rs.getString(2));
				bean.setTeacherName(rs.getString(3));
				bean.setTeacherSurname(rs.getString(4));
				bean.setStudentName(rs.getString(5));
				bean.setStudentSurName(rs.getString(6));
				listOfTable.add(bean);

			}
			
			if(listOfTable.isEmpty())
			{
				listOfTable = null;
			}
			
			con.close();

		}

		catch (Exception e) {

		}

		return listOfTable;

	}

	public boolean insertAll(LearnersBean bean) {
		boolean insertStatus = false;

		try {
			Connection con = Dbconnector.getConnection();
			String query = "insert into Learners values (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getClassroom());
			pstmt.setString(2, bean.getSubject());
			pstmt.setString(3, bean.getTeacherName());
			pstmt.setString(4, bean.getTeacherSurname());
			pstmt.setString(5, bean.getStudentName());
			pstmt.setString(6, bean.getStudentSurName());
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

	public int deleteClassByName(String name, String surname) {
		int deleteCount = 0;

		try {
			Connection con = Dbconnector.getConnection();
			String query = "delete Learners where StudentName =? And STUDENTSURNAME =?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, surname);
			deleteCount = pstmt.executeUpdate();
			System.out.println("Rows impacted: " + deleteCount);
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return deleteCount;

	}

	public LearnersBean searchLearnersByName(String name, String surname) {
		
		
		LearnersBean bean = new LearnersBean();

		try {
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "SELECT * FROM Learners WHERE STUDENTNAME='"+name+"' AND  STUDENTSURNAME ='"+surname+"'";
			stmt.execute(query);
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
			{
				bean.setClassroom(rs.getString(1));
				bean.setSubject(rs.getString(2));
				bean.setTeacherName(rs.getString(3));
				bean.setTeacherSurname(rs.getString(4));
				bean.setStudentName(rs.getString(5));
				bean.setStudentSurName(rs.getString(6));
				
			}
			
			else
			{
				bean = null;
			}
			System.out.println(bean.getClassroom() + bean.getStudentName() + bean.getStudentSurName());
		
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return bean;

	}
	
}
