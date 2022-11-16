package com.daadestroyer.springbootfullstackreactbloggingapp.service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CommentDto;

public interface CommentService {

	public CommentDto createComment(CommentDto commentDto, int postId);

	public String deleteComment(int commentId);
}
