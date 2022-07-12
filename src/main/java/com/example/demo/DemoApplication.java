package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepo productRepo) {
		return args -> {
			productRepo.save(new Product(null, "ASUS_G14", "Asus G14", "Laptop", "Laptop Asus G14", "35000000", 10));
			productRepo.save(new Product(null, "ASUS_G15", "Asus G15", "Laptop", "Laptop Asus G15", "29000000", 20));
			productRepo.save(new Product(null, "LOGI_G502", "Logitech G502", "Mouse", "Mouse Logitech G502", "10000000", 30));
			productRepo.save(new Product(null, "ASUS_3080_ROG", "Asus RTX 3080 ROG STRIX", "GPU", "GPU Asus RTX 3080 ROG STRIX", "40000000", 10));
		};
	}
}
