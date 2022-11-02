package com.social.network.dao;

import com.social.network.entities.Post;
import com.social.network.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findPostByUserOrderById(User user);

    List<Post> findAllByOrderByIdDesc();
    Post save(Post post);
}