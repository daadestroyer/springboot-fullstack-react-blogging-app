package com.daadestroyer.springbootfullstackreactbloggingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
