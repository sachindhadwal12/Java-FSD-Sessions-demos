package com.learning.restwebservice.customresponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String msg, HttpStatus status, Object response, LocalDateTime timestamp){

        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("message", msg);
        responseMap.put("status code ",status);
        responseMap.put("Data", response);
        responseMap.put("time",timestamp);
        return new ResponseEntity<>(responseMap,status);
    }
}
