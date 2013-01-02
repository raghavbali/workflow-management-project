package action;

import java.util.ArrayList;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;

import model.User;

public class EditUserBasic extends ActionSupport {
	private String p_id, prefix, fname, lname, sex, dob, address, country, phone, email;
	private ArrayList<String> sexList, prefixList;
	User tmpuser = new User();
	
	public EditUserBasic() {
		sexList = new ArrayList<String>();
		prefixList = new ArrayList<String>();
		sexList.add("M");
		sexList.add("F");
		prefixList.add("Mr.");
		prefixList.add("Miss");
		prefixList.add("Mrs.");
	}
	
	public String execute(){
		String selectQuery = "SELECT * FROM `personal_information`";
		String whereClause = "WHERE p_id = '" + p_id + "'";
		try{
		ResultSet result = DBService.dbExecuteQuery(selectQuery, whereClause);
		while(result.next()){
			tmpuser.setP_id(result.getString("p_id"));
			tmpuser.setPrefix(result.getString("prefix"));
			tmpuser.setFname(result.getString("first_name"));
			tmpuser.setLname(result.getString("last_name"));
			tmpuser.setSex(result.getString("gender"));
			tmpuser.setDob(result.getString("dob"));
			tmpuser.setAddress(result.getString("address"));
			tmpuser.setCountry(result.getString("country"));
			tmpuser.setPhone(result.getString("phone_no"));
			tmpuser.setEmail(result.getString("email"));
		}
		}catch(Exception ex){
			System.out.println("Excption caught: " + ex);
		}
		
		return "edit_user_basic_success";
	}
	
	public String update(){
		tmpuser = new User(p_id, prefix, fname, lname, sex, dob, address, country, phone, email);
		String updateQuery = "UPDATE personal_information SET prefix = '" + tmpuser.getPrefix() +
															"', first_name = '" + tmpuser.getFname() + 
															"', last_name = '" + tmpuser.getLname() +
															"', gender = '" + tmpuser.getSex() + 
															"', dob = '" + tmpuser.getDob() + 
															"', address = '" + tmpuser.getAddress() + 
															"', country = '" + tmpuser.getCountry() + 
															"', phone_no = '" + tmpuser.getPhone() + 
															"', email = '" + tmpuser.getEmail() + 
															"' WHERE p_id = '" + tmpuser.getP_id() + "'";
		
		int res = DBService.DDLQueryInDB(updateQuery);
		if(res == 0){
			addActionError(getText("Some error, please re-chech the field values."));
			return "error";
		}
		else{
			addActionMessage(getText("User edited successfully."));
			return "edituser_continue";
		}
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

	public User getTmpuser() {
		return tmpuser;
	}

	public void setTmpuser(User tmpuser) {
		this.tmpuser = tmpuser;
	}
}
