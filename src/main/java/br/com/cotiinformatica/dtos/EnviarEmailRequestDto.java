package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class EnviarEmailRequestDto {

	private String emailDest;
	private String assunto;
	private String mensagem;
}
