package com.myproject.ebeback.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="price")
	int price;
	
	@Column(name="img_path")
	String img_path;

	@Builder
	public Item(int id, String name, int price, String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img_path = imgPath;
	}
}
