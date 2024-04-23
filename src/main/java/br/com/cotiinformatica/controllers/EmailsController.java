package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.EnviarEmailRequestDto;
import br.com.cotiinformatica.dtos.EnviarEmailResponseDto;
import br.com.cotiinformatica.services.EmailService;

@RestController
@RequestMapping(value = "/api/emails")
public class EmailsController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("enviar-email")
	public ResponseEntity<EnviarEmailResponseDto> enviarEmail(@RequestBody EnviarEmailRequestDto dto) throws Exception {
	
		EnviarEmailResponseDto response = emailService.enviarEmail(dto);
		
		return ResponseEntity.status(201).body(response);
	}
}
