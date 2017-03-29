package dto;

public class PanierRequest {

	private String userId;
	
	private String platId;
	
	private String qte;

	public String getUserId() {
		return userId;
	}

	public String getPlatId() {
		return platId;
	}

	public void setPlatId(String platId) {
		this.platId = platId;
	}

	public String getQte() {
		return qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
