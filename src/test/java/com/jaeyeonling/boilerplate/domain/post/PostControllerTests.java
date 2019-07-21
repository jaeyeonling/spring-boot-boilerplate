package com.jaeyeonling.boilerplate.domain.post;

import com.jaeyeonling.boilerplate.global.exception.ErrorStatus;
import com.jaeyeonling.boilerplate.support.ControllerSupports;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostControllerTests extends ControllerSupports {

    @DisplayName("포스트를 등록하고 리턴값을 검증한다.")
    @Test
    void save() throws Exception {
        final var postSaveRequest = PostSaveRequest.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();

        post(postSaveRequest, "/posts")
                .andExpect(status().isCreated())
                .andExpect(jsonPath("title").value(postSaveRequest.getTitle()))
                .andExpect(jsonPath("content").value(postSaveRequest.getContent()))
                .andExpect(jsonPath("author").value(postSaveRequest.getAuthor()));
    }

    @DisplayName("포스트 등록 시 제약조건을 확인한다.")
    @Test
    void saveCheckConstraints() throws Exception {
        final var postSaveRequest = PostSaveRequest.builder()
                .title("title".repeat(1_000))
                .content("content")
                .author("author")
                .build();

        post(postSaveRequest, "/posts")
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(ErrorStatus.METHOD_ARGUMENT_NOT_VALID.getCode()))
                .andExpect(jsonPath("message").value(ErrorStatus.METHOD_ARGUMENT_NOT_VALID.name()));
    }

    @DisplayName("포스트를 등록하고 리턴값을 검증한다.")
    @Test
    void findAll() throws Exception {
        get("/posts")
                .andExpect(status().isOk());
    }

    @DisplayName("포스트 상세 정보를 조회한다.")
    @Test
    void findById() throws Exception {
        save();

        get(String.format("/posts/%d", 1))
                .andExpect(status().isOk());
    }

    @DisplayName("포스트 상세 정보 조회 시 없는 아이디일 경우 에러를 발생한다.")
    @Test
    void findByIdThrow() throws Exception {
        get(String.format("/posts/%d", 999_999_999))
                .andExpect(status().isNotFound());
    }

}
