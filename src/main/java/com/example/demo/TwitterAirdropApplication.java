package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@SpringBootApplication
public class TwitterAirdropApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterAirdropApplication.class, args);
	}

	
	@Bean
	public Twitter twitter() {
		return new TwitterTemplate("5ZwzvkaJshF3NoPxlmfn4SfLa",
				"UmHmJinCmKMzuRLF3VE3F4ekqBQfAxfulBVgOlBgFqwOhYMRD8",
				"1001935088-T5zwEzhviNkzLFF2B98rHmwLbhC713Jefuq3hOl",
				"SGOMerTXzUdi0XLec8dzppHmEzWdZGsvBHe23cz2FFtS8");
	}
}

