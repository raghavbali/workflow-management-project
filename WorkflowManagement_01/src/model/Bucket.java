package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utility.DBService;
import utility.DBobjects;

public class Bucket {
	int userID;
	int itemID;
	int stageID;
	String assignedDate;
	String deliveryDate;
	String status;
	String lastUpdated;

	public Bucket() {
	}

	public Bucket(int userID, int itemID, int stageID, String assignedDate,
			String deliveryDate, String status,String lastUpdated) {
		super();
		this.userID = userID;
		this.itemID = itemID;
		this.stageID = stageID;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.lastUpdated=lastUpdated;
	}

	public String push(String tableSuffix, int w_id) {

		String selectQueryTable = null;
		String whereClauseTable = null;
		DBobjects dbObject = null;
		ResultSet result;
		int alreadyPresent = 0;
		int insertResult = 0;
		int stageSLA = 0;
		ArrayList<String> values = new ArrayList<String>();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date dNow = new Date();
		String insertQuery = "INSERT INTO `leader_bucket"
				+ tableSuffix
				+ "`(`user_id`, `item_id`, `stage_id`, `assigned_on`, `delivery_date`, `status`,`last_updated`)"
				+ " VALUES (?,?,?,?,?,?,?)";
		System.out.println("insert query\n" + insertQuery);

		/* check if item was already pushed */
		selectQueryTable = "SELECT count(*) FROM leader_bucket" + tableSuffix;
		whereClauseTable = "WHERE item_id = " + this.getItemID();
		try {
			dbObject = DBService.dbExecuteQuery(selectQueryTable,
					whereClauseTable);
			result = dbObject.getResult();
			while (result.next()) {
				alreadyPresent = result.getInt(1);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (alreadyPresent == 1)
			return "presentAlready";
		else {

			/* fetch the First stage and SLA of the workflow */
			selectQueryTable = "SELECT stage_id,stage_sla FROM workflow"
					+ tableSuffix;
			whereClauseTable = "WHERE w_id = " + w_id
					+ " HAVING MIN(stage_seqno)";
			try {
				dbObject = DBService.dbExecuteQuery(selectQueryTable,
						whereClauseTable);
				result = dbObject.getResult();
				while (result.next()) {
					this.setStageID(result.getInt(1));
					stageSLA = result.getInt(2);
				}
				dbObject.getConn().close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			/* fetch the Stage Lead ID */
			selectQueryTable = "SELECT stage_lead_id FROM workflow"
					+ tableSuffix;
			whereClauseTable = " WHERE stage_id = " + this.getStageID();
			try {
				dbObject = DBService.dbExecuteQuery(selectQueryTable,
						whereClauseTable);
				result = dbObject.getResult();
				while (result.next()) {
					this.setUserID(result.getInt("stage_lead_id"));
				}
				dbObject.getConn().close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			/* set to and from dates */
			this.setAssignedDate(ft.format(dNow).toString());
			this.setLastUpdated(ft.format(dNow).toString());
			dNow.setDate(dNow.getDate() + stageSLA);
			this.setDeliveryDate(ft.format(dNow).toString());

			/* add values for insertion */
			values.add(String.valueOf(this.getUserID()));
			values.add(String.valueOf(this.getItemID()));
			values.add(String.valueOf(this.getStageID()));
			values.add(this.getAssignedDate());
			values.add(this.getDeliveryDate());
			values.add("I");// all items begin at Incomplete stage
			values.add(this.getLastUpdated());

			insertResult = DBService.insertObjectInDB(insertQuery, values);

			if (insertResult == 0) {
				return "error";
			} else {
				return "success";
			}
		}
	}
	
	
	public static ArrayList<Bucket> find(String tableName, String whereClause) {
		ResultSet result = null;
		ArrayList<Bucket> objBucketView = new ArrayList<Bucket>();
		DBobjects dbObject=null;
		
		String selectQuery = "SELECT `user_id`, `item_id`, `stage_id`, `assigned_on`, `delivery_date`, `status`,`last_updated` FROM "+tableName;
		
		try {
			dbObject = DBService.dbExecuteQuery(selectQuery, whereClause);
			result=dbObject.getResult();
			while (result.next()) {
				Bucket newItem = new Bucket();
				newItem.setUserID(result.getInt("user_id"));
				newItem.setItemID(result.getInt("item_id"));
				newItem.setStageID(result.getInt("stage_id"));
				newItem.setAssignedDate(result.getString("assigned_on"));
				newItem.setDeliveryDate(result.getString("delivery_date"));
				newItem.setStatus(result.getString("status"));
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
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
