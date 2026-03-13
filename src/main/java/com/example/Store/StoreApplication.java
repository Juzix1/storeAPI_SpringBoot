package com.example.Store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class StoreApplication {
	private final DataSource dataSource;
	public StoreApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}


}
