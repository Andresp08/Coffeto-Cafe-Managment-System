package com.andresoft.cafe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andresoft.cafe.model.User;
import com.andresoft.cafe.wrapper.UserWrapper;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(@Param("email") String email);

    @Query("SELECT new com.andresoft.cafe.wrapper.UserWrapper(u.id,u.name,u.email,u.contactNumber,u.status) FROM User u WHERE u.role = 'user'")
    public List<UserWrapper> findAllUsers();

    @Query("SELECT u.email FROM User u WHERE u.role = 'admin'")
    public List<String> findAllAdmin();

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status=:status WHERE u.id=:id")
    public Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
}
