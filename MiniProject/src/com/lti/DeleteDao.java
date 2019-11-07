package com.lti;
import java.sql.*;

public class DeleteDao {
	
	DatabaseConnector db=new DatabaseConnector();
	CM cm =null;
	
	public String deleteChief(CM cm)
	{
		String result="";
		
		try
		{
			String query="delete from chiefminister where state=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setString(1,cm.getState());
			
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
