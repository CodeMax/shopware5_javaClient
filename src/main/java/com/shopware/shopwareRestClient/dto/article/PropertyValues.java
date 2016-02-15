package com.shopware.shopwareRestClient.dto.article;

public class PropertyValues {

	/**
	 * primary key
	 */
	private int	id;	
	private double valueNumeric;
	private int position;
	private int optionId;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValueNumeric() {
		return valueNumeric;
	}
	public void setValueNumeric(double valueNumeric) {
		this.valueNumeric = valueNumeric;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PropertyValues [id=" + id + ", valueNumeric=" + valueNumeric + ", position=" + position + ", optionId="
				+ optionId + ", value=" + value + "]";
	}	
}