package one.two.domain;

public class ResponseStatus {
	private Long id;
	private String newStat;
	private String oldStat;
	
	public ResponseStatus(Long id, String newStat, String oldStat) {
		this.id = id;
		this.newStat = newStat;
		this.oldStat = oldStat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewStat() {
		return newStat;
	}

	public void setNewStat(String newStat) {
		this.newStat = newStat;
	}

	public String getOldStat() {
		return oldStat;
	}

	public void setOldStat(String oldStat) {
		this.oldStat = oldStat;
	}
	
	

}
