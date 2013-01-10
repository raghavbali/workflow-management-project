package action;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import utility.DBService;
import utility.DBobjects;

import model.Item;
import model.WorkflowDetails;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ItemConsole extends ActionSupport{
	
	private int itemID;
	private String itemName;
	private String itemDescription;
	private int currentStageID;
	private String remarks;
	private String filePath;
	private String tableName;
	private int workflowID;
	private Map<String, Object> session;
	private List<Item> itemList;
	
	
	public String addToWorkflow(){
		Item insertItem=new Item(this.getItemID(), this.getItemName(), this.getItemDescription(), 1/*initial stage is selected inside the insert method*/, this.getRemarks(), this.getFilePath());
		if(Item.insertInDB(insertItem, this.getWorkflowID())==1){
			addActionMessage(getText("Item created Successfully."));
			loadList();
			return "addSuccess";
		}
		else{
			addActionError(getText("Could not create Item. Try Again"));
			return "addError";
		}
	}
	
	public String editToWorkflow(){
		Item updatedItem=new Item(this.getItemID(), this.getItemName(), this.getItemDescription(), this.getCurrentStageID(), this.getRemarks(), this.getFilePath());
		
		session = ActionContext.getContext().getSession();
		
		if(updatedItem.update("item"+String.valueOf(session.get("tableSuffix")).toString()/*this.getWorkflowID()*/)==1){
			addActionMessage(getText("Item updated Successfully."));
			loadList();
			return "editSuccess";
		}
		else{
			addActionError(getText("Could not update Item. Try Again"));
			return "editIError";
		}
	}
	
	public String deleteToWorkflow(){
		session = ActionContext.getContext().getSession();
		Item deleteItem=new Item();
		deleteItem.setItemID(this.getItemID());
		String resultMessage=deleteItem.delete(session.get("tableSuffix").toString());
		
		if(resultMessage.equalsIgnoreCase("deleted")){
			addActionMessage(getText("Item deleted Successfully."));
			loadList();
			return "deleteSuccess";
		}
		else{
			addActionError(getText("Could not delete Item. It was already pushed"));
			loadList();
			return "deleteError";
		}
	}
	
	public String backToWorkflow(){
		loadList();
		return "back";
	}
	
	public void loadList(){
		session = ActionContext.getContext().getSession();
		this.setItemList(Item.find("item"+String.valueOf(session.get("tableSuffix")).toString()/*this.getWorkflowID()*/,""));
		//return "editItems";
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

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	

}
