package com.social.network.controllers;

import com.social.network.dao.UserRepository;
import com.social.network.entities.Post;
import com.social.network.entities.User;
import com.social.network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserRepository userRepository;
    @PostMapping("addpost")
    public ResponseEntity<Post> addPost(@RequestBody Post post) throws NullPointerException {
        //UserDto user = securityService.getUser();
        //User user = post.getUser();
        //User user = userRepository.findUserById(id);
       // post.setUser(user);

        //post.setUser(user);
        Post savedPost = postService.createPost(post);
        return ResponseEntity.ok(savedPost);
    }

   /* @GetMapping("mypost")
    public ResponseEntity<?> myPosts() throws NullPointerException {
       // User user=userService.getUser(securityService.getUser().getEmail());
        List<Post> postList = postService.getPostsOfUser(user.getId());
        return ResponseEntity.ok(postList);
    }*/

    @GetMapping("posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> postList = postService.getAllPost();
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getPostofUser(@PathVariable Integer userId){
        List<Post> postList = postService.getPostsOfUser(userId);
        return ResponseEntity.ok(postList);
    }

}
