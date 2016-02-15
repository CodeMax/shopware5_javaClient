package com.shopware.shopwareRestClient.dto.article;

public class Related {

	/**
	 * foreign key for Article
	 */
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Related [id=" + id + ", name=" + name + "]";
	}
}
