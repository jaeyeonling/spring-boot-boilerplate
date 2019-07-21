package com.jaeyeonling.boilerplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class PostService {

    private final PostRepository postRepository;

    Post save(final Post post) {
        return postRepository.save(post);
    }

    List<Post> findAll() {
        return postRepository.findAll();
    }

    Optional<Post> findBy(final long id) {
        return postRepository.findById(id);
    }
}
