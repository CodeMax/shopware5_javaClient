package com.shopware.shopwareRestClient.dto.article;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfiguratorSet {

	/**
	 * primary key
	 */
	private int id;
	private String name;
	private boolean pub;
	private int type;
	private ConfiguratorGroup[] groups;
	
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
	
	@JsonProperty("public")
	public boolean getPub() {
		return pub;
	}
	public void setPub(boolean pub) {
		this.pub = pub;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ConfiguratorGroup[] getGroups() {
		return groups;
	}
	public void setGroups(ConfiguratorGroup[] groups) {
		this.groups = groups;
	}
	
	@Override
	public String toString() {
		return "ConfiguratorSet [id=" + id + ", name=" + name + ", pub=" + pub + ", type=" + type + ", groups="
				+ Arrays.toString(groups) + "]";
	}
}