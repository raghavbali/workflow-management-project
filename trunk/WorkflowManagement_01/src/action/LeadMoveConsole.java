package action;

import java.util.ArrayList;
import java.util.Map;

import model.Bucket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeadMoveConsole extends ActionSupport{

	private int stageID, workflowID, itemID;
	String status;
	private ArrayList<LeaderBucketAction> objBucketView;
	Map<String, Object> session;
	LeaderBucketAction tempobj;
	

	public String forward(){
		tempobj = new LeaderBucketAction();
		tempobj.displayList();
		this.objBucketView = tempobj.getObjBucketView();
		session = ActionContext.getContext().getSession();
		this.setWorkflowID(Integer.parseInt((session.get("workflowID")).toString()));
		if(!status.equals("C"))
			addActionError(getText("Attention: Status should be 'C' in order to forward the item!"));
		else{
	//		System.out.println(workflowID + " " + stageID + " " + itemID);
			String str = new Bucket().moveItem(workflowID, stageID, itemID, 1);
			if(str.equals("error"))
				addActionError(getText("Some error, contact system admin."));
			else
				addActionMessage(getText("Item forwarded successfully"));
		}
//		this.objBucketView = new LeaderBucketAction().find(String.valueOf(session.get("tableSuffix")).toString());
		tempobj.displayList();
		this.objBucketView = tempobj.getObjBucketView();
		return "forward";
	}
	
	public String backward(){
		tempobj = new LeaderBucketAction();
		tempobj.displayList();
		this.objBucketView = tempobj.getObjBucketView();
		session = ActionContext.getContext().getSession();
		this.setWorkflowID(Integer.parseInt((session.get("workflowID")).toString()));
		if(!status.equals("P"))
			addActionError(getText("Attention: Status should be 'P' in order to send back the item!"));
		else{
	//		System.out.println(workflowID + " " + stageID + " " + itemID);
			String str = new Bucket().moveItem(workflowID, stageID, itemID, -1);
			if(str.equals("error"))
				addActionError(getText("Some error, contact system admin."));
			else
				addActionMessage(getText("Item moved back successfully"));
		}
//		this.objBucketView = new LeaderBucketAction().find(String.valueOf(session.get("tableSuffix")).toString());
		
		tempobj.displayList();
		this.objBucketView = tempobj.getObjBucketView();
		return "backward";
	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public ArrayList<LeaderBucketAction> getObjBucketView() {
		return objBucketView;
	}

	public void setObjBucketView(ArrayList<LeaderBucketAction> objBucketView) {
		this.objBucketView = objBucketView;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
