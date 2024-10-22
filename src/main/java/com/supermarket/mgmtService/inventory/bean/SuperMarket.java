package com.supermarket.mgmtService.inventory.bean;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SuperMarket {
	
	@Id
	@GeneratedValue
	public long id;
	
	@Column(name="category")
	public String category;
	@Column(name="itemname")
	public String itemName;
	public long quantity;
	
	
	
	public SuperMarket() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "SuperMarket [id=" + id + ", category=" + category + ", itemName=" + itemName + ", quantity=" + quantity
				+ "]";
	}
	
	
	
}
