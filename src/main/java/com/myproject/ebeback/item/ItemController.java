package com.myproject.ebeback.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
    	System.err.println("ItemController getItems");
        List<Item> customers = itemService.findAll();
        return customers;
    }
    
    @GetMapping(path = "/items/{id}")
    public Item getOneItem(@PathVariable("id") long id) {
    	System.err.println("ItemController getOneItem");
    	Integer select_id = (int)id;
    	return itemService.findOne(select_id);
    }
    
    @PostMapping("/items")
    public Item createItem(@RequestBody final Item item, final UriComponentsBuilder ucBuilder) {
    	System.err.println("ItemController createItem");
    	Item res = new Item();
    	res = itemService.createItem(item);
    	return res;
    }
    
    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable("id") long id,
    		@RequestBody final Item item,
    		final UriComponentsBuilder ucBuilder) {
    	System.err.println("ItemController updateItem");
    	itemService.updateItem(id, item);
    	return itemService.findOne((int)id);
    }
    
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable("id") long id) {
    	System.err.println("ItemController deleteItem");
    	itemService.deleteItem((int)id);
    }
}