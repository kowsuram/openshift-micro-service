package io.kowsu.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
	private String name, category;
	private double price;
}
