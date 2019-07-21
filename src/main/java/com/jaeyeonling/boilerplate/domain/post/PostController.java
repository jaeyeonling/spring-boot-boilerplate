package com.jaeyeonling.boilerplate.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponse> findAll() {
        return postService.findAll()
                .stream()
                .map(PostResponse::new)
                .collect(toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponse findBy(@PathVariable final long id) {
        return postService.findBy(id)
                .map(PostResponse::new)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse save(@RequestBody @Valid final PostSaveRequest postSaveRequest) {
        return new PostResponse(postService.save(postSaveRequest.toEntity()));
    }
}
