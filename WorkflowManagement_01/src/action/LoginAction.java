package action;

import java.util.ArrayList;
import java.util.Map;

import utility.DBService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private int workflowID;
	private Map<String, Object> session;

	public String execute() {
		String role = null;
		ArrayList<String> result = null;
		session = ActionContext.getContext().getSession();

		result = DBService.db_authenticate(this.username, this.password);
		if (result.size() != 0)
			role = result.get(0);
		else
			role = "login_fail";

		/* get workflow id */

		if (result.size() > 1) {
			this.setWorkflowID(Integer.parseInt(result.get(1)));
		}
		/* set session for login status */
		if (!role.equalsIgnoreCase("login_fail")) {
			session.put("logged-in", "true");
			addActionMessage(getText("Login Successful"));

			/* set wid,user_id and table suffix */
			session.put("tableSuffix",
					DBService.tableSuffix(this.getWorkflowID()));
			session.put("workflowID", String.valueOf(this.getWorkflowID()));
			session.put("userID", result.get(2));
		} else {
			addActionError(getText("You are not logged-in"));
		}

		if (role.equals("admin"))
			return "admin_success";

		else if (role.equals("editor"))
			return "editor_success";

		else if (role.equals("author"))
			return "author_success";

		else if (role.equals("publisher")) {
			return "publisher_success";
		}

		else if (role.equals("login_fail")) {
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

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}


}