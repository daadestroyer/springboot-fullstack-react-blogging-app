package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private int postId;

	@Column(name = "title", nullable = false, length = 100)
	private String postTitle;

	@Column(name = "postContent", nullable = false, length = 10000)
	private String postContent;

	@Column(name = "imageName", columnDefinition = "varchar(255) default 'default.png'")
	private String imageName;

	@Column(name = "addedDate")
	@CreationTimestamp
	private LocalDateTime addedDate;

	
	private CategoryDto category;
	
	private UserDto user;

}
