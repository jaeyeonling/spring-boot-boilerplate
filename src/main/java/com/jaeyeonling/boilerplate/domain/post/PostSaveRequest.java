package com.jaeyeonling.boilerplate.domain.post;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostSaveRequest {

    @Size(max = 500)
    private String title;

    private String content;
    private String author;

    @Builder
    public PostSaveRequest(final String title,
                           final String content,
                           final String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
