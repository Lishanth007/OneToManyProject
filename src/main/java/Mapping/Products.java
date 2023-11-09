package Mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	private int productId;
	private String productName;
	private String productUserCount;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUserCount() {
		return productUserCount;
	}

	public void setProductUserCount(String productUserCount) {
		this.productUserCount = productUserCount;
	}

}
