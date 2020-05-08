package com.myproject.ebeback.dictionary;

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
@RequestMapping(path = "/api/dictionary/")
@CrossOrigin
public class DictionaryController {
    @Autowired
    DictionaryService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Dictionary> getItems() {
    	System.err.println("ItemController getItems");
        List<Dictionary> customers = itemService.findAll();
        return customers;
    }
    
    @GetMapping(path = "getValue")
    public Dictionary getValue(@PathVariable("id") long id) {
    	System.err.println("ItemController getOneItem");
    	Integer select_id = (int)id;
    	return itemService.findOne(select_id);
    }
    
    @PostMapping("/items")
    public Dictionary createItem(@RequestBody final Dictionary item, final UriComponentsBuilder ucBuilder) {
    	System.err.println("ItemController createItem");
    	Dictionary res = new Dictionary();
    	res = itemService.createItem(item);
    	return res;
    }
    
    @PutMapping("/items/{id}")
    public Dictionary updateItem(@PathVariable("id") long id,
    		@RequestBody final Dictionary item,
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