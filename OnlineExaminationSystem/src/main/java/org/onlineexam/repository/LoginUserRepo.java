package org.onlineexam.repository;

public interface LoginUserRepo {
     public String getRole(String email,String password);
     public String getUserName(String email);
     public int getUserId(String email,String password);
}
