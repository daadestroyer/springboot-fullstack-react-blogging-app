package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CategoryDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Category;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Post;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.CategoryRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.PostRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, int userId, int categoryId) {
		User savedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		Category savedCategory = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		postDto.setImageName("default.png");
		postDto.setUser(this.modelMapper.map(savedUser, UserDto.class));

		postDto.setCategory(this.modelMapper.map(savedCategory, CategoryDto.class));

		Post post = this.postRepo.save(this.modelMapper.map(postDto, Post.class));

		return this.modelMapper.map(post, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, int postId) {
		//Post savedPost = this.postRepo.findById(postId)
		//		.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		return null;
	}

	@Override
	public PostDto getPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
