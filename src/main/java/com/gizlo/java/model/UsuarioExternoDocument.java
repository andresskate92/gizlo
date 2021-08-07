package com.gizlo.java.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("usuarioExterno")
public class UsuarioExternoDocument {

	@Id
	private int id;
	private String usuario;
	private String rol;
	private String email;
	private String cedula;
	private Date fechaNacimiento;
	private Date fechaRegistro;

	public UsuarioExternoDocument(int id, String usuario, String rol, String email, String cedula, Date fechaNacimiento,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
		this.email = email;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}

	public UsuarioExternoDocument() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
