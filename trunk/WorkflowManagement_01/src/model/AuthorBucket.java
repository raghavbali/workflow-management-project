package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;
import utility.MySqlConnection;

public class AuthorBucket extends Bucket {
	private int stageLeadID;

	public AuthorBucket() {
		super();
	}

	public AuthorBucket(int userID, int itemID, int stageID,
			String assignedDate, String deliveryDate, String status,
			String lastUpdated, int stageLeadID) {
		super(userID, itemID, stageID, assignedDate, deliveryDate, status,
				lastUpdated);
		this.stageLeadID = stageLeadID;
	}

	public static ArrayList<AuthorBucket> findAuthorBucket(String tableName,
			String whereClause) {
		ResultSet result = null;
		ArrayList<AuthorBucket> objBucketView = new ArrayList<AuthorBucket>();
		DBobjects dbObject = null;

		String selectQuery = "SELECT `user_id`, `item_id`, `stage_id`, `assigned_on`, `delivery_date`, `status`, `stage_lead_id`,`last_updated` FROM "
				+ tableName;

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result = dbObject.getResult();
			while (result.next()) {
				AuthorBucket newItem = new AuthorBucket();
				newItem.setUserID(result.getInt("user_id"));
				newItem.setItemID(result.getInt("item_id"));
				newItem.setStageID(result.getInt("stage_id"));
				newItem.setAssignedDate(result.getString("assigned_on"));
				newItem.setDeliveryDate(result.getString("delivery_date"));
				newItem.setStatus(result.getString("status"));
				newItem.setStageLeadID(result.getInt("stage_lead_id"));
				newItem.setLastUpdated(result.getString("last_updated"));
				objBucketView.add(newItem);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objBucketView;
	}
	
	public static ArrayList<String> find(int stageID, int itemID, int w_id, String selectCol, String whereClause) {
		ResultSet result = null;
		ArrayList<String> stageDetails = new ArrayList<String>();
		String tableName="general_bucket";
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
		String selectQuery = "SELECT `" + selectCol + "` FROM "+tableName+ " WHERE stage_id = '" + stageID + "' AND item_id = '" + itemID + "'";

		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				String str = result.getString(selectCol);
				stageDetails.add(str);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return stageDetails;

	}
	
	public int update(String tableName) {

		String updateSQL = null;

		updateSQL = "UPDATE " + tableName + " SET status='" + this.getStatus()
				+ "',last_updated='"+this.getLastUpdated()+"'  WHERE item_id=" + this.getItemID()+" AND user_id="+this.getUserID()+" AND stage_id="+this.getStageID();
		System.out.println("update :\n" + updateSQL);
		return DBService.DDLQueryInDB(updateSQL);
	}
	
public static int assign(int workflowID, ArrayList<String> params, int delete_flag) {
		
		int result = 0;
		Connection conn=null;
		PreparedStatement pst = null;
		
		String tableName="general_bucket";
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
				pst=conn.prepareStatement("DELETE FROM " + tableName + " WHERE stage_id = '" + params.get(2) + "' AND item_id = '" + params.get(1) + "'");
				
				result = pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				result =0;
			}
		}
		
		if(!params.get(0).equals("")){
		
			try {
				int i=1;
				conn= new MySqlConnection().getConnection();
				pst=conn.prepareStatement("INSERT INTO " + tableName + " (`user_id`, `item_id`, `stage_id`, `assigned_on`, `delivery_date`, `status`, `last_updated`, `stage_lead_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				for (String string : params) {
					pst.setString(i, string);
					i++;
				}
						
				result = pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				result =0;
			}
		}
		return result;
	}

	public int getStageLeadID() {
		return stageLeadID;
	}

	public void setStageLeadID(int stageLeadID) {
		this.stageLeadID = stageLeadID;
	}

}
