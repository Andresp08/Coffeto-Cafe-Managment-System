package com.andresoft.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.andresoft.cafe.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(@Param("email") String email);
}
