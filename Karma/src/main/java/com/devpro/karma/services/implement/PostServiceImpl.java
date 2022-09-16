package com.devpro.karma.services.implement;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.Constants;
import com.devpro.karma.component.Utilities;
import com.devpro.karma.dto.PostSearchModel;
import com.devpro.karma.entities.Post;
import com.devpro.karma.entities.ProductImages;
import com.devpro.karma.entities.Products;
import com.devpro.karma.repository.PostRepository;
import com.devpro.karma.services.IPostService;

@Service
public class PostServiceImpl implements IPostService,Constants{
	@Autowired
	private PostRepository postRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	public Post save(Post post) {
		
		return postRepository.save(post);
	}
	
	public Post findBySeo(String seo) {
		return postRepository.findBySeo(seo);
	}
	
	public Post findById(Integer id) {
		return postRepository.findById(id).orElseThrow(()-> new RuntimeException("NOT FOUND POST BY ID ="+id));
	}
	@SuppressWarnings("unused")
	private Boolean checkUploadFile(MultipartFile multipartAvatar) {
		return multipartAvatar.getOriginalFilename().isEmpty() || multipartAvatar.equals(null);
	}
	public Post saveOrUpdate(Post post, MultipartFile multipartAvt) throws IllegalStateException, IOException {
		post.setSeo(Utilities.slugify(post.getTitle()));
		if(post.getId() == null) {
			savePost(post,multipartAvt);
		}else {
			updatePost(post, multipartAvt);
		}
		return postRepository.save(post);
	}
	
	@Transactional
	public void savePost(Post post, MultipartFile multipartAvt)
			throws IllegalStateException, IOException {
		post.setCreatedDate(new Date());
		if (!checkUploadFile(multipartAvt)) {
			multipartAvt.transferTo(new File(ROOT_UPLOAD_FILE + "Post/" + multipartAvt.getOriginalFilename()));
			post.setPath("Post/" + multipartAvt.getOriginalFilename());
		}
	}
	
	@Transactional
	public void updatePost(Post post, MultipartFile multipartAvt)
			throws IllegalStateException, IOException {
		Post postinDb = postRepository.findById(post.getId()).get();
//		Products productInDB = productReponsitory.findById(product.getId()).get();
		post.setUpdatedDate(new Date());
		post.setCreatedDate(post.getCreatedDate());
		if (!checkUploadFile(multipartAvt)) {
			// delete file previously
			new File(ROOT_UPLOAD_FILE  + post.getPath()).delete();
			// tranfer file to folder indicate
			multipartAvt.transferTo(new File(ROOT_UPLOAD_FILE + "Post/" + multipartAvt.getOriginalFilename()));
			// set again avatar
			post.setPath("Post/" + multipartAvt.getOriginalFilename());
		} else
			// use avatar again for product
			post.setPath(postinDb.getPath());
	}
	@Override
	public Post createPost(Post post) {
		
		return postRepository.save(post);
	}
	
	
	
	@Override
	public PagerData<Post> searchPost(PostSearchModel model) {
		String sql = "Select p from Post p where 1=1 ";
		if(model != null) {
			if(!StringUtils.isEmpty(model.keyword)) {
				sql += " and (p.title like '%" + model.getKeyword() + "%' or p.content like '%"
						+ model.getKeyword() + "%')";
			}
			if(!StringUtils.isEmpty(model.getStatus())) {
				sql += " and p.status = " +model.getStatus();
			}
			if(!StringUtils.isEmpty(model.getCategory())) {
				sql += " and p.categoryName like '%"+model.getCategory()+"%'";
			}
		}
		Query query = entityManager.createQuery(sql);
		
		PagerData<Post> pager = new PagerData<Post>();
		pager.setCurrentPage(model.getCurrentPage());
		@SuppressWarnings("unchecked")
		List<Post> listPost = query.setFirstResult((model.getCurrentPage()-1)*6).setMaxResults((model.getCurrentPage()-1)*6+6).getResultList();
		pager.setData(listPost);
		pager.setTotalItems(listPost.size());
		return pager;
	}
	
}
