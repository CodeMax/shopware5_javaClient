package com.shopware.shopwareRestClient.dto.categories;

public class Data {

	/**
	 * primary key
	 */
	public int id;
	        
	public Boolean active;
	public String name;
	public int position;
    
    /**
     * foreign key
     */
	public int parentId;

	public int childrenCount;
	public int articleCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
	public int getChildrenCount() {
		return childrenCount;
	}
	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", active=" + active + ", name=" + name + ", position=" + position + ", parentId="
				+ parentId + ", childrenCount=" + childrenCount + ", articleCount=" + articleCount + "]";
	}	
}