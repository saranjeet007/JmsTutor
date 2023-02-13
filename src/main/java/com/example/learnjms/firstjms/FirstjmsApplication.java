package com.example.learnjms.firstjms;


import jakarta.jms.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@SpringBootApplication
public class FirstjmsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(FirstjmsApplication.class, args);
		JmsTemplate template = context.getBean(JmsTemplate.class);
		template.convertAndSend("queue-name","hello");
	}
	@Bean
	public JmsListenerContainerFactory warehouse (ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer containerFactoryConfigurer)
	{
         DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		 containerFactoryConfigurer.configure(defaultJmsListenerContainerFactory,connectionFactory);
		 return defaultJmsListenerContainerFactory;
	}
}
