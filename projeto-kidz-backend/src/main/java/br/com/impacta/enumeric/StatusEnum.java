package br.com.impacta.enumeric;

public enum StatusEnum {

	VENDIDO("VENDIDO"), DISPONIVEL("DISPONÍVEL"), INDISPONIVEL("INDISPONÍVEL");

	String status;

	private StatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
