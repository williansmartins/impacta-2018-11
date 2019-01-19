package br.com.impacta.model.enums;

public enum StatusEnum {

	VENDIDO("VENDIDO"), DISPONIVEL("DISPON�VEL"), INDISPONIVEL("INDISPON�VEL");

	String status;

	private StatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
