package com.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.Optional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String userName);
}
