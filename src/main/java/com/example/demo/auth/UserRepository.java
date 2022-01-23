package com.example.demo.auth;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
