package br.com.impacta.model.enums;

public enum SexoEnum {
	
	MASCULINO("M"),
	FEMININO("F");
	
	String tipoSexo;

	private SexoEnum(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}

}
