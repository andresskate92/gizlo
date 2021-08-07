package com.gizlo.java.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("usuarioInterno")
public class UsuarioInternoDocument {

	@Id
	private int id;
	private String usuario;
	private String rol;
	private String email;
	private String cedula;
	private Date fechaNacimiento;
	private Date fechaRegistro;

	public UsuarioInternoDocument(int id, String usuario, String rol, String email, String cedula, Date fechaNacimiento,
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

	public UsuarioInternoDocument() {
		super();
	}

}
