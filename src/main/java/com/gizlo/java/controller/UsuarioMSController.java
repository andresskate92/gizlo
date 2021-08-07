package com.gizlo.java.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.java.component.repository.IUsuarioExternoComponentRepository;
import com.gizlo.java.component.repository.IUsuarioInternoComponentRepository;
import com.gizlo.java.dto.ClaveValorDto;
import com.gizlo.java.model.UsuarioExternoDocument;
import com.gizlo.java.model.UsuarioInternoDocument;


@RestController
@RequestMapping(path = "/usuarioMS")
public class UsuarioMSController {

	@Autowired
	private IUsuarioExternoComponentRepository iUsuarioExternoComponentRepository;
	
	@Autowired
	private IUsuarioInternoComponentRepository iUsuarioInternoComponentRepository;
	
	@RequestMapping(path = "/save-usuarioExterno", method = RequestMethod.POST)
	public ResponseEntity<ClaveValorDto> guardarDatosUsuarioExterno(@RequestBody @Validated UsuarioExternoDocument externoDocument) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		try {
			this.iUsuarioExternoComponentRepository.save(externoDocument);
			claveValorDto.setClave("true");
			claveValorDto.setValor("Transaccion Exitosa");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save-usuarioInterno", method = RequestMethod.POST)
	public ResponseEntity<ClaveValorDto> guardarDatosUsuarioInterno(@RequestBody @Validated UsuarioInternoDocument internoDocument) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		try {
			this.iUsuarioInternoComponentRepository.save(internoDocument);
			claveValorDto.setClave("true");
			claveValorDto.setValor("Transaccion Exitosa");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/consulta-usuario", method = RequestMethod.POST)
	public ResponseEntity<ClaveValorDto> consultaDatosUsuario(@RequestParam("usuario") String usuario,
															  @RequestParam("tipoUsuario") String tipoUsuario) throws Exception {

		ClaveValorDto claveValorDto = new ClaveValorDto();
		Optional<UsuarioExternoDocument> externoDocument = null;
		Optional<UsuarioInternoDocument> internoDocument = null;
		try {
			if(tipoUsuario.equalsIgnoreCase("UE")) {
				externoDocument = this.iUsuarioExternoComponentRepository.findById(usuario);
				claveValorDto.setValor(externoDocument);
			}else if(tipoUsuario.equalsIgnoreCase("UI")) {
				internoDocument = this.iUsuarioInternoComponentRepository.findById(usuario);
				claveValorDto.setValor(internoDocument);
			}
			
			if(externoDocument == null && internoDocument == null) {
				claveValorDto.setClave("true");
				
			}else {
				claveValorDto.setClave("false");
				claveValorDto.setValor("error al consultar los dato");
			}				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<ClaveValorDto>(HttpStatus.OK);
	}
}
