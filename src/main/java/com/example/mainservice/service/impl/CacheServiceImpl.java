package com.example.mainservice.service.impl;

import com.example.mainservice.service.CacheService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CacheServiceImpl implements CacheService {
    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(String key, String field) {

    }

    @Override
    public Map<String, Object> get(String key) {
        return null;
    }

    @Override
    public Object get(String key, String field) {
        return null;
    }

    @Override
    public void set(String key, Map<String, Object> hashmap) {

    }

    @Override
    public void set(String key, String field, Object value) {

    }
}
