package com.shopware.shopwareRestClient.dto.article;

public class Download {

	/**
	 * primary key 
	 */
	private int id;
	
	/**
	 * foreign key for Article
	 */
	private int articleId;
	private String name;
	private String file;
	private int size;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Download [id=" + id + ", articleId=" + articleId + ", name=" + name + ", file=" + file + ", size="
				+ size + "]";
	}
}
