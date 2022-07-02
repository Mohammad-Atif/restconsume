package com.example.restconsume;

import com.example.restconsume.quote.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
	This application is to learn about how to consume RESTful services using spring
 */
@SpringBootApplication
public class RestconsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestconsumeApplication.class, args);
	}

	/*
		Now we need
		1=  RestTemplate which uses Jackson JSON processing library to process the incoming data
		2= CommandLineRunner that runs the RestTempelate(and, consequently fetches our quotation) on startup
	 */

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws  Exception
	{
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random",Quote.class
			);
//			System.out.println(quote);
		};
	}
}
