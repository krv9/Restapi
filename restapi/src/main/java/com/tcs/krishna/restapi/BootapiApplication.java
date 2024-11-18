package com.tcs.krishna.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootapiApplication implements CommandLineRunner {
@Autowired
	DB db;
	public static void main(String[] args) {

		SpringApplication.run(BootapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		db=new ProDB();
		System.out.println(db.getdata());
	}
}
