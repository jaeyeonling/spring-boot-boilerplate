package com.jaeyeonling.boilerplate.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class PostResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String title;
    private String content;
    private String author;

    PostResponse(final Post post) {
        this.id = post.getId();
        this.createdDate = post.getCreatedDate();
        this.lastModifiedDate = post.getLastModifiedDate();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
