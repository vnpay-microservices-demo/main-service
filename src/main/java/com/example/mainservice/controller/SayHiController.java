package com.example.mainservice.controller;

import com.example.mainservice.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/main")
public class SayHiController {
    @Autowired
    private RedisCacheService cacheService;
    @GetMapping("/hello")
    public ResponseEntity<?> sayHi(@RequestHeader String sessionId, @RequestHeader String token){
        if(cacheService.get(sessionId) == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if(!cacheService.get(sessionId).equals(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok("hello world!");
    }
}
