package action;

import java.util.ArrayList;
import java.util.List;

import utility.DBService;

import model.User;
import model.WorkflowMaster;

import com.opensymphony.xwork2.ActionSupport;

public class AdminConsole extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<WorkflowMaster> objListWfMaster;
	public List<String> domainList;
	private ArrayList<User> usrlist;
	private ArrayList<String> sexList, prefixList;
	
	public AdminConsole(){
		domainList = new ArrayList<String>();
		domainList.add("IT_Project");
		domainList.add("Manufacturing");
		domainList.add("Delivery");
		domainList.add("E_Gov");
	}
	
	
	public String createWf(){
		return "createWf";
	}
	
	public String editWorkflow(){
		this.objListWfMaster=WorkflowMaster.find("");
		if(this.objListWfMaster!=null)
			addActionMessage(getText("Workflow list generated."));
		else
			addActionError(getText("No workflows Available."));
		return "editWf";
	}
	
	public String createUser(){
		sexList = new ArrayList<String>();
		prefixList = new ArrayList<String>();
		sexList.add("M");
		sexList.add("F");
		prefixList.add("Mr.");
		prefixList.add("Miss");
		prefixList.add("Mrs.");
		return "createUser";
	}
	
	public String editUser(){
		usrlist = DBService.getUserList();
		if(usrlist != null){
			addActionMessage(getText("Userlist generated."));
//			return "assignrole_continue";
		}
		
		else{
			addActionError(getText("No users found."));
//			return "assignrole_continue";
		}
		return "editUser";
	}
/*
	
	public String assignRole(){
		return "assignRole";
	}
*/	
	public String manual(){
		return "manual";
	}

	public ArrayList<WorkflowMaster> getObjListWfMaster() {
		return objListWfMaster;
	}

	public void setObjListWfMaster(ArrayList<WorkflowMaster> objListWfMaster) {
		this.objListWfMaster = objListWfMaster;
	}

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}


	public ArrayList<User> getUsrlist() {
		return usrlist;
	}


	public void setUsrlist(ArrayList<User> usrlist) {
		this.usrlist = usrlist;
	}


	public ArrayList<String> getSexList() {
		return sexList;
	}


	public void setSexList(ArrayList<String> sexList) {
		this.sexList = sexList;
	}


	public ArrayList<String> getPrefixList() {
		return prefixList;
	}


	public void setPrefixList(ArrayList<String> prefixList) {
		this.prefixList = prefixList;
	}


}