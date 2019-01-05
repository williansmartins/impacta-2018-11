package br.com.impacta.enumeric;

public enum CategoriaEnum {
	
	CALCADO("CALÇADO"),
	BLUSA("BLUSA");
	
	String tipoCategoria;

	private CategoriaEnum(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}
	
	

}
