package io.kowsu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.kowsu.models.Product;

@SpringBootApplication
@RestController
public class OpenshiftMicroServiceApplication {

	private static List<Product> productsList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(OpenshiftMicroServiceApplication.class, args);
	}

	static {
		productsList.add(Product.builder().name("Lenovo").category("mobiles").price(123.3d).build());
		productsList.add(Product.builder().name("Lenovo").category("laptops").price(523.3d).build());
		productsList.add(Product.builder().name("Mcafee").category("anti-virus").price(123.3d).build());
	}

	@GetMapping("/all")
	public List<Product> getProducts() {
		return productsList;
	}

	@GetMapping("/category/{catg}")
	public List<Product> getProductsByCategory(@PathVariable("catg") String category) {
		return productsList.stream().filter(p -> p.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}
}
