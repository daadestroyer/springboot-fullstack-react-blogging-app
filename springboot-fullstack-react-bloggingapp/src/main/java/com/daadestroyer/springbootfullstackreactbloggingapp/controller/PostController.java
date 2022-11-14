package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.helper.PostResponse;
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

	// get post by user
	// http://localhost:8080/post/user/1/posts
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> getPostByUserId(@PathVariable int userId) {
		List<PostDto> postByUserId = this.postServiceImpl.getPostByUserId(userId);
		return new ResponseEntity<>(postByUserId, HttpStatus.OK);
	}

	// get post by category
	// http://localhost:8080/post/category/1/posts
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<?> getPostByCategoryId(@PathVariable int categoryId) {
		List<PostDto> postByCategoryId = this.postServiceImpl.getPostByCategoryId(categoryId);
		return new ResponseEntity<>(postByCategoryId, HttpStatus.OK);
	}

	// get all post
	// http://localhost:8080/post/get-all-post
	// http://localhost:8080/post/get-all-post?pageNumber=1&pageSize=2
	@GetMapping("/get-all-post")
	public ResponseEntity<?> getAllPost(@RequestParam(required = false, defaultValue = "0") int pageNumber,
			@RequestParam(required = false, defaultValue = "3") int pageSize) {
		PostResponse allPost = this.postServiceImpl.getAllPost(pageNumber, pageSize);
		
		
		return new ResponseEntity<>(allPost, HttpStatus.OK);

	}

	// get post by id
	// http://localhost:8080/post/get-post/1
	@GetMapping("/get-post/{postId}")
	public ResponseEntity<?> getPost(@PathVariable int postId) {
		PostDto post = this.postServiceImpl.getPost(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	// delete post by id
	@DeleteMapping("/delete-post/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable int postId) {
		String message = this.postServiceImpl.deletePost(postId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// ERROR COMING IN DELETION

	// update post
	@PutMapping("/update-post/{postId}")
	public ResponseEntity<?> updatePost(@RequestBody PostDto postDto, @PathVariable int postId) {
		PostDto updatePost = this.postServiceImpl.updatePost(postDto, postId);
		return new ResponseEntity<>(updatePost, HttpStatus.OK);
	}

}
