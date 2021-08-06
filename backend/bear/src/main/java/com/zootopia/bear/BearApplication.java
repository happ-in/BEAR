package com.zootopia.bear;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootApplication
public class BearApplication {

	public static void main(String[] args) {
		SpringApplication.run(BearApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}
}
