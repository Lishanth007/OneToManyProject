package Mapping;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Ownership {
	@Id
	private int ownerId;
	private String ownerName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "owner_ids")
	private List<Products> ownerOfProduct;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Products> getOwnerOfProduct() {
		return ownerOfProduct;
	}

	public void setOwnerOfProduct(List<Products> ownerOfProduct) {
		this.ownerOfProduct = ownerOfProduct;
	}

}
