package action;

import java.util.ArrayList;
import java.util.Map;

import model.WorkflowDetails;
import model.WorkflowMaster;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StageConsole extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<WorkflowDetails> objListWfDetails;
	private int workflowID;
	private int stageID;
	private String pageName;
	//private Map<String, Object> session;
	
	public String execute(){
		System.out.println("StageConsole execute "+this.getWorkflowID()+"-"+this.getPageName());
		if(this.getPageName().equalsIgnoreCase("workflow_list")){
		this.objListWfDetails=WorkflowDetails.find(this.getWorkflowID(), "");
		return "stageList";
		}
		else if(this.getPageName().equalsIgnoreCase("stage_list")){
			String whereClause="where stage_id = "+this.getStageID();
			this.setObjListWfDetails(WorkflowDetails.find(this.getWorkflowID(), whereClause));
			return "editStage";
		}
		else{
			this.objListWfDetails=WorkflowDetails.find(this.getWorkflowID(), "");
			return "done";
		}
	}
	

	
	public String addStage(){
		System.out.println("stageconsole addstage "+this.getWorkflowID());
		return "addStage";
	}

	public ArrayList<WorkflowDetails> getObjListWfDetails() {
		return objListWfDetails;
	}

	public void setObjListWfDetails(ArrayList<WorkflowDetails> objListWfDetails) {
		this.objListWfDetails = objListWfDetails;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

}
