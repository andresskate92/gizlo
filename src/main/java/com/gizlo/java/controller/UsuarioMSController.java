package com.gizlo.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.java.component.repository.IUsuarioExternoComponentRepository;
import com.gizlo.java.component.repository.IUsuarioInternoComponentRepository;
import com.gizlo.java.dto.ClaveValorDto;
import com.gizlo.java.dto.UsuarioResponseDto;
import com.gizlo.java.model.UsuarioExternoDocument;
import com.gizlo.java.model.UsuarioInternoDocument;


@RestController
@RequestMapping(path = "/usuarioMS")
@CrossOrigin(origins = "*")
public class UsuarioMSController {

	@Autowired
	private IUsuarioExternoComponentRepository iUsuarioExternoComponentRepository;
	
	@Autowired
	private IUsuarioInternoComponentRepository iUsuarioInternoComponentRepository;
	
	@RequestMapping(path = "/save-usuarioExterno", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaveValorDto> guardarDatosUsuarioExterno(@RequestBody UsuarioExternoDocument externoDocument) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		try { 
			externoDocument.setFechaRegistro(new Date());
			externoDocument.setFechaNacimiento(new Date());
			this.iUsuarioExternoComponentRepository.save(externoDocument);
			claveValorDto.setClave("true");
			claveValorDto.setValor("Transaccion Exitosa");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(claveValorDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save-usuarioInterno", method = RequestMethod.POST)
	public ResponseEntity<ClaveValorDto> guardarDatosUsuarioInterno(@RequestBody UsuarioInternoDocument internoDocument) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		try {
			internoDocument.setFechaNacimiento(new Date());
			internoDocument.setFechaRegistro(new Date());
			this.iUsuarioInternoComponentRepository.save(internoDocument);
			claveValorDto.setClave("true");
			claveValorDto.setValor("Transaccion Exitosa");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(claveValorDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/consulta-usuario", method = RequestMethod.GET)
	public ResponseEntity<ClaveValorDto> consultaDatosUsuario(@RequestParam("usuario") String usuario,
															  @RequestParam("tipoUsuario") String tipoUsuario) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		Optional<UsuarioExternoDocument> externoDocument = null;
		Optional<UsuarioInternoDocument> internoDocument = null;
		List<UsuarioExternoDocument> externoListDocument = new ArrayList<UsuarioExternoDocument>();
		List<UsuarioInternoDocument> internoListDocument = new ArrayList<>();
		List<UsuarioResponseDto> usuarioResponseDtos = new ArrayList<>();
		try {
			if(tipoUsuario.equalsIgnoreCase("UE")) {
				claveValorDto.setClave("true");
				if(usuario.isEmpty()) {
					externoListDocument = (List<UsuarioExternoDocument>) this.iUsuarioExternoComponentRepository.findAll();
					externoListDocument.stream().forEach(e ->{
						UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
						usuarioResponseDto.setEstado("A");
						usuarioResponseDto.setTipoUsuario("Usuario Externo");
						usuarioResponseDto.setUsuario(e.getUsuario());
						usuarioResponseDto.setFechaRegistro(new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss").format(e.getFechaRegistro()));
						usuarioResponseDtos.add(usuarioResponseDto);
					});
					claveValorDto.setValor(usuarioResponseDtos);
				}else {
					externoDocument = this.iUsuarioExternoComponentRepository.findById(usuario);
					UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
					usuarioResponseDto.setEstado("A");
					usuarioResponseDto.setTipoUsuario("Usuario Externo");
					usuarioResponseDto.setUsuario(externoDocument.get().getUsuario());
					usuarioResponseDto.setFechaRegistro(new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss").format(externoDocument.get().getFechaRegistro()));
					claveValorDto.setValor(externoDocument);
				}				
			}else if(tipoUsuario.equalsIgnoreCase("UI")) {
				claveValorDto.setClave("true");
				if(usuario.isEmpty()) {
					internoListDocument = (List<UsuarioInternoDocument>) this.iUsuarioInternoComponentRepository.findAll();
					internoListDocument.stream().forEach(e ->{
						UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
						usuarioResponseDto.setEstado("A");
						usuarioResponseDto.setTipoUsuario("Usuario Interno");
						usuarioResponseDto.setUsuario(e.getUsuario());
						usuarioResponseDto.setFechaRegistro(new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss").format(e.getFechaRegistro()));
						usuarioResponseDtos.add(usuarioResponseDto);
					});
					claveValorDto.setValor(usuarioResponseDtos);
				}else {
					internoDocument = this.iUsuarioInternoComponentRepository.findById(usuario);
					UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
					usuarioResponseDto.setEstado("A");
					usuarioResponseDto.setTipoUsuario("Usuario Interno");
					usuarioResponseDto.setUsuario(internoDocument.get().getUsuario());
					usuarioResponseDto.setFechaRegistro(new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss").format(internoDocument.get().getFechaRegistro()));
					claveValorDto.setValor(internoDocument);
				}
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(claveValorDto, HttpStatus.OK);
	}
}
