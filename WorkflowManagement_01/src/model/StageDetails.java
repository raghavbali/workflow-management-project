package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utility.DBService;
import utility.DBobjects;
import utility.MySqlConnection;

public class StageDetails {
	
	private int stageID;
	private int userID;
		
	public StageDetails(){
		
	}

	public StageDetails(int stageID, int userID) {
		this.stageID = stageID;
		this.userID = userID;
	}
	
	public static ArrayList<String> find(int stageID, int w_id, String whereClause) {
		ResultSet result = null;
		ArrayList<String> stageDetails = new ArrayList<String>();
		String tableName="stage";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject;
		
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+w_id;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableName = tableName+resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String selectQuery = "SELECT `user_id` FROM "+tableName+ " WHERE stage_id = '" + stageID + "'";

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				String str = result.getString("user_id");
//				StageDetails newStageDetails = new StageDetails();
//				newStageDetails.setStageID(result.getInt("stage_id"));
//				newStageDetails.setUserID(result.getInt("user_id"));
//				newStageDetails.setTableName(tableName);
				stageDetails.add(str);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return stageDetails;

	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public static int assign(int workflowID, int stageID, String user_id, int delete_flag) {
		
		int result = 0;
		Connection conn=null;
		PreparedStatement pst = null;
		
		String tableName="stage";
		ResultSet resultTableName = null;
		String selectQueryTable=null;
		String whereClauseTable=null;
		DBobjects dbObject;
		
		
		selectQueryTable = "SELECT table_suffix FROM workflow_master ";
		whereClauseTable = "where w_id = "+ workflowID;
		
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable, whereClauseTable);
			resultTableName=dbObject.getResult();
			while (resultTableName.next()) {
				tableName = tableName+resultTableName.getString(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(delete_flag == 0){

			try {
				conn= new MySqlConnection().getConnection();
				pst=conn.prepareStatement("DELETE FROM " + tableName + " WHERE stage_id = '" + stageID + "'");
				
				result = pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				result =0;
			}
		}
		
		if(!user_id.equals("")){
		
			try {
				conn= new MySqlConnection().getConnection();
				pst=conn.prepareStatement("INSERT INTO " + tableName + " (`stage_id`, `user_id`) VALUES (?, ?)");
				pst.setInt(1, stageID);
				pst.setInt(2, Integer.parseInt(user_id));
						
				result = pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				result =0;
			}
		}
		return result;
	}
	
	

}