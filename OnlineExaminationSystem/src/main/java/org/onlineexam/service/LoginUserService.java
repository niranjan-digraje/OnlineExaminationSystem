package org.onlineexam.service;

public interface LoginUserService {
    public String getRole(String email,String password);

    public String getUserName(String email);
    public int getUserId(String email,String password);
}
