package com.devpro.karma.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_products")
public class Products extends BaseEntity {
	@Column(name = "title", length = 1000, nullable = false)
	private String title;

	@Column(name = "short_description", length = 3000, nullable = false)
	private String shortDescription;

	@Column(name = "price", precision = 13, scale = 2, nullable = true)
	private BigDecimal price;

	@Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
	private BigDecimal priceSale;

	@Lob
	@Column(name = "detail_description", columnDefinition = "LONGTEXT", nullable = false)
	private String detailDescription;

	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;

	@Column(name = "status")
	private Boolean status = Boolean.FALSE;

	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;

	@Column(name = "is_hot")
	private Boolean isHot = Boolean.TRUE;

	@Column(name = "width", nullable = true)
	private Float width;

	@Column(name = "height", nullable = true)
	private Float height;

	@Column(name = "depth", nullable = true)
	private Float depth;

	@Column(name = "weight", nullable = true)
	private Float weight;

	@Column(name = "is_check", nullable = true)
	private Boolean isCheck = Boolean.FALSE;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Categories categories = new Categories();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProductImages> productImages = new HashSet<ProductImages>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comments> comments = new HashSet<Comments>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SaleorderProduct> saleorderProducts = new HashSet<SaleorderProduct>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductAttribute> productAttributes = new HashSet<ProductAttribute>();

	public void addProductAttribute(ProductAttribute productAttribute) {
		productAttributes.add(productAttribute);
		productAttribute.setProduct(this);
	}

	public void addProductImg(ProductImages productImage) {
		productImages.add(productImage);
		productImage.setProduct(this);
	}

	public void addComment(Comments comment) {
		comments.add(comment);
		comment.setProduct(this);
	}

	public void addSaleorderProduct(SaleorderProduct saleorderProduct) {
		saleorderProduct.setProducts(this);
		saleorderProducts.add(saleorderProduct);
	}

	public Set<SaleorderProduct> getSaleorderProducts() {
		return saleorderProducts;
	}

	public void setSaleorderProducts(Set<SaleorderProduct> saleorderProducts) {
		this.saleorderProducts = saleorderProducts;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public Set<ProductImages> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImages> productImages) {
		this.productImages = productImages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getDepth() {
		return depth;
	}

	public void setDepth(Float depth) {
		this.depth = depth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

}
