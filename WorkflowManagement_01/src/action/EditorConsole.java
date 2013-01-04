package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;

import model.Item;
import model.User;
import model.WorkflowDetails;

public class EditorConsole extends ActionSupport {
	
	private List<WorkflowDetails> stageList;
	private List<User> userList;
	private List<Item> itemList;
	private int itemID;
	private int workflowID;
	private ArrayList<User> usrlist;
	private String pageName;
	
	public String done(){	
		return "done";
	}
	
	public String assignStage(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		return "assignStage";
	}
	
	
	public String createItem(){
		return "createItem";
	}
	
	public String editItem(){
		this.setItemList(Item.find(this.getWorkflowID(),"where item_id="+this.getItemID()));
		return "editItem";
	}
	
	public String editItems(){
		this.setItemList(Item.find(this.getWorkflowID(),""));
		return "editItems";
	}
	
	public String assignRole(){
		pageName = "EditorConsole";
		usrlist = DBService.getUserList();
		if(usrlist != null){
			addActionMessage(getText("Userlist generated."));
		}
		
		else{
			addActionError(getText("No users found."));
		}
		return "assignRole";
	}
	
	
	public String editProfile(){
		return "editProfile";
	}
	
	public List<WorkflowDetails> getStageList() {
		return stageList;
	}
	public void setStageList(List<WorkflowDetails> stageList) {
		this.stageList = stageList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
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


	public int getItemID() {
		return itemID;
	}


	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public ArrayList<User> getUsrlist() {
		return usrlist;
	}

	public void setUsrlist(ArrayList<User> usrlist) {
		this.usrlist = usrlist;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
}
