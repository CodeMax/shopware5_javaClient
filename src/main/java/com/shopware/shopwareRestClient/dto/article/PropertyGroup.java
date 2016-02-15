package com.shopware.shopwareRestClient.dto.article;

public class PropertyGroup {

	/**
	 * pramary key
	 */
	private int id;	
	private String name;
	private int position;
	private boolean comparable;
	private int sortMode;
	
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean isComparable() {
		return comparable;
	}
	public void setComparable(boolean comparable) {
		this.comparable = comparable;
	}
	public int getSortMode() {
		return sortMode;
	}
	public void setSortMode(int sortMode) {
		this.sortMode = sortMode;
	}
	
	@Override
	public String toString() {
		return "PropertyGroup [id=" + id + ", name=" + name + ", position=" + position + ", comparable=" + comparable
				+ ", sortMode=" + sortMode + "]";
	}
}