package com.demo.spring.springhelloword.repository;

import com.demo.spring.springhelloword.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUsername(String username);
}
