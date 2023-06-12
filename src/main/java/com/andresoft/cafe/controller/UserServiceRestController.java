package com.andresoft.cafe.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andresoft.cafe.service.interfaces.IUserService;
import com.andresoft.cafe.utils.constants.CafeConstants;
import com.andresoft.cafe.utils.response.CafeUtils;

@RestController
@RequestMapping(path = "/user")
public class UserServiceRestController {

    @Autowired
    private IUserService userService;

    @RequestMapping(
        value = "/singup",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> singUp(@RequestBody(required = true) Map<String, String> requestMap ) {
        try {
            return userService.singUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(
        value = "/login",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap ) {
        try {
            return userService.login(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
