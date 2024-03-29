package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;

import model.Bucket;
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
	private Map<String, Object> session;
	
	public String done(){	
		return "done";
	}
	
	public String assignStage(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		pageName = "showStage";
		return "assignStage";
	}
	
	public String generateReports(){
		return "editorReports";
	}
	
	public String sla(){
		session = ActionContext.getContext().getSession();
		DownloadAction dwn=new DownloadAction();
		try {
			dwn.missingSLA(String.valueOf(session.get("tableSuffix")).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError(getText("Could not generate report. Contact System Admin"));
			//e.printStackTrace();
			return "error";
		}
		addActionMessage(getText("SLA report generated successfully"));
		return "success";
	}
	
	public String resource(){
		session = ActionContext.getContext().getSession();
		DownloadAction dwn=new DownloadAction();
		try {
			dwn.resourceChart(Integer.parseInt(session.get("workflowID").toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError(getText("Could not generate report. Contact System Admin"));
			return "error";
		}
		addActionMessage(getText("Resource Allocation report generated successfully"));
		return "success";
	}
	
	public String item(){
		session = ActionContext.getContext().getSession();
		DownloadAction dwn=new DownloadAction();
		try {
			dwn.itemsPerStage(String.valueOf(session.get("tableSuffix")).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError(getText("Could not generate report. Contact System Admin"));
			e.printStackTrace();
			return "error";
		}
		addActionMessage(getText("Items per Stage report generated successfully"));
		return "success";
	}
	
	
	public String createItem(){
		return "createItem";
	}
	
	public String pushItem(){
		session = ActionContext.getContext().getSession();
		String pushResult=null;
		Bucket leaderBucket=new Bucket();
		
		leaderBucket.setItemID(this.getItemID());
		pushResult=leaderBucket.push(String.valueOf(session.get("tableSuffix")).toString(), Integer.parseInt((session.get("workflowID")).toString()));
		
		if(pushResult.equalsIgnoreCase("presentAlready")){
			addActionError(getText("Hey, its already there.\nPeople are working on it"));
		}
		else if(pushResult.equalsIgnoreCase("success")){
			addActionMessage(getText("Item pushed successfully"));
		}
		else{
			addActionError(getText("Could not push item. Something went wrong"));
		}
		
		return editItems();
	}
	
	public String editItem(){
		session = ActionContext.getContext().getSession();
		this.setItemList(Item.find("item"+String.valueOf(session.get("tableSuffix")).toString()/*this.getWorkflowID()*/,"where item_id="+this.getItemID()));
		this.setWorkflowID(Integer.parseInt((session.get("workflowID")).toString()));
		return "editItem";
	}
	
	public String editItems(){
		session = ActionContext.getContext().getSession();
		this.setItemList(Item.find("item"+String.valueOf(session.get("tableSuffix")).toString()/*this.getWorkflowID()*/,""));
		this.setWorkflowID(Integer.parseInt((session.get("workflowID")).toString()));
		return "editItems";
	}
	
	public String assignRole(){
		pageName = "EditorConsole";
		usrlist = DBService.getUserList(" WHERE p_id IN(SELECT p_id FROM login_credentials WHERE role IN('author', 'publisher'))");
		if(usrlist != null){
			addActionMessage(getText("Userlist generated."));
		}
		
		else{
			addActionError(getText("No users found."));
		}
//		System.out.println(workflowID);
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
