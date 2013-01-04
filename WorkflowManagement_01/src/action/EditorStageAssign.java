package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.UserRole;
import model.WorkflowDetails;

public class EditorStageAssign {
	private int stageID, workflowID;
	ArrayList<UserRole> usrlist;
	private List<WorkflowDetails> stageList;
	private Map<Integer, Boolean> checkboxes;
	
	public String execute(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserRole.find("WHERE w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
		return "assign_stage_continue";
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

	public ArrayList<UserRole> getUsrlist() {
		return usrlist;
	}

	public void setUsrlist(ArrayList<UserRole> usrlist) {
		this.usrlist = usrlist;
	}

	public List<WorkflowDetails> getStageList() {
		return stageList;
	}

	public void setStageList(List<WorkflowDetails> stageList) {
		this.stageList = stageList;
	}

	public Map<Integer, Boolean> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(Map<Integer, Boolean> checkboxes) {
		this.checkboxes = checkboxes;
	}
}
