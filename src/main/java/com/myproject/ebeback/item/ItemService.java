package com.myproject.ebeback.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> findAll() {
		List<Item> list = itemRepository.findAll();

		for (Item item : list) {
			System.out.println(item.toString());
		}

		return list;
	}

	public Item findOne(int id) {
		Item item = itemRepository.getOne(id);
		System.out.println(item);
		return item;
	}

	public void updateItem(long id, Item item) {
		System.err.println("ItemService createItem");
		System.out.println(item.toString());

		itemRepository.findById((int) id).map(items -> {
			items.setName(item.getName());
			items.setPrice(item.getPrice());
			items.setImg_path(item.getImg_path());
			return itemRepository.save(items);
		}).orElseGet(() -> {
			item.setId((int) id);
			return itemRepository.save(item);
		});
	}
	public void deleteItem(int id) {
		System.err.println("ItemService deleteItem");
		itemRepository.deleteById(id);
	}

	public Item createItem(Item item) {
		System.err.println("ItemService createItem");
		System.out.println(item.toString());
		Item res = itemRepository.save(item);
		System.out.println(res.toString());
		return res; 
	}
}
