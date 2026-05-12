package org.onlineexam.service;

import org.onlineexam.model.UserModel;

public interface RegisterUserService {
    public boolean isRegisterUser(UserModel userModel);
    public String getUserName(String email);
}
