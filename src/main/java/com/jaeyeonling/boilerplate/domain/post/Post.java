package com.jaeyeonling.boilerplate.domain.post;

import com.jaeyeonling.boilerplate.global.entity.DateAuditEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends DateAuditEntity {

    @Getter
    @Column(length = 500, nullable = false)
    private String title;

    @Getter
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Getter
    @Column
    private String author;

    @Builder
    public Post(final String title,
                final String content,
                final String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
