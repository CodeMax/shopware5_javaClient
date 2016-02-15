package com.shopware.shopwareRestClient.dto.article;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIgnoreProperties({ "categories", "seoCategories" })
public class Data {

	private int id;
	private Integer mainDetailId;
	private int supplierId;
	private int taxId;
	private int priceGroupId;
	private int filterGroupId;
	private int configuratorSetId;

	private String name;
	private String description;
	private String descriptionLong;
	private Date added;
	private Boolean active;
	private int pseudoSales;
	private Boolean highlight;
	private String keywords;
	private String metaTitle;
	private Date changed;
	private Boolean priceGroupActive;
	private Boolean lastStock;
	private int crossBundleLook;
	private Boolean notification;
	private String template;
	private int mode;
	private Date availableFrom;
	private Date availableTo;
	private Maindetail mainDetail;
	private Tax tax;
	private PropertyValues[] propertyValues;
	private Supplier supplier;
	private PropertyGroup propertyGroup;
	private CustomerGroup[] customerGroups;
	private Image[] images;
	private ConfiguratorSet configuratorSet;
	private Link[] links;
	private Download[] downloads;
	private Category categories;
	private Similar similar;
	private Related related;
	private ArticleVariants[] details;
	private Translation[] translation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getMainDetailId() {
		return mainDetailId;
	}

	public void setMainDetailId(Integer mainDetailId) {
		this.mainDetailId = mainDetailId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getPriceGroupId() {
		return priceGroupId;
	}

	public void setPriceGroupId(int priceGroupId) {
		this.priceGroupId = priceGroupId;
	}

	public int getFilterGroupId() {
		return filterGroupId;
	}

	public void setFilterGroupId(int filterGroupId) {
		this.filterGroupId = filterGroupId;
	}

	public int getConfiguratorSetId() {
		return configuratorSetId;
	}

	public void setConfiguratorSetId(int configuratorSetId) {
		this.configuratorSetId = configuratorSetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionLong() {
		return descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getPseudoSales() {
		return pseudoSales;
	}

	public void setPseudoSales(int pseudoSales) {
		this.pseudoSales = pseudoSales;
	}

	public Boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public Boolean getPriceGroupActive() {
		return priceGroupActive;
	}

	public void setPriceGroupActive(Boolean priceGroupActive) {
		this.priceGroupActive = priceGroupActive;
	}

	public Boolean getLastStock() {
		return lastStock;
	}

	public void setLastStock(Boolean lastStock) {
		this.lastStock = lastStock;
	}

	public int getCrossBundleLook() {
		return crossBundleLook;
	}

	public void setCrossBundleLook(int crossBundleLook) {
		this.crossBundleLook = crossBundleLook;
	}

	public Boolean getNotification() {
		return notification;
	}

	public void setNotification(Boolean notification) {
		this.notification = notification;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Date getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(Date availableTo) {
		this.availableTo = availableTo;
	}

	public Maindetail getMainDetail() {
		return mainDetail;
	}

	public void setMainDetail(Maindetail mainDetail) {
		this.mainDetail = mainDetail;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public PropertyValues[] getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues[] propertyValues) {
		this.propertyValues = propertyValues;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public PropertyGroup getPropertyGroup() {
		return propertyGroup;
	}

	public void setPropertyGroup(PropertyGroup propertyGroup) {
		this.propertyGroup = propertyGroup;
	}

	public CustomerGroup[] getCustomerGroups() {
		return customerGroups;
	}

	public void setCustomerGroups(CustomerGroup[] customerGroups) {
		this.customerGroups = customerGroups;
	}

	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	public ConfiguratorSet getConfiguratorSet() {
		return configuratorSet;
	}

	public void setConfiguratorSet(ConfiguratorSet configuratorSet) {
		this.configuratorSet = configuratorSet;
	}

	public Link[] getLinks() {
		return links;
	}

	public void setLinks(Link[] links) {
		this.links = links;
	}

	public Download[] getDownloads() {
		return downloads;
	}

	public void setDownloads(Download[] downloads) {
		this.downloads = downloads;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public Similar getSimilar() {
		return similar;
	}

	public void setSimilar(Similar similar) {
		this.similar = similar;
	}

	public Related getRelated() {
		return related;
	}

	public void setRelated(Related related) {
		this.related = related;
	}

	public ArticleVariants[] getDetails() {
		return details;
	}

	public void setDetails(ArticleVariants[] details) {
		this.details = details;
	}

	public Translation[] getTranslation() {
		return translation;
	}

	public void setTranslation(Translation[] translation) {
		this.translation = translation;
	}
}