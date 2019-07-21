package com.jaeyeonling.boilerplate.domain.post;

import com.jaeyeonling.boilerplate.support.RepositorySupports;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PostRepositoryTests extends RepositorySupports {

    @Autowired
    private PostRepository postRepository;

    @DisplayName("포스트를 등록하고 조회한다.")
    @Test
    void saveAndFind() {
        // given
        final var post = Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();
        postRepository.save(post);

        // when
        final var posts = postRepository.findAll();
        final var findPost = posts.get(0);

        // then
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getContent()).isEqualTo(post.getContent());
        assertThat(findPost.getAuthor()).isEqualTo(post.getAuthor());
    }
}
