package com.example.pocketposapp.model;




public class BillItem {

	
	private Double price;
	private Double quantity;
	private String bulk;

	
	public BillItem() {
		
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double buyPrice) {
		this.price = buyPrice;
	}

	public String getBulk() {
		return bulk;
	}

	public void setBulk(String bulk) {
		this.bulk = bulk;
	}

	@Override
	public String toString() {
		return "BillItem{" +
				"price=" + price +
				", quantity=" + quantity +
				", bulk='" + bulk + '\'' +
				'}';
	}
}
