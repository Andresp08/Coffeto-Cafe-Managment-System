package com.andresoft.cafe.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.andresoft.cafe.wrapper.UserWrapper;

public interface IUserService {
    public ResponseEntity<String> singUp(Map<String, String> requestMap);
    public ResponseEntity<String> login(Map<String, String> requestMap);
    public ResponseEntity<List<UserWrapper>> getAllUsers();
    public ResponseEntity<String> updateUserStatus(Map<String,String> requestMap);
}
