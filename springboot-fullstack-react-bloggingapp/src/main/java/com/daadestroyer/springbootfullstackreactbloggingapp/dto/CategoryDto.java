package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {

	private int catId;

	@NotEmpty(message = "please enter category name")
	@Size(min = 5, max = 30, message = "category title can't be less than length of 2 or more than 30")
	private String catTitle;

	@NotEmpty(message = "please enter category description")
	@Size(min = 10, max = 100, message = "category description can't be less than length of 10 or more than 100")
	private String catDesc;
}
