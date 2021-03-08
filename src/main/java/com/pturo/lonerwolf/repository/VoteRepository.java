package com.pturo.lonerwolf.repository;

import com.pturo.lonerwolf.model.Post;
import com.pturo.lonerwolf.model.User;
import com.pturo.lonerwolf.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
