package com.shopware.shopwareRestClient.dto.article;

public class ConfiguratorGroup {

	/**
	 * primary key
	 */
	private int id;	
	private String description;
	private String name;
	private int position;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "ConfiguratorGroup [id=" + id + ", description=" + description + ", name=" + name + ", position="
				+ position + "]";
	}
}