package com.pturo.lonerwolf.service;

import com.pturo.lonerwolf.dto.PostRequest;
import com.pturo.lonerwolf.dto.PostResponse;
import com.pturo.lonerwolf.exceptions.LonerWolfException;
import com.pturo.lonerwolf.exceptions.PostNotFoundException;
import com.pturo.lonerwolf.exceptions.SubwolfNotFoundException;
import com.pturo.lonerwolf.mapper.PostMapper;
import com.pturo.lonerwolf.model.Post;
import com.pturo.lonerwolf.model.Subwolf;
import com.pturo.lonerwolf.model.User;
import com.pturo.lonerwolf.repository.PostRepository;
import com.pturo.lonerwolf.repository.SubwolfRepository;
import com.pturo.lonerwolf.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final SubwolfRepository subwolfRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Subwolf subwolf = subwolfRepository.findByName(postRequest.getSubwolfName())
                .orElseThrow(() -> new SubwolfNotFoundException(postRequest.getSubwolfName()));
        User currentUser = authService.getCurrentUser();

        postRepository.save(postMapper.map(postRequest, subwolf, currentUser));
    }

    @Transactional
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional()
    public List<PostResponse> getPostsBySubwolf(Long subwolfId) {
        Subwolf subwolf = subwolfRepository.findById(subwolfId)
                .orElseThrow(() -> new LonerWolfException(subwolfId.toString()));
        List<Post> posts = postRepository.findAllBySubwolf(subwolf);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional()
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
