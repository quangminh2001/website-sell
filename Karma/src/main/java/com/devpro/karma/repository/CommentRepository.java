package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.karma.entities.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
