package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import javax.websocket.server.ServerEndpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CommentDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Comment;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Post;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.CommentRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.PostRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, int postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		// this we are setting because , many comments belongs to one post
		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public String deleteComment(int commentId) {
		Comment savedComment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
		this.commentRepo.delete(savedComment);
		return "Comment " + commentId + " deleted...";
	}

}
