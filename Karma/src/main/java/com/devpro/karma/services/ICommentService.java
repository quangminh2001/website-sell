package com.devpro.karma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.karma.entities.Comments;

@Service
public interface ICommentService {
	public List<Comments> findByListComment(int productID);
	public <S extends Comments> S save(S entity);
	Comments findById(Integer id);
}
