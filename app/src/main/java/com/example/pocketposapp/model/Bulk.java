package com.example.pocketposapp.model;

import java.time.LocalDateTime;



public class Bulk {

	private Long id;

	private Double buyPrice;

	private Long quantity;

	private String product;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;
	
	
	
	public Bulk() {
		
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id ;
	}
	
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(buyPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((createDateTime == null) ? 0 : createDateTime.hashCode());
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bulk)) {
			return false;
		}
		Bulk other = (Bulk) obj;
		if (Double.doubleToLongBits(buyPrice) != Double.doubleToLongBits(other.getBuyPrice())) {
			return false;
		}
		if (createDateTime == null) {
			if (other.getCreateDateTime() != null) {
				return false;
			}
		} else if (!createDateTime.equals(other.getCreateDateTime())) {
			return false;
		}
		return Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.getQuantity());
	}
	
	
	
	
}
