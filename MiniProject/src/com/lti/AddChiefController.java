package com.lti;
import java.sql.*;

public class AddChiefController {
	DatabaseConnector db=new DatabaseConnector();
	CM cm =null;
	
//	String email=u.getEmail();
	//String emailD="";
	//String password=u.getPassword();
	//String passwordD="";
	
	public String addChief(CM cm)
	{
		String result="";
		
		try
		{
			String query="Insert into chiefminister values (?,?,?,?,?,?)";
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(1,cm.getCid());
			pstmt.setString(2, cm.getCname());
			pstmt.setString(3,cm.getQuali());
			pstmt.setString(4, cm.getState());
			pstmt.setString(5, cm.getEnddate());
			pstmt.setString(6, cm.getParty());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	
	
}
