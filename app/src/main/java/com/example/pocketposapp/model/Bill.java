package com.example.pocketposapp.model;

import java.time.LocalDateTime;
import java.util.Collection;



public  class Bill {

	private Long id;

	private Long total;

	private Long paid;

	private Long remainder;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

	private BillType billType;

	private boolean deleted;

	private BillSecondParty secondParty;

	private Collection<BillItem> items;
	
	

	public Bill() {
		
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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getPaid() {
		return paid;
	}

	public void setPaid(Long paid) {
		this.paid = paid;
	}

	public Long getRemainder() {
		return remainder;
	}

	public void setRemainder(Long remainder) {
		this.remainder = remainder;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType partyType) {
		this.billType = partyType;
	}
	

	public Collection<BillItem> getItems() {
		return items;
	}

	public void setItems(Collection<BillItem> items) {
		this.items = items;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public BillSecondParty getSecondParty() {
		return secondParty;
	}

	public void setSecondParty(BillSecondParty secondParty) {
		this.secondParty = secondParty;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDateTime == null) ? 0 : createDateTime.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bill)) {
			return false;
		}
		Bill other = (Bill) obj;
		if (createDateTime == null) {
			if (other.getCreateDateTime() != null) {
				return false;
			}
		} else if (!createDateTime.equals(other.getCreateDateTime())) {
			return false;
		}
		return true;
	}

	@Override
	public java.lang.String toString() {
		return "Bill{" +
				"id=" + id +
				", total=" + total +
				", paid=" + paid +
				", remainder=" + remainder +
				", createDateTime=" + createDateTime +
				", updateDateTime=" + updateDateTime +
				", billType=" + billType +
				", deleted=" + deleted +
				", secondParty=" + secondParty +
				", items=" + items +
				'}';
	}
}
