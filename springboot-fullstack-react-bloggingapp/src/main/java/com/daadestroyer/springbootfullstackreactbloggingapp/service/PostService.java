package com.daadestroyer.springbootfullstackreactbloggingapp.service;

import java.util.List;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.helper.PostResponse;

public interface PostService {

	// create
	public PostDto createPost(PostDto postDto, int userId, int categoryId);

	// update
	public PostDto updatePost(PostDto postDto, int postId);

	// get post
	public PostDto getPost(int postId);

	// get all post
	public PostResponse getAllPost(int pageNumber, int pageSize, String sortBy , String sortDir);

	// delete post
	public String deletePost(int postId);

	// get post by category id
	public List<PostDto> getPostByCategoryId(int catId);

	// get post by user id
	public List<PostDto> getPostByUserId(int userId);

	// search post
	public List<PostDto> searchPost(String keyword);

}
