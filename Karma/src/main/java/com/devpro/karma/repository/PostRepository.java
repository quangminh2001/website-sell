package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.karma.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	Post findBySeo(String seo);
}
