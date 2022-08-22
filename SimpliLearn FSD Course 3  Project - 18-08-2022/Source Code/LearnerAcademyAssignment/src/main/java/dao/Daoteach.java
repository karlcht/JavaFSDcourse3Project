package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Stbean;
import bean.Tbean;
import utility.Dbconnector;

public class Daoteach {

	public List<Tbean> getAllTeachers()
	{
	
		List<Tbean> listOfTeachers= new ArrayList<Tbean>();
		

		try
		{
			Connection con = Dbconnector.getConnection();
			java.sql.Statement stmt = con.createStatement();
			String query = "Select * from subjects";
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Tbean bean = new Tbean();
				bean.setTeacherName(rs.getString(1));
				bean.setTeacherSurname(rs.getString(2));
				listOfTeachers.add(bean);
			
			}
			
			con.close();
			
		}
		
		catch(Exception e)
		{
			
			
		}
		
		
		return listOfTeachers;
		
	}
	
	public boolean insertTeach(Tbean bean)
	{
		boolean insertStatus = false; 
			
		try {
			Connection con = Dbconnector.getConnection();
			String query = "insert into teachers values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(query); 
			pstmt.setString(1, bean.getTeacherName());
			pstmt.setString(2, bean.getTeacherSurname());
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
	
	public int deleteTeachersByName(int name)
	{
		int deleteCount = 0;
		
		try {
			Connection con = Dbconnector.getConnection();
			String query = "delete teachers where name =?";
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
