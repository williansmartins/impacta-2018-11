package Enumeric;

public enum StatusEnum {
	
	VENDIDO("VENDIDO"),
	DISPONIVEL("DISPON�VEL"),
	INDISPONIVEL("INDISPON�VEL");
	
	String Status;

	private StatusEnum(String status) {
		Status = status;
	}

	public String getStatus() {
		return Status;
	}
	
	

}
