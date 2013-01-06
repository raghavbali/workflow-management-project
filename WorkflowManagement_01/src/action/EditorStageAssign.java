package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.StageDetails;
import model.UserDetails;
import model.WorkflowDetails;

public class EditorStageAssign extends ActionSupport {
	private int stageID, workflowID;
	private ArrayList<UserDetails> usrlist, usrlist1;
	private List<WorkflowDetails> stageList;
	private List<String> checkboxes = null, checkboxes1 = null;
	private ArrayList<String> usrlist2;
	private String pageName, selectedPublisher;
		
	public String execute(){
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
		usrlist1 = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('publisher')");
		checkboxes = StageDetails.find(stageID, workflowID, "author", "");
		checkboxes1 = StageDetails.find(stageID, workflowID, "publisher", "");
		usrlist2 = populatePublisherList(usrlist1);
		selectedPublisher = getStagePublisher(usrlist1, checkboxes1);
//		System.out.println(checkboxes.get(0));
//		System.out.println(usrlist.get(0).getUser_role().getUser_id());
		pageName = "assignUsers";
		return "assign_stage_continue";
	}
	
	public String assignAuthors(){
		int iSize, res=0;
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
		usrlist1 = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('publisher')");
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
        checkboxes = StageDetails.find(stageID, workflowID, "author", "");
		checkboxes1 = StageDetails.find(stageID, workflowID, "publisher", "");
		usrlist2 = populatePublisherList(usrlist1);
		selectedPublisher = getStagePublisher(usrlist1, checkboxes1);
        pageName = "assignUsers";
		return "assign_stage_continue";
	}
	
//	public String assignPublishers(){
//		int iSize, res=0;
//		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
//		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
//		usrlist1 = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('publisher')");
//		usrlist2 = populatePublisherList(usrlist1);
//		selectedPublisher = getStagePublisher(usrlist1, checkboxes1);
////		usrlist = UserRole.find("WHERE w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
//		if(checkboxes1 == null || (checkboxes1.size() == 1 && checkboxes1.get(0).equals("false"))){
//			iSize = 0;
//			res = StageDetails.assign(workflowID, stageID, "", "publisher", 0);
//		}
//		else
//			iSize = checkboxes1.size();
//		System.out.println(iSize);
//        for (int i = 0; i < iSize; i++) {
//            System.out.println("checked item #" + i + " -> " + checkboxes1.get(i));
//            res = StageDetails.assign(workflowID, stageID, checkboxes1.get(i), "publisher", i);
//            if(res == 0)
//            	break;
//         }
//        if(res == 0)
//        	addActionError(getText("Some error, please re-chech the field values."));
//        else
//        	addActionMessage(getText("Assignment successful"));
//        
// //       this.setCheckboxes1(this.getCheckboxes1());
//        checkboxes = StageDetails.find(stageID, workflowID, "author", "");
//		checkboxes1 = StageDetails.find(stageID, workflowID, "publisher", "");
//        pageName = "assignUsers";
//		return "assign_stage_continue";
//	}
	
	public String assignPublishers(){
		int res=0;
		this.setStageList(WorkflowDetails.find(this.getWorkflowID(), ""));
		usrlist = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('author')");
		usrlist1 = UserDetails.find("AND w_id='" + workflowID + "' AND role IN ('publisher')");
//		usrlist = UserRole.find("WHERE w_id='" + workflowID + "' AND role IN ('author', 'publisher')");
		String lead_id = selectedPublisher.split("\\[")[1].split("]")[0];
		res = StageDetails.assign(workflowID, stageID, lead_id, "publisher", 0);
        if(res == 0)
        	addActionError(getText("Some error, please re-chech the field values."));
        else
        	addActionMessage(getText("Assignment successful"));
        WorkflowDetails.updateLead(workflowID, Integer.parseInt(lead_id), stageID);
        checkboxes = StageDetails.find(stageID, workflowID, "author", "");
		checkboxes1 = StageDetails.find(stageID, workflowID, "publisher", "");
		usrlist2 = populatePublisherList(usrlist1);
//		selectedPublisher = getStagePublisher(usrlist1, checkboxes1);
        pageName = "assignUsers";
		return "assign_stage_continue";
	}
	
	public ArrayList<String> populatePublisherList(ArrayList<UserDetails> usrlist1){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i<usrlist1.size();i++)
			list.add(usrlist1.get(i).getUser().getFname() + " " + usrlist1.get(i).getUser().getLname() + "[" + usrlist1.get(i).getUser_role().getUser_id() + "]");
		return list;
	}
	
	public String getStagePublisher(ArrayList<UserDetails> usrlist1, List<String> checkboxes1){
		String str = "";
		if(checkboxes1.size() == 0)
			return str;
		for(int i = 0; i<usrlist1.size();i++){
			if(usrlist1.get(i).getUser_role().getUser_id().equals(checkboxes1.get(0))){
				str = usrlist1.get(i).getUser().getFname() + " " + usrlist1.get(i).getUser().getLname() + "[" + usrlist1.get(i).getUser_role().getUser_id() + "]";
				break;
			}
		}
		return str;
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

	public ArrayList<UserDetails> getUsrlist1() {
		return usrlist1;
	}

	public void setUsrlist1(ArrayList<UserDetails> usrlist1) {
		this.usrlist1 = usrlist1;
	}

	public List<String> getCheckboxes1() {
		return checkboxes1;
	}

	public void setCheckboxes1(List<String> checkboxes1) {
		this.checkboxes1 = checkboxes1;
	}

	public ArrayList<String> getUsrlist2() {
		return usrlist2;
	}

	public void setUsrlist2(ArrayList<String> usrlist2) {
		this.usrlist2 = usrlist2;
	}

	public String getSelectedPublisher() {
		return selectedPublisher;
	}

	public void setSelectedPublisher(String selectedPublisher) {
		this.selectedPublisher = selectedPublisher;
	}

}
