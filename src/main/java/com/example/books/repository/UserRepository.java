package com.example.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUsername(String username);

}
