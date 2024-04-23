package br.com.cotiinformatica.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class EnviarEmailResponseDto {

	private String mensagem;
	private Date dataHoraEnvio;
}
