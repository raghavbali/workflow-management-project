package model;

public class StageDetails {
	
	private int stageID;
	private int p_id;
	private String status;
	
	public StageDetails(){
		
	}
	
		
	public StageDetails(int p_id, String status) {
		super();
		this.p_id = p_id;
		this.status = status;
	}


	public StageDetails(int stageID, int p_id, String status) {
		super();
		this.stageID = stageID;
		this.p_id = p_id;
		this.status = status;
	}


	public int getStageID() {
		return stageID;
	}
	public void setStageID(int stageID) {
		this.stageID = stageID;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
