package com.gizlo.java.dto;

public class UsuarioResponseDto {

	private String tipoUsuario;
	private String usuario;
	private String estado;
	private String fechaRegistro;

	public UsuarioResponseDto(String tipoUsuario, String usuario, String estado, String fechaRegistro) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.usuario = usuario;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
	}

	public UsuarioResponseDto() {
		super();
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
