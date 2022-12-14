package com.daadestroyer.springbootfullstackreactbloggingapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.PostDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Category;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Post;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	public List<Post> findByUser(User user);

	public List<Post> findByCategory(Category category);

	public List<Post> findByTitleContaining(String title);
}
