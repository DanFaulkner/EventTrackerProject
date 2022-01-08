package com.skilldistillery.lifttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.lifttracker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
