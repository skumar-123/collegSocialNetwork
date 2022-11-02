package com.social.network;

import com.social.network.dao.UserRepository;
import com.social.network.entities.Role;
import com.social.network.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;
@ComponentScan(basePackages={"com.social.network"})
@EnableJpaRepositories(basePackages="com.social.network.dao")
@SpringBootApplication
public class CollegeSocialNetworkApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CollegeSocialNetworkApplication.class, args);
		UserRepository usersRepository = context.getBean(UserRepository.class);
		usersRepository.save(createUserObject1());
		usersRepository.save(createUserObject2());
	}
	private static User createUserObject1() {
		User user = new User();
		user.setFirstName("sandeep");
		user.setLastName("kumar");
		user.setId(1L);
		user.setEmail("sandeep@gmail.com");
		user.setImage("imageurl1");
		Role role1 = new Role();
		role1.setName("Admin");
		Role role2 = new Role();
		role1.setName("User");
		List<Role> roles = new ArrayList<>();
		roles.add(role1);
		roles.add(role2);
		user.setRoles(roles);
		return user;
	}
	private static User createUserObject2() {
		User user = new User();
		user.setFirstName("yash");
		user.setLastName("kumar");
		user.setId(2L);
		user.setEmail("yash@gmail.com");
		user.setImage("imageurl2");
		Role role = new Role();
		role.setName("User");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		return user;
	}
}
