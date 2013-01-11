package action;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import utility.DBService;

import model.User; 

public class AddUser extends ActionSupport {

	private String p_id, prefix, fname, lname, sex, dob, address, country, phone, email;
	private String buttonName;
	private ArrayList<String> sexList, prefixList;

	public AddUser() {
		sexList = new ArrayList<String>();
		prefixList = new ArrayList<String>();
		sexList.add("M");
		sexList.add("F");
		prefixList.add("Mr.");
		prefixList.add("Miss");
		prefixList.add("Mrs.");
	}
	
	public String execute(){
		if("Create".equals(buttonName)){
			
//			ArrayList<String> temp = DBService.fetchResults(DBService.dbExecuteQuery("SELECT MAX(p_id) as p_id FROM `personal_information`"), 1);
//			p_id = String.valueOf((Integer.parseInt(temp.get(0)) + 1));
			this.setDob(this.getDob().substring(0, 9));
			p_id = String.valueOf(DBService.generate_pid());
			User tempusr = new User(p_id, prefix, fname, lname, sex, dob, address, country, phone, email);
			String insertQuery = "INSERT INTO `personal_information`(`p_id`, `prefix`, `first_name`, `last_name`, `gender`, `dob`, `address`, `country`, `phone_no`, `email`) VALUES (?,?,?,?,?,?,?,?,?,?)";
			ArrayList<String> values = new ArrayList<String>();
			values.add(tempusr.getP_id());
			values.add(tempusr.getPrefix());
			values.add(tempusr.getFname());
			values.add(tempusr.getLname());
			values.add(tempusr.getSex());
			values.add(tempusr.getDob());
			values.add(tempusr.getAddress());
			values.add(tempusr.getCountry());
			values.add(tempusr.getPhone());
			values.add(tempusr.getEmail());
			
			int result = DBService.insertObjectInDB(insertQuery, values);
			
			if (result == 0){
				addActionError(getText("Some error, please re-check the field values."));
				return "error";
			}
			else{
				addActionMessage(getText("User added successfully."));
				return "adduser_continue";
			}
		}
		
		else if("Back".equals(buttonName)){
			return "back";
		}
		
		return null;
		
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

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
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
