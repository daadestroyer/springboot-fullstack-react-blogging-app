package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CommentDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.impl.CommentServiceImpl;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	// http://localhost:8080/comment/create-comment/1
	@PostMapping("/create-comment/{postId}")
	public ResponseEntity<?> createComment(@Valid @RequestBody CommentDto commentDto, @PathVariable int postId) {
		CommentDto savedCommentDto = this.commentServiceImpl.createComment(commentDto, postId);

		return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
	}

	// http://localhost:8080/comment/delete-comment/3
	// DELETION NOT WORKING...
	@DeleteMapping("/delete-comment/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable int commentId) {
		String message = this.commentServiceImpl.deleteComment(commentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
