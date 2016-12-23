package br.com.universal.model.enumeration;

public enum TipoEndereco {
	
	SELECIONE(-1), COMERCIAL(0), RESIDENCIAL(1), FATURAMENTO(2);
	Integer id;
	
	TipoEndereco(Integer id){
		this.id = id;
	}
	
	public static TipoEndereco fromInt(int valor) {
		switch (valor) {
		case -1:
			return SELECIONE;
		case 0:
			return COMERCIAL;
		case 1:
			return RESIDENCIAL;
		case 2:
			return FATURAMENTO;
		default:
			return null;
		}
	}

	
	@Override
	public String toString() {
		switch (this) {
		case SELECIONE:
			return "Selecione";
		case COMERCIAL:
			return "Comercial";
		case RESIDENCIAL:
			return "Residencial";
		case FATURAMENTO:
			return "Faturamento";
		default:
			return null;
		}
	}

}
