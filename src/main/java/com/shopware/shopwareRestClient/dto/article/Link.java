package com.shopware.shopwareRestClient.dto.article;

public class Link {

	private int id;	
	private int articleId;
	private String name;
	private String link;
	private String target;
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "Link [id=" + id + ", articleId=" + articleId + ", name=" + name + ", link=" + link + ", target="
				+ target + "]";
	}
}
