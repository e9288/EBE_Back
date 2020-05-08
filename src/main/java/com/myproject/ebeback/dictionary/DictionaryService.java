package com.myproject.ebeback.dictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
	@Autowired
	DictionaryRepository itemRepository;
	
	public List<Dictionary> findAll() {
		List<Dictionary> list = itemRepository.findAll();

		for (Dictionary item : list) {
			System.out.println(item.toString());
		}

		return list;
	}

	public Dictionary findOne(int id) {
		Dictionary item = itemRepository.getOne(id);
		System.out.println(item);
		return item;
	}

	public void updateItem(long id, Dictionary item) {
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

	public Dictionary createItem(Dictionary item) {
		System.err.println("ItemService createItem");
		System.out.println(item.toString());
		Dictionary res = itemRepository.save(item);
		System.out.println(res.toString());
		return res; 
	}
}
