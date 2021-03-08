package com.pturo.lonerwolf.repository;

import com.pturo.lonerwolf.model.Post;
import com.pturo.lonerwolf.model.Subwolf;
import com.pturo.lonerwolf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubwolf(Subwolf subwolf);
    List<Post> findByUser(User user);
}
