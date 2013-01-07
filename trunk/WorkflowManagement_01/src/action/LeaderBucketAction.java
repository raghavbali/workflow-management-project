package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;
import utility.DBobjects;

import model.Bucket;

public class LeaderBucketAction extends ActionSupport{

	int userID;
	int itemID;
	String itemName;
	int stageID;
	String stageName;
	String assignedDate;
	String deliveryDate;
	String lastUpdated;
	String status;
	String leaf;
	int daysLeft;
	int workflowID;
	private Map<String, Object> session;
	private ArrayList<LeaderBucketAction> objBucketView;

	public LeaderBucketAction() {

	}

	public LeaderBucketAction(int userID, int itemID, int stageID,
			String assignedDate, String deliveryDate, String status,String lastUpdated) {
		this.userID = userID;
		this.itemID = itemID;
		this.stageID = stageID;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.lastUpdated=lastUpdated;
	}

	public LeaderBucketAction(int userID, int itemID, String itemName, int stageID,
			String stageName, String assignedDate, String deliveryDate,
			String status,String lastUpdated, int daysLeft) {
		this.userID = userID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.stageID = stageID;
		this.stageName = stageName;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.daysLeft = daysLeft;
		this.lastUpdated=lastUpdated;
	}
	
	public String execute(){
		return this.displayList();
	}

	public String displayList() {
		session = ActionContext.getContext().getSession();
		this.setUserID(Integer.parseInt(session.get("userID").toString()));
		this.setObjBucketView(this.find(String.valueOf(session.get("tableSuffix")).toString()));
		if(this.getObjBucketView()!=null){
			addActionMessage(getText("Mailbox ready"));
			return "displaySuccess";
		}
		else{
			addActionError(getText("Could not fetch data. Contact Network/Sys Admin"));
			return "displayError";
		}

	}

	public ArrayList<LeaderBucketAction> find(String tableSuffix) {
		ResultSet result = null;
		ArrayList<LeaderBucketAction> bucketView = new ArrayList<LeaderBucketAction>();
		DBobjects dbObject = null;

		String selectQuery = "SELECT w.`stage_lead_id` as user_id, i.`item_id` as item_id, i.`item_name` as item_name, i.`current_stage_id` as stage_id, w.`stage_name` as stage_name, l.`assigned_on` as assigned_on, l.`delivery_date` as delivery_date, l.`status` as status,DATEDIFF(l.delivery_date,l.assigned_on) as daysLeft,l.`last_updated` as lastUpdated ";
		String fromClause = " FROM `item" + tableSuffix + "` i, `workflow"
				+ tableSuffix + "` w, `leader_bucket" + tableSuffix + "` l ";
		String whereClause = " WHERE i.current_stage_id=w.stage_id AND i.item_id=l.item_id AND w.stage_lead_id=l.user_id AND l.user_id="+this.getUserID();
		try {
			dbObject = DBService.dbExecuteQuery(selectQuery+fromClause, whereClause);
			result = dbObject.getResult();
			while (result.next()) {
				LeaderBucketAction newItem = new LeaderBucketAction();
				newItem.setUserID(result.getInt("user_id"));
				newItem.setItemID(result.getInt("item_id"));
				newItem.setStageID(result.getInt("stage_id"));
				newItem.setAssignedDate(result.getString("assigned_on"));
				newItem.setDeliveryDate(result.getString("delivery_date"));
				newItem.setStatus(result.getString("status"));
				newItem.setItemName(result.getString("item_name"));
				newItem.setStageName(result.getString("stage_name"));
				newItem.setDaysLeft(result.getInt("daysLeft"));
				newItem.setLastUpdated(result.getString("lastUpdated"));
				bucketView.add(newItem);
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bucketView;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
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

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public ArrayList<LeaderBucketAction> getObjBucketView() {
		return objBucketView;
	}

	public void setObjBucketView(ArrayList<LeaderBucketAction> objBucketView) {
		this.objBucketView = objBucketView;
	}
}