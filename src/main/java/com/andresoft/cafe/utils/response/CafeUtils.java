package com.andresoft.cafe.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CafeUtils {

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
