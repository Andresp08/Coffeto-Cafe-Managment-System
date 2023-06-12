package com.andresoft.cafe.service.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<String> singUp(Map<String, String> requestMap);
    public ResponseEntity<String> login(Map<String, String> requestMap);
}
