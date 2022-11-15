package com.daadestroyer.springbootfullstackreactbloggingapp.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "postContent", nullable = false, length = 10000)
	private String postContent;

	@Column(name = "imageName", columnDefinition = "varchar(255) default 'default.png'")
	private String imageName;

	@Column(name = "addedDate")
	@CreationTimestamp
	private LocalDateTime addedDate;

	// this Post entity belongs to one User at a time
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// this Post entity belongs to one category at a time
	@ManyToOne
	@JoinColumn(name = "catId")
	private Category category;

 
	
	
}
