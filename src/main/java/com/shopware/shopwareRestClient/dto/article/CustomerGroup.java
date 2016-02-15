package com.shopware.shopwareRestClient.dto.article;

public class CustomerGroup {

	private int id;
	private String key;
	private String name;
	private Boolean tax;
	private Boolean taxInput;
	private Boolean mode;
	private int discount;
	private int minimumOrder;
	private int minimumOrderSurcharge;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTax() {
		return tax;
	}

	public void setTax(Boolean tax) {
		this.tax = tax;
	}

	public Boolean getTaxInput() {
		return taxInput;
	}

	public void setTaxInput(Boolean taxInput) {
		this.taxInput = taxInput;
	}

	public Boolean getMode() {
		return mode;
	}

	public void setMode(Boolean mode) {
		this.mode = mode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getMinimumOrder() {
		return minimumOrder;
	}

	public void setMinimumOrder(int minimumOrder) {
		this.minimumOrder = minimumOrder;
	}

	public int getMinimumOrderSurcharge() {
		return minimumOrderSurcharge;
	}

	public void setMinimumOrderSurcharge(int minimumOrderSurcharge) {
		this.minimumOrderSurcharge = minimumOrderSurcharge;
	}

	@Override
	public String toString() {
		return "Customergroup [id=" + id + ", key=" + key + ", name=" + name + ", tax=" + tax + ", taxInput=" + taxInput
				+ ", mode=" + mode + ", discount=" + discount + ", minimumOrder=" + minimumOrder
				+ ", minimumOrderSurcharge=" + minimumOrderSurcharge + "]";
	}

}
