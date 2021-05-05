package com.example.SpringMaster.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// FeignClient to take APIs to use
@FeignClient(
        value = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceHolderClient {

    //  Using /posts
    @GetMapping("posts")
    List<Post> getPosts();

    //  Getting all Posts
    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") Integer postId);
}
