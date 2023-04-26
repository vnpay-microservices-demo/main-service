package com.example.mainservice.service;

import java.util.Map;

public interface CacheService {
    void delete(String key);
    void delete(String key, String field);
    Map<String, Object> get(String key);
    Object get(String key, String field);
    void set(String key, Map<String, Object> hashmap);
    void set(String key, String field, Object value);
}
