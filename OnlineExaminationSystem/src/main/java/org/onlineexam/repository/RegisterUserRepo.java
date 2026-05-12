package org.onlineexam.repository;

import org.onlineexam.model.UserModel;

public interface RegisterUserRepo {
    public boolean isRegisterUser(UserModel userModel);
}
