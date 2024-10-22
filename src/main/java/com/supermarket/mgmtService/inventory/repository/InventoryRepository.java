package com.supermarket.mgmtService.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.mgmtService.inventory.bean.SuperMarket;

public interface InventoryRepository extends JpaRepository<SuperMarket, Long> {

	void deleteByCategory(String category);

	SuperMarket findByItemName(String itemName);

	List<SuperMarket> findByCategory(String category);

}
