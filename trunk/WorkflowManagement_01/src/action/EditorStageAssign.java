package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.StageDetails;
import model.UserDetails;
import model.UserRole;
import model.WorkflowDetails;

public class EditorStageAssign {
	private int stageID, workflowID;
	private ArrayList<UserDetails> usrlist = new ArrayList<UserDetails>();
	private List<WorkflowDetails> stageList;
	private List<String> checkboxes = null;
	
	public String execute(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
//		System.out.println(usrlist.get(0).getUser_role().getUser_id());
		return "assign_stage_continue";
	}
	
	public String assignUsers(){
		int iSize;
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
//		usrlist = UserRole.find("WHERE w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
		if(checkboxes == null)
			iSize = 0;
		else
			iSize = checkboxes.size();
		System.out.println(iSize);
        for (int i = 0; i < iSize; i++) {
            System.out.println("checked item #" + i + " -> " + checkboxes.get(i));
            StageDetails.insert(workflowID, stageID, checkboxes.get(i));
         }
        
        this.setCheckboxes(this.getCheckboxes());
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

	public List<WorkflowDetails> getStageList() {
		return stageList;
	}

	public void setStageList(List<WorkflowDetails> stageList) {
		this.stageList = stageList;
	}

	public List<String> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<String> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public ArrayList<UserDetails> getUsrlist() {
		return usrlist;
	}

	public void setUsrlist(ArrayList<UserDetails> usrlist) {
		this.usrlist = usrlist;
	}

}
