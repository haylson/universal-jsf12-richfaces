package br.com.universal.model.enumeration;


public enum TipoPessoa {
		
		FISICA, JURIDICA;
		
		@Override
		public String toString() {
			switch (this) {
			case FISICA:
				return "FISICA";
			case JURIDICA:
				return "JURIDICA";
			default:
				return null;
			}
		}
}
