package br.com.impacta.model.enums;

public enum CategoriaEnum {
	
	CALCADO("CAL�ADO"),
	BLUSA("BLUSA");
	
	String tipoCategoria;

	private CategoriaEnum(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}
	
	

}
