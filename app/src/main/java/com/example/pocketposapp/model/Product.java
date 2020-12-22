package com.example.pocketposapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;




public class Product {


	private Long id;

	private String name;
	private String expirationDate;
	private String createDateTime;
	private String updateDateTime;
	private boolean deleted;
	
	
	
	public Product() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public Long getId() {
		return id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDateTime == null) ? 0 : createDateTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (createDateTime == null) {
			if (other.getCreateDateTime() != null) {
				return false;
			}
		} else if (!createDateTime.equals(other.getCreateDateTime())) {
			return false;
		}
		if (name == null) {
			if (other.getName() != null) {
				return false;
			}
		} else if (!name.equals(other.getName())) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", expirationDate=" + expirationDate +
				", createDateTime=" + createDateTime +
				", updateDateTime=" + updateDateTime +
				", deleted=" + deleted +
				'}';
	}
}
