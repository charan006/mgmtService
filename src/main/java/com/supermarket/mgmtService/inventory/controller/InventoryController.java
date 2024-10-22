package com.supermarket.mgmtService.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.mgmtService.inventory.bean.SuperMarket;
import com.supermarket.mgmtService.inventory.repository.InventoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080") 
public class InventoryController {

	@Autowired
	private InventoryRepository repository;

	@GetMapping("/inventory/getAll")
	public List<SuperMarket> getAll() {
		return repository.findAll();
	}

	@GetMapping("/inventory/getItem/{id}")
	public String searchItemById(@PathVariable long id) {
		Optional<SuperMarket> sm = repository.findById(id);
		if (sm.isEmpty()) {
			throw new RuntimeException("No record exists with ID " + id);
		} else {
			return "Item is " + sm.get().itemName;
		}
	}

	@PostMapping("/inventory/addItem")
	public void addItem(@RequestBody SuperMarket sm) {
		repository.save(sm);
	}

	@GetMapping("/inventory/getQuantity/{id}")
	public String searchQuantityById(@PathVariable long id) {
		Optional<SuperMarket> sm = repository.findById(id);
		if (sm.isEmpty()) {
			throw new RuntimeException("No record exists with ID " + id);
		} else {
			return "Quantity of item " + sm.get().itemName + " is " + sm.get().quantity;
		}
	}

	@PutMapping("/inventory/soldItem/{itemName}/{itemQuantity}")
	public SuperMarket soldItem(@PathVariable String itemName, @PathVariable long itemQuantity) {
		SuperMarket sm = repository.findByItemName(itemName);
		if (sm == null) {
			throw new RuntimeException("No record exists with name " + sm.itemName);
		} else {
			sm.quantity -= itemQuantity;
			repository.save(sm);
			return sm;
		}

	}

	@PutMapping("/inventory/restockItem/{itemName}")
	public SuperMarket restockItem(@PathVariable String itemName) {
		SuperMarket sm = repository.findByItemName(itemName);
		System.out.println(sm);
		sm.quantity+=1;
		repository.save(sm);
		return sm;
	}

	@DeleteMapping("/inventory/deleteByCategory/{category}")
	public void deleteByCategory(@PathVariable String category) {
//		System.out.println(category);
//Testing git
		List<SuperMarket> sm = repository.findByCategory(category);
		for (int i = 0; i < sm.size(); i++) {
			SuperMarket item = sm.get(i);
			repository.deleteById(item.id);
		}
	}

	@DeleteMapping("/inventory/deleteByItem/{itemName}")
	public void deleteByitemName(@PathVariable String itemName) {
		repository.deleteById(repository.findByItemName(itemName).id);
	}

}
