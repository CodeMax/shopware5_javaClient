package com.shopware.shopwareRestClient.dto.article;

public class ConfiguratorOption {

	/**
	 * primary key
	 */
	private int id;	
	
	/**
	 * foreign key for ConfiguratorGroup
	 */
	private int groupId;
	
	private String name;	
	private int position;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
		return "ConfiguratorOption [id=" + id + ", groupId=" + groupId + ", name=" + name + ", position=" + position
				+ "]";
	}
}
