package com.gizlo.java.dto;

public class ClaveValorDto {

	private String clave;
	private Object valor;

	public ClaveValorDto(String clave, Object valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}

	public ClaveValorDto() {
		super();
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

}
