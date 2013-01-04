package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;

public class StageDetails {
	
	private int stageID;
	private int userID;
		
	public StageDetails(){
		
	}

	public StageDetails(int stageID, int userID) {
		this.stageID = stageID;
		this.userID = userID;
	}
	
	public static ArrayList<StageDetails> find(int stageID, int w_id, String whereClause) {
		ResultSet result = null;
		ArrayList<StageDetails> stageDetails = new ArrayList<StageDetails>();
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
		String selectQuery = "SELECT `stage_id`, `user_id` FROM "+tableName;

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				StageDetails newStageDetails = new StageDetails();
				newStageDetails.setStageID(result.getInt("stage_id"));
				newStageDetails.setUserID(result.getInt("user_id"));
//				newStageDetails.setTableName(tableName);
				stageDetails.add(newStageDetails);
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

}