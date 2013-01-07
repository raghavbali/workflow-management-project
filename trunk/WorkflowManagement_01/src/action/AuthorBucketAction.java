package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;
import utility.DBobjects;

import model.AuthorBucket;
import model.Bucket;
import model.Item;

public class AuthorBucketAction extends ActionSupport {

	int userID;
	int itemID;
	String itemName;
	int stageID;
	String stageName;
	String assignedDate;
	String deliveryDate;
	String status;
	String remarks;
	int stageLeadID;
	int daysLeft;
	int workflowID;
	private Map<String, Object> session;
	public List<String> statusOptions;
	private ArrayList<AuthorBucketAction> objBucketView;

	public AuthorBucketAction() {
		statusOptions=new ArrayList<String>();
		statusOptions.add("I");
		statusOptions.add("C");
		statusOptions.add("P");
	}

	public AuthorBucketAction(int userID, int itemID, int stageID,
			String assignedDate, String deliveryDate, String status,
			int stageLeadID) {
		this.userID = userID;
		this.itemID = itemID;
		this.stageID = stageID;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.stageLeadID = stageLeadID;
	}

	public AuthorBucketAction(int userID, int itemID, String itemName,
			int stageID, String stageName, String assignedDate,
			String deliveryDate, String status, int daysLeft, int stageLeadID) {
		this.userID = userID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.stageID = stageID;
		this.stageName = stageName;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.daysLeft = daysLeft;
		this.stageLeadID = stageLeadID;
	}

	public AuthorBucketAction(int userID, int itemID, String itemName,
			int stageID, String stageName, String assignedDate,
			String deliveryDate, String status, String remarks, int stageLeadID) {
		super();
		this.userID = userID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.stageID = stageID;
		this.stageName = stageName;
		this.assignedDate = assignedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.remarks = remarks;
		this.stageLeadID = stageLeadID;
	}

	public String execute() {
		ArrayList<Item> updateItem;
		if (this.getItemID() != 0) {
			session = ActionContext.getContext().getSession();
			updateItem = Item.find("item"+String.valueOf(session.get("tableSuffix").toString()), "WHERE item_id="+this.getItemID());
			this.setRemarks(updateItem.get(0).getRemarks());
		}
		return this.displayList();
	}
	
	public String updateItem(){
		this.setRemarks(null);
		addActionMessage(getText("Coming Soon!!! Item Update yet to be implemented."));
		return this.displayList();
	}

	public String displayList() {
		session = ActionContext.getContext().getSession();

		this.setObjBucketView(this.find(String.valueOf(
				session.get("tableSuffix")).toString()));
		if (this.getObjBucketView() != null) {
			addActionMessage(getText("Mailbox ready"));
			return "displaySuccess";
		} else {
			addActionError(getText("Could not fetch data. Contact Network/Sys Admin"));
			return "displayError";
		}

	}

	public ArrayList<AuthorBucketAction> find(String tableSuffix) {
		ResultSet result = null;
		ArrayList<AuthorBucketAction> bucketView = new ArrayList<AuthorBucketAction>();
		DBobjects dbObject = null;

		String selectQuery = "SELECT  g.`user_id` as user_id, g.`item_id` as item_id, i.`item_name` as item_name, g.`stage_id` as stage_id, w.`stage_name` as stage_name, g.`assigned_on` as assigned_on, g.`delivery_date` as delivery_date, g.`status` as status,DATEDIFF(g.delivery_date,g.assigned_on) as daysLeft,g.`stage_lead_id` as stage_lead_id, i.`remarks` as remarks ";
		String fromClause = " FROM `item" + tableSuffix + "` i, `workflow"
				+ tableSuffix + "` w, `general_bucket" + tableSuffix
				+ "` g, `leader_bucket" + tableSuffix + "` l";
		String whereClause = " WHERE l.user_id=g.stage_lead_id and l.item_id=g.item_id and l.stage_id=g.stage_id and i.item_id=g.item_id and w.stage_id=g.stage_id";
		try {
			dbObject = DBService.dbExecuteQuery(selectQuery + fromClause,
					whereClause);
			result = dbObject.getResult();
			while (result.next()) {
				AuthorBucketAction newItem = new AuthorBucketAction();
				newItem.setUserID(result.getInt("user_id"));
				newItem.setItemID(result.getInt("item_id"));
				newItem.setStageID(result.getInt("stage_id"));
				newItem.setAssignedDate(result.getString("assigned_on"));
				newItem.setDeliveryDate(result.getString("delivery_date"));
				newItem.setStatus(result.getString("status"));
				newItem.setItemName(result.getString("item_name"));
				newItem.setStageName(result.getString("stage_name"));
				newItem.setDaysLeft(result.getInt("daysLeft"));
				newItem.setStageLeadID(result.getInt("stage_lead_id"));
				bucketView.add(newItem);
				newItem.setStageName(result.getString("remarks"));
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

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public int getStageLeadID() {
		return stageLeadID;
	}

	public void setStageLeadID(int stageLeadID) {
		this.stageLeadID = stageLeadID;
	}

	public List<String> getStatusOptions() {
		return statusOptions;
	}

	public void setStatusOptions(List<String> statusOptions) {
		this.statusOptions = statusOptions;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public ArrayList<AuthorBucketAction> getObjBucketView() {
		return objBucketView;
	}

	public void setObjBucketView(ArrayList<AuthorBucketAction> objBucketView) {
		this.objBucketView = objBucketView;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
