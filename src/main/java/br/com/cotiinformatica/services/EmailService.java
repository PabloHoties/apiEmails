package br.com.cotiinformatica.services;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import br.com.cotiinformatica.dtos.EnviarEmailRequestDto;
import br.com.cotiinformatica.dtos.EnviarEmailResponseDto;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	public EnviarEmailResponseDto enviarEmail(EnviarEmailRequestDto dto) throws Exception {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		helper.setFrom(userName);
		helper.setTo(dto.getEmailDest());
		helper.setSubject(dto.getAssunto());
		helper.setText(dto.getMensagem());
		
		javaMailSender.send(mimeMessage);
		
		EnviarEmailResponseDto response = new EnviarEmailResponseDto();
		response.setMensagem("Email enviado com sucesso");
		response.setDataHoraEnvio(new Date());
		
		return response;
	}	
}
