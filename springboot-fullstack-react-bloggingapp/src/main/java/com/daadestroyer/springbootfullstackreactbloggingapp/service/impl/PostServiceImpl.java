package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CategoryDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.helper.PostResponse;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Category;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Post;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.CategoryRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.PostRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.PostService;

import net.bytebuddy.asm.Advice.This;

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
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		post.setTitle(postDto.getPostTitle());
		post.setPostContent(postDto.getPostContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto getPost(int postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getAllPost(int pageNumber, int pageSize, String sortBy, String sortDir) {

		Sort sort = null;

		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		/*
		 * Pageable pageable = PageRequest.of(pageNumber, pageSize,
		 * Sort.by(sortBy).descending(); we can fetch data on the basis of ascending or
		 * descending order
		 */

		Page<Post> pagePost = this.postRepo.findAll(pageable);

		List<Post> allPost = pagePost.getContent();

		List<PostDto> listOfPost = allPost.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();

		postResponse.setContent(listOfPost);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		return postResponse;
	}

	@Override
	public String deletePost(int postId) {
		Post savedPost = this.postRepo.findById(postId)

				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		this.postRepo.delete(savedPost);
		return "Post " + postId + " is deleted....";
	}

	@Override
	public List<PostDto> getPostByCategoryId(int catId) {
		Category savedCategory = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catId));

		List<PostDto> postByCategory = this.postRepo.findByCategory(savedCategory).stream()
				.map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		return postByCategory;
	}

	@Override
	public List<PostDto> getPostByUserId(int userId) {
		User savedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		List<PostDto> postByUser = this.postRepo.findByUser(savedUser).stream()
				.map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		return postByUser;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<PostDto> postDto = this.postRepo.findByTitleContaining(keyword).stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

}
