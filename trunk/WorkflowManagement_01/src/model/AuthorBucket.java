package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import utility.DBService;
import utility.DBobjects;

public class AuthorBucket extends Bucket {
	private int stageLeadID;
	

	public AuthorBucket() {
		super();
	}
	
	
	public AuthorBucket(int userID, int itemID, int stageID,
			String assignedDate, String deliveryDate, String status,
			int stageLeadID) {
		super(userID, itemID, stageID, assignedDate, deliveryDate, status);
		this.stageLeadID = stageLeadID;
	}


	public static ArrayList<AuthorBucket> findAuthorBucket(String tableName, String whereClause) {
		ResultSet result = null;
		ArrayList<AuthorBucket> objBucketView = new ArrayList<AuthorBucket>();
		DBobjects dbObject=null;
		
		String selectQuery = "SELECT `user_id`, `item_id`, `stage_id`, `assigned_on`, `delivery_date`, `status`, `stage_lead_id` FROM "+tableName;
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				AuthorBucket newItem = new AuthorBucket();
				newItem.setUserID(result.getInt("user_id"));
				newItem.setItemID(result.getInt("item_id"));
				newItem.setStageID(result.getInt("stage_id"));
				newItem.setAssignedDate(result.getString("assigned_on"));
				newItem.setDeliveryDate(result.getString("delivery_date"));
				newItem.setStatus(result.getString("status"));
				newItem.setStageLeadID(result.getInt("stage_lead_id"));
				objBucketView.add(newItem);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objBucketView;
	}


	public int getStageLeadID() {
		return stageLeadID;
	}

	public void setStageLeadID(int stageLeadID) {
		this.stageLeadID = stageLeadID;
	}

}
