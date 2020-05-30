package com.softper.ts.Security.services;

public interface ISecurityService {
    String findLoggedInUsername();

    void autoLogin(String email, String password);
}