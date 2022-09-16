package com.devpro.karma.services.implement;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.Constants;
import com.devpro.karma.component.Utilities;
import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.ProductImages;
import com.devpro.karma.entities.Products;
import com.devpro.karma.repository.ProductImageReponsitory;
import com.devpro.karma.repository.ProductReponsitory;
import com.devpro.karma.services.IProductService;

@Component
public class ProductImpl implements IProductService, Constants {

	@Autowired
	ProductReponsitory productReponsitory;

	@Autowired
	ProductImageReponsitory productImageReponsitory;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int count() {
		return (int) productReponsitory.count();
	}
	
	@Override
	public List<Products> findAll() {
		return productReponsitory.findAll();
	}
	
	
	public <S extends Products> S save(S entity) {
		if (entity.getId() == null) {
			entity.setSeo(Utilities.slugify(entity.getTitle()));
		} else
			entity.setUpdatedDate(new Date());
		return productReponsitory.save(entity);
	}

	// khi đẩy dữ liệu từ file lên thì luôn có giá trị nhưng mà tên file bằng null
	@SuppressWarnings("unused")
	private Boolean checkUploadFile(MultipartFile multipartAvatar) {
		return multipartAvatar.getOriginalFilename().isEmpty() || multipartAvatar.equals(null);
	}

	@SuppressWarnings("unused")
	private Boolean checkUploadFile(MultipartFile[] multipartPicture) {
		// chắc chắn thui còn nó chỉ nhảy vào file
		if (multipartPicture.length <= 0 || multipartPicture == null)
			return true;
		if (multipartPicture[0].getOriginalFilename().isEmpty() || multipartPicture[0].equals(null))
			return true;
		return false;
	}

	public String getUniquePictureName(String fileName) {
		String[] splitFileName = fileName.split(".");
		return splitFileName[0] + System.currentTimeMillis() + "." + splitFileName[1];
	}

	// transactional để update hoặc xóa them được require
	@Transactional
	public void saveProduct(Products product, MultipartFile multipartAvt, MultipartFile[] multipartImgs)
			throws IllegalStateException, IOException {
		product.setCreatedDate(new Date());
		product.setSeo(Utilities.slugify(product.getTitle()));
		if (!checkUploadFile(multipartAvt)) {
			multipartAvt.transferTo(new File(ROOT_UPLOAD_FILE + "avatar/" + multipartAvt.getOriginalFilename()));
			product.setAvatar("avatar/" + multipartAvt.getOriginalFilename());
		}
		if (!checkUploadFile(multipartImgs)) {
			for (MultipartFile img : multipartImgs) {
				ProductImages image = new ProductImages();
				image.setCreatedDate(new Date());
				image.setPath("pictures/" + img.getOriginalFilename());
				image.setTitle(img.getOriginalFilename());
				product.addProductImg(image);
			}
		}
	}

	@Transactional
	public void updateProduct(Products product, MultipartFile multipartAvt, MultipartFile[] multipartImgs)
			throws IllegalStateException, IOException {
		Products productInDB = productReponsitory.findById(product.getId()).get();
		product.setUpdatedDate(new Date());
		product.setSeo(Utilities.slugify(product.getTitle()));
		product.setCreatedDate(productInDB.getCreatedDate());
		if (!checkUploadFile(multipartAvt)) {
			// delete file previously
			new File(ROOT_UPLOAD_FILE + "avatar/" + product.getAvatar()).delete();
			// tranfer file to folder indicate
			multipartAvt.transferTo(new File(ROOT_UPLOAD_FILE + "avatar/" + multipartAvt.getOriginalFilename()));
			// set again avatar
			product.setAvatar("avatar/" + multipartAvt.getOriginalFilename());
		} else
			// use avatar again for product
			product.setAvatar(productInDB.getAvatar());

		// delete all image in product
		if (!checkUploadFile(multipartImgs)) {
			if (productInDB.getProductImages().stream().count() > 0 || productInDB.getProductImages() != null) {
				for (ProductImages img : productInDB.getProductImages()) {
					new File(ROOT_UPLOAD_FILE + img.getPath()).delete();
					productImageReponsitory.delete(img);
				}
			}
			for (MultipartFile img : multipartImgs) {
				ProductImages images = new ProductImages();
				images.setUpdatedDate(new Date());
				images.setPath("pictures/" + img.getOriginalFilename());
				images.setTitle(img.getOriginalFilename());
				product.addProductImg(images);
			}
		}
	}

