package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devpro.karma.entities.Comments;
import com.devpro.karma.repository.CommentRepository;
import com.devpro.karma.services.ICommentService;

@Component
public class CommentImpl implements ICommentService{
	@Autowired
	private CommentRepository commentRepository;
	
	public <S extends Comments> S save(S entity) {
		if(entity.getId() == null || entity.getId() < 0)
			entity.setCreatedDate(new Date());
		return commentRepository.save(entity);
	}
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Comments> findByListComment(int productID){
		
		String sql = "select c from Comments c where c.product.id = '" +productID + "'";
		
		@SuppressWarnings("unchecked")
		List<Comments> listComments = entityManager.createQuery(sql).setFirstResult(0).setMaxResults(5).getResultList();
		
		return listComments;
	}

	@Override
	public Comments findById(Integer id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id).get();
	}
}
