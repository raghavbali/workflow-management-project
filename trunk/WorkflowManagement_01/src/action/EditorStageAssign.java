package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.StageDetails;
import model.UserDetails;
import model.WorkflowDetails;

public class EditorStageAssign extends ActionSupport {
	private int stageID, workflowID;
	private ArrayList<UserDetails> usrlist;
	private List<WorkflowDetails> stageList;
	private List<String> checkboxes = null;
	private String pageName;
		
	public String execute(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
		checkboxes = StageDetails.find(stageID, workflowID, "author", "");
//		System.out.println(checkboxes.get(0));
//		System.out.println(usrlist.get(0).getUser_role().getUser_id());
		pageName = "assignUsers";
		return "assign_stage_continue";
	}
	
	public String assignUsers(){
		int iSize, res=0;
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
//		usrlist = UserRole.find("WHERE w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
		if(checkboxes == null || (checkboxes.size() == 1 && checkboxes.get(0).equals("false"))){
			iSize = 0;
			res = StageDetails.assign(workflowID, stageID, "", "author", 0);
		}
		else
			iSize = checkboxes.size();
		System.out.println(iSize);
        for (int i = 0; i < iSize; i++) {
            System.out.println("checked item #" + i + " -> " + checkboxes.get(i));
            res = StageDetails.assign(workflowID, stageID, checkboxes.get(i), "author", i);
            if(res == 0)
            	break;
         }
        if(res == 0)
        	addActionError(getText("Some error, please re-chech the field values."));
        else
        	addActionMessage(getText("Assignment successful"));
        
 //       this.setCheckboxes(this.getCheckboxes());
        pageName = "assignUsers";
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

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
