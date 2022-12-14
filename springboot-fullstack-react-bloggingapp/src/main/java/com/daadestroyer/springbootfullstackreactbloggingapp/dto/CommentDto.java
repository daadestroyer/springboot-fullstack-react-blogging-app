package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	
	private int id;

	@NotEmpty(message = "please enter comment")
	@Size(min = 2, message = "comment can't be less than length of  length 2 ")
	private String content;
}
