package com.social.network.dao;

import com.social.network.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer userId);
}
