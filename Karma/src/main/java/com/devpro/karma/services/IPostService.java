package com.devpro.karma.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.dto.PostSearchModel;
import com.devpro.karma.entities.Post;
import com.devpro.karma.services.implement.PagerData;

public interface IPostService {
	Post createPost(Post post);

	PagerData<Post> searchPost(PostSearchModel model);

	Post findById(Integer id);

	Post save(Post post);

	Post saveOrUpdate(Post post, MultipartFile multipartAvt) throws IllegalStateException, IOException;

	Post findBySeo(String seo);
}
