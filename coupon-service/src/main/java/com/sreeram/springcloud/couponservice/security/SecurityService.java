package com.sreeram.springcloud.couponservice.security;

public interface SecurityService {

    boolean login(String username, String password);
}
