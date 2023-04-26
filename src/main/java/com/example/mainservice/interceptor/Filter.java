package com.example.mainservice.interceptor;

import com.example.mainservice.constant.CacheConstant;
import com.example.mainservice.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@Component
@AllArgsConstructor
public class Filter extends OncePerRequestFilter {
    private final CacheService cacheService;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String accessToken = request.getHeader("Authorization");
        final String sessionId = request.getHeader("SessionId");
        if (Objects.isNull(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!accessToken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String tokenFromCache = (String) cacheService.get(CacheConstant.KEY_CACHE_ACCESS_TOKEN,sessionId);
        if(!tokenFromCache.equals(accessToken)){
            filterChain.doFilter(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
