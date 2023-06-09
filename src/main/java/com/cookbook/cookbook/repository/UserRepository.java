package com.cookbook.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.cookbook.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
