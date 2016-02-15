package com.shopware.shopwareRestClient.dto.article;

public class Image {

	/**
	 * primary key 
	 */
	private int id;
	private int articleId;
	
	/**
	 * foreign key for Detail
	 */
	private int articleDetailId;
	
	private String description;	
	private String path;
	private int main;
	private int position;
	private int width;
	private int height;
	private String relations;
	private String extension;
	private int parentId;
	
	/**
	 * foreign key for Media
	 */
	private int	mediaId;

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

	public int getArticleDetailId() {
		return articleDetailId;
	}

	public void setArticleDetailId(int articleDetailId) {
		this.articleDetailId = articleDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getMain() {
		return main;
	}

	public void setMain(int main) {
		this.main = main;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getRelations() {
		return relations;
	}

	public void setRelations(String relations) {
		this.relations = relations;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", articleId=" + articleId + ", articleDetailId=" + articleDetailId
				+ ", description=" + description + ", path=" + path + ", main=" + main + ", position=" + position
				+ ", width=" + width + ", height=" + height + ", relations=" + relations + ", extension=" + extension
				+ ", parentId=" + parentId + ", mediaId=" + mediaId + "]";
	}
}