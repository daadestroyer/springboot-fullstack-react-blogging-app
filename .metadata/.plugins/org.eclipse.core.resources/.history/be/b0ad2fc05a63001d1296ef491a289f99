package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.impl.PostServiceImpl;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;

	// create post
	// http://localhost:8080/post/user/1/category/1/posts
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<?> createPost(@RequestBody PostDto postDto, @PathVariable int userId,
			@PathVariable int categoryId) {

		PostDto savedPost = this.postServiceImpl.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(savedPost, HttpStatus.OK);
	}
	
	// update post
}
