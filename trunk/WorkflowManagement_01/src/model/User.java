package model;

import java.sql.ResultSet;

import utility.DBService;
import utility.DBobjects;

public class User {
	
	private String p_id, prefix, fname, lname, sex, dob, address, country, phone, email;

	public User() {
	}

	public User(String p_id, String prefix, String fname, String lname, String sex,
			String dob, String address, String country, String phone,
			String email) {
		this.p_id = p_id;
		this.prefix = prefix;
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.dob = dob;
		this.address = address;
		this.country = country;
		this.phone = phone;
		this.email = email;
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
	
	public static String get(String colname, String pID){
		String value = "";
		ResultSet result;
		String query = "SELECT " + colname + " FROM personal_information ";
		String where = "WHERE p_id = '" + pID + "'";
		DBobjects dbObject;	
		try{
			dbObject = DBService.dbExecuteQuery(query,where);
			result=dbObject.getResult();
		while(result.next()){
			value = result.getString(colname);
		}
		dbObject.getConn().close();
		}catch(Exception ex){
			System.out.println("Exception caught: " + ex);
		}
		return value;
	}
	
}
