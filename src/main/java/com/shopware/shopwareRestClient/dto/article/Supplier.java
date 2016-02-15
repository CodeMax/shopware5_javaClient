package com.shopware.shopwareRestClient.dto.article;

import java.util.Date;

public class Supplier {

	private int id;
	private String name;
	private String image;
	private String link;
	private String description;
	private String metaTitle;
	private String metaDescription;
	private String metaKeywords;
	private Date changed;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", image=" + image + ", link=" + link + ", description="
				+ description + ", metaTitle=" + metaTitle + ", metaDescription=" + metaDescription + ", metaKeywords="
				+ metaKeywords + ", changed=" + changed + "]";
	}
}