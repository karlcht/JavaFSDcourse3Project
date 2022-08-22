package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Stbean;
import utility.Dbconnector;


public class Daostudent {
	
	/*
	 * public static void main(String [] args) {
	 * 
	 * Daostudent std = new Daostudent(); List<Stbean> listOfStudents =
	 * std.getAllStudents(); for (Stbean bean:listOfStudents) {
	 * System.out.println(bean.getStudentName() + " & name: " +
	 * bean.getStudentSurname()); }
	 * 
	 * }
	 */
	
	

	public List<Stbean> getAllStudents()
	{
	
		List<Stbean> listOfStudents = new ArrayList<Stbean>();
		

		try
		{
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from students";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Stbean bean = new Stbean();
				bean.setStudentName(rs.getString(1));
				bean.setStudentSurname(rs.getString(2));
				listOfStudents.add(bean);
				
				
			
			}
			
			con.close();
			
		}
		
		catch(Exception e)
		{
			
			
		}
		
		
		return listOfStudents;
		
	}
	
	public boolean insertStudent(Stbean bean)
	{
		boolean insertStatus = false; 
			
		try {
			Connection con = Dbconnector.getConnection();
			String query = "insert into students values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(query); 
			pstmt.setString(1, bean.getStudentName());
			pstmt.setString(2, bean.getStudentSurname());
			int count = pstmt.executeUpdate();
			if(count>0)
				{
				insertStatus = true;
				}
			
			System.out.println("Rows impacted: " + count);
			con.close();
				}
		
		
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
				return insertStatus;
				
		}
	
	public int deleteStudentByName(int name)
	{
		int deleteCount = 0;
		
		try {
			Connection con = Dbconnector.getConnection();
			String query = "delete students where name =?";
			PreparedStatement pstmt = con.prepareStatement(query); 
			pstmt.setInt(1, name);
			deleteCount = pstmt.executeUpdate();
			System.out.println("Rows impacted: " + deleteCount);
			con.close();
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
			return deleteCount;
			
	}
		
	
}
