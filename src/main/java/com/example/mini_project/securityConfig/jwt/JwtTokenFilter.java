package com.example.mini_project.securityConfig.jwt;

import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request , HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{
        if(!hasAuthorizationBearer(request)){
            filterChain.doFilter(request, response);
            return;
        }
        setAuthenticationContex(token, request);
        filterChain.doFilter(request,response);

    }
    setAuthenticationContex(token, request)
}
