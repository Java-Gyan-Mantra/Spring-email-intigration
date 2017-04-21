package org.acc.dugu.dev.emailServices.configuration;

import java.util.Properties;

import org.acc.dugu.dev.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(value = "org.acc.dugu.dev.emailServices.*")
@PropertySource("classpath:emailServices.properties")
public class EmailServiceBeanConfiguration {
	@Autowired(required = true)
	private Environment environment;

	@Bean(name = { "mailSender", "mailSenderReference" })
	public MailSender getMailSenderImpl() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(environment.getProperty(Constants.HOST));
		mailSender.setPort(Integer.parseInt(environment
				.getProperty(Constants.PORT_NO)));
		mailSender.setUsername(environment.getProperty(Constants.USERNAME));
		mailSender.setPassword(environment.getProperty(Constants.PASSWORD));
		mailSender.setJavaMailProperties(getMailProperties());
		return mailSender;
	}

	private Properties getMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty(Constants.PROTOCOL,
				environment.getProperty(Constants.PROTOCOL));
		javaMailProperties.setProperty(Constants.AUTH,
				environment.getProperty(Constants.AUTH));
		javaMailProperties.setProperty(Constants.DEBUG,
				environment.getProperty(Constants.DEBUG));
		javaMailProperties.setProperty(Constants.STARTTLS,
				environment.getProperty(Constants.STARTTLS));
		javaMailProperties.setProperty(Constants.SSL_FACTORY,
				environment.getProperty(Constants.SSL_FACTORY));
		return javaMailProperties;
	}
}
