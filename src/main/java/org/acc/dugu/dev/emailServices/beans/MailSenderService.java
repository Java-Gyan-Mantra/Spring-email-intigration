package org.acc.dugu.dev.emailServices.beans;

import java.util.List;

import org.acc.dugu.dev.common.Constants;
import org.acc.dugu.dev.common.MailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:emailServices.properties")
public class MailSenderService {

	@Autowired(required = true)
	private MailSender mailSender;
	@Autowired(required = true)
	private Environment environment;

	public MailResponse sendMail(List<String> to, String subject, String content) {
		MailResponse response = new MailResponse();
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			for (String emails : to) {
				message.setFrom(environment.getProperty(Constants.USERNAME));
				message.setTo(emails);
				message.setSubject(subject);
				message.setText(content);
			//	 message.setContent("text/html");
			}
			mailSender.send(message);
			response.setStatus("Success");
			response.setErrorCode("0000");
		} catch (Exception e) {
			response.setStatus(e.getLocalizedMessage());
			response.setErrorCode("9999");
		}
		return response;
	}
}
