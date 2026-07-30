package com.learning.openfeign_service.service;

import com.learning.openfeign_service.model.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "posts", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostsService {

    @GetMapping
    public List<Posts> getAllPosts();
}
