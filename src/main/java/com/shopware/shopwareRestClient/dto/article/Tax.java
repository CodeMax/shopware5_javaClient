package com.shopware.shopwareRestClient.dto.article;

public class Tax {

	private int id;
	private String tax;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tax [id=" + id + ", tax=" + tax + ", name=" + name + "]";
	}

}
