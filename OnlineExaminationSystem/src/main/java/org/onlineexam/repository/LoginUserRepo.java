package org.onlineexam.repository;

public interface LoginUserRepo {
     public String getRole(String email,String password);
     public String getUserName(String email);
}
