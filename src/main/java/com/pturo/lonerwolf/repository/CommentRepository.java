package com.pturo.lonerwolf.repository;

import com.pturo.lonerwolf.model.Comment;
import com.pturo.lonerwolf.model.Post;
import com.pturo.lonerwolf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}
