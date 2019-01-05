package Enumeric;

public enum StatusEnum {
	
	VENDIDO("VENDIDO"),
	DISPONIVEL("DISPONÍVEL"),
	INDISPONIVEL("INDISPONÍVEL");
	
	String status;

	private StatusEnum(String status) {
		Status = status;
	}

	public String getStatus() {
		return Status;
	}
	
		

}