	public Products SaveOrUpdate(Products product, MultipartFile multipartAvt, MultipartFile[] multipartImgs)
			throws IllegalStateException, IOException {
		if (product.getId() == null) {
			saveProduct(product, multipartAvt, multipartImgs);
		} else {
			updateProduct(product, multipartAvt, multipartImgs);
		}
		return productReponsitory.save(product);
	}

	public Products findById(Integer id) {
		return productReponsitory.findById(id).get();
	}

	public ProductSearchModel findModelSearch(HttpServletRequest request) {
		int page = StringUtils.isEmpty(request.getParameter("page")) ? 1
				: Integer.parseInt(request.getParameter("page"));
		Integer categoryID = StringUtils.isEmpty(request.getParameter("category")) ? null
				: Integer.parseInt(request.getParameter("category"));
		String keyword = request.getParameter("keyword");
		ProductSearchModel search = new ProductSearchModel();
		search.setKeyword(keyword);
		search.setPage(page);
		search.setCategory(categoryID);
		return search;
	}

	@SuppressWarnings("unchecked")
	public PagerData<Products> searchProduct(ProductSearchModel productSearch, int itemPerPage) {
//		ProductSearchModel productSearch = findModelSearch(request);
		String sql = "Select p from Products p where 1=1 ";
		PagerData<Products> pager = new PagerData<Products>();
		if (productSearch != null) {
			if (productSearch.category != null) {
				sql += "and p.categories = '" + productSearch.getCategory() + "'";
			}
			if (!StringUtils.isEmpty(productSearch.getKeyword())) {
				sql += " and (p.title like '%" + productSearch.getKeyword() + "%' or p.shortDescription like '%"
						+ productSearch.getKeyword() + "%')";
			}
			if (!StringUtils.isEmpty(productSearch.getSeo())) {
				sql += " and p.seo like '%" + productSearch.getSeo() + "%'";
			}
			
			if (productSearch.isHot != null) {
				sql += " and p.isHot = 1 ";
			}
			if (productSearch.getYear() != null) {
				sql += " and year(p.createdDate) = " + productSearch.getYear();
			}
			if(!StringUtils.isEmpty(productSearch.sortByStatus)) {
				sql += " and p.status = " + productSearch.getSortByStatus();
			}
			if (!StringUtils.isEmpty(productSearch.sortByPrice)) {
				sql += " order by p.priceSale " + productSearch.sortByPrice;
			}
			if (productSearch.isNewest == true) {
				sql += " order by p.createdDate desc ";
			}
			if(!StringUtils.isEmpty(productSearch.getDiscountProduct())) {
				sql += " and p.price > p.priceSale ";
			}
//			System.out.println(productSearch.sortByPrice.equals("asc"));
			// query data from database
			Query query = entityManager.createQuery(sql);
			pager.setTotalItems(query.getResultList().size());
			pager.setData(query.setFirstResult((productSearch.getPage() - 1) * itemPerPage)
					.setMaxResults((productSearch.getPage() - 1) * itemPerPage + itemPerPage).getResultList());
			pager.setCurrentPage(productSearch.getPage());
		}
		return pager;
	}

//	public int countByCategory() {
//		String sql = "select p.category_id, count(*) from Products p  group by p.category_id; ";
//		Query query = entityManager.createQuery(sql);
//		
//		return 0;
//	}
}
