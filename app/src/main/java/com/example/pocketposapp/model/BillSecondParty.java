package com.example.pocketposapp.model;

import java.time.LocalDateTime;




public class BillSecondParty {

	private Long id;

	private String name;

	private String phone;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

	private boolean deleted;
	
	
	
	public BillSecondParty() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public long getId() {
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
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BillSecondParty)) {
			return false;
		}
		BillSecondParty other = (BillSecondParty) obj;
		if (phone == null) {
			if (other.getPhone() != null) {
				return false;
			}
		} else if (!phone.equals(other.getPhone())) {
			return false;
		}
		return true;
	}
	
	
	
}
