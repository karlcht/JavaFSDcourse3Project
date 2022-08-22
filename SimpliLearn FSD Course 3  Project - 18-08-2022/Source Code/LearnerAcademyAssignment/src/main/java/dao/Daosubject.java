package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subean;
import utility.Dbconnector;

public class Daosubject {

	public List<Subean> getAllSubjects()
	{
	
		List<Subean> listOfSubjects = new ArrayList<Subean>();
		

		try
		{
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from subjects";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Subean bean = new Subean();
				bean.setSubjectName(rs.getString(1));
				bean.setSubjectCode(rs.getString(2));
				listOfSubjects.add(bean);
			
			}
			
			con.close();
			
		}
		
		catch(Exception e)
		{
			
			
		}
		
		
		return listOfSubjects;
		
	}
	
	public boolean insertSubject(Subean bean)
	{
		boolean insertStatus = false; 
			
		try {
			Connection con = Dbconnector.getConnection();
			String query = "insert into subjects values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(query); 
			pstmt.setString(1, bean.getSubjectName());
			pstmt.setString(2, bean.getSubjectCode());
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
	
	public int deleteSubjectByName(int name)
	{
		int deleteCount = 0;
		
		try {
			Connection con = Dbconnector.getConnection();
			String query = "delete subjects where name =?";
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
