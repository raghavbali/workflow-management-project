package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import utility.CaesarCypher;
import utility.DBService;
import utility.DBobjects;

public class EditProfile extends ActionSupport{
	private String p_id, prefix, fname, lname, sex, dob, address, country, phone, email;
	private String user_id, username, password, w_id, role, active_flag;
	private ArrayList<String> sexList, prefixList;
	private EditProfile tmpuser;
	Map<String, Object> session;
	private String pageName, oldPass, newPass, reNewPass;
	
	
	public EditProfile(){
		sexList = new ArrayList<String>();
		prefixList = new ArrayList<String>();
		sexList.add("M");
		sexList.add("F");
		prefixList.add("Mr.");
		prefixList.add("Miss");
		prefixList.add("Mrs.");
	}
	
	public String execute(){
		String clause;
		session = ActionContext.getContext().getSession();
		tmpuser = new EditProfile();
		this.setUser_id(session.get("userID").toString());
		clause = " AND user_id = '" + this.getUser_id() + "'";
		tmpuser = this.find(clause);
		session.put("tmpuser", tmpuser);
		pageName = "editProfileBasic";
		return "success";
	}
	
	public String showPassCtrl(){
		session = ActionContext.getContext().getSession();
		this.setTmpuser((EditProfile) session.get("tmpuser"));
		pageName = "changePass";
		return "success";
	}
	
	public String editBasicProfile(){
		session = ActionContext.getContext().getSession();
		this.setTmpuser((EditProfile) session.get("tmpuser"));
		String updateQuery = "UPDATE personal_information SET prefix = '" + this.getPrefix() +
															"', first_name = '" + this.getFname() + 
															"', last_name = '" + this.getLname() +
															"', gender = '" + this.getSex() + 
															"', dob = '" + this.getDob() + 
															"', address = '" + this.getAddress() + 
															"', country = '" + this.getCountry() + 
															"', phone_no = '" + this.getPhone() + 
															"', email = '" + this.getEmail() + 
															"' WHERE p_id = '" + this.getP_id() + "'";
		int res = DBService.DDLQueryInDB(updateQuery);
		this.setTmpuser(this.find(" AND user_id = '" + this.getUser_id() + "'"));
		if(res == 0){
			addActionError(getText("Some error, please re-chech the field values."));
			return "error";
		}
		else{
			addActionMessage(getText("Success"));
			return "success";
		}
	}
	
	public String editAdvProfile(){
		session = ActionContext.getContext().getSession();
		this.setUser_id(session.get("userID").toString());
		this.setTmpuser(this.find(" AND user_id = '" + this.getUser_id() + "'"));
		String encrypt_oldpass = CaesarCypher.encrypt(oldPass);
		if(!encrypt_oldpass.equals(tmpuser.getPassword())){
			addActionError(getText("Incorrect old password"));
//			System.out.println("iop");
			return "error";
		}
		else if(!this.newPass.equals(this.reNewPass)){
			addActionError(getText("New password in both fields don't match."));
//			System.out.println("newdm");
			return "error";
		}
		else{
			String pass_encrypt = CaesarCypher.encrypt(this.getNewPass());			
			String updateQuery = "UPDATE login_credentials SET password = '" + pass_encrypt + "' WHERE user_id = '" + this.tmpuser.getUser_id() + "'";
			int res = DBService.DDLQueryInDB(updateQuery);
			this.setTmpuser(this.find(" AND user_id = '" + this.tmpuser.getUser_id() + "'"));
			if(res == 0){
				addActionError(getText("Some error, please re-chech the field values."));
//				System.out.println("some error");
				return "error";
			}
			else{
				addActionMessage(getText("Success"));
//				System.out.println("suc");
				return "success";
			}
		}
	}
	
	public EditProfile find(String clause){
		ResultSet result = null;
		DBobjects dbObject;
		EditProfile tempobj = new EditProfile();
		String query = "SELECT ub.*, ur.* FROM personal_information ub, login_credentials ur where ub.p_id = ur.p_id" + clause;
		try {
			dbObject = DBService.dbExecuteQuery(query, "");
			result=dbObject.getResult();
			while (result.next()) {
				
				tempobj.setP_id(result.getString("p_id"));
				tempobj.setPrefix(result.getString("prefix"));
				tempobj.setFname(result.getString("first_name"));
				tempobj.setLname(result.getString("last_name"));
				tempobj.setSex(result.getString("gender"));
				tempobj.setDob(result.getString("dob"));
				tempobj.setAddress(result.getString("address"));
				tempobj.setCountry(result.getString("country"));
				tempobj.setPhone(result.getString("phone_no"));
				tempobj.setEmail(result.getString("email"));
				
				tempobj.setUser_id(result.getString("user_id"));
				tempobj.setUsername(result.getString("username"));
				tempobj.setPassword(result.getString("password"));
				tempobj.setW_id(result.getString("w_id"));
				tempobj.setRole(result.getString("role"));
				tempobj.setActive_flag(result.getString("active_flag"));
			}
			dbObject.getConn().close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return tempobj;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
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

	public EditProfile getTmpuser() {
		return tmpuser;
	}

	public void setTmpuser(EditProfile tmpuser) {
		this.tmpuser = tmpuser;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getReNewPass() {
		return reNewPass;
	}

	public void setReNewPass(String reNewPass) {
		this.reNewPass = reNewPass;
	}

}
