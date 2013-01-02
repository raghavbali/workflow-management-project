package action;

import com.opensymphony.xwork2.ActionSupport;

public class ItemConsole extends ActionSupport{
	
	private int itemID;
	private String itemName;
	private String itemDescription;
	private int currentStageID;
	private String remarks;
	private String filePath;
	private String tableName;
	private String workflowID;
	
	/*
	public String addToWorkflow(){
		
	}
	*/
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
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getCurrentStageID() {
		return currentStageID;
	}
	public void setCurrentStageID(int currentStageID) {
		this.currentStageID = currentStageID;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(String workflowID) {
		this.workflowID = workflowID;
	}
	

}
