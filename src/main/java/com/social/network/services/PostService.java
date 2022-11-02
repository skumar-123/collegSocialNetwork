package com.social.network.services;

import com.social.network.dao.PostRepository;
import com.social.network.dao.UserRepository;
import com.social.network.dto.PostDto;
import com.social.network.entities.Post;
import com.social.network.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;


/*
    @Autowired
    SecurityService securityService;*/

    public Post createPost(Post post){

       // User user = userRepository.findUserByEmail(userDto.getEmail());
        return postRepository.save(post);
    }

    public List<Post> getPostsOfUser(Integer userId){
        List<Post> postList= postRepository.findPostByUserOrderById(userRepository.findUserById(userId));

        return postList;
    }

    public List<Post> getAllPost(){
        return postRepository.findAllByOrderByIdDesc();
    }

}
