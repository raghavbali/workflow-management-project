package action;

import java.util.ArrayList;

import utility.DBService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private String workflowID;
	
	public String execute(){
		String role;
		ArrayList<String> result;
		result = DBService.db_authenticate(this.username, this.password);
		role=result.get(0);
		if(result.size()==2){
			this.setWorkflowID(result.get(1));
		}

		if (role.equals("admin"))
			return "admin_success";
		
		else if (role.equals("editor"))
			return "editor_success";
		
		else if (role.equals("author"))
			return "author_success";
		
		else if (role.equals("publisher"))
			return "publisher_success";
		
		else if(role.equals("login_fail")){
			addActionError(getText("Login error: Invalid credentials."));
			return "error";
		}
		
		else
			return "error";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(String workflowID) {
		this.workflowID = workflowID;
	}
}