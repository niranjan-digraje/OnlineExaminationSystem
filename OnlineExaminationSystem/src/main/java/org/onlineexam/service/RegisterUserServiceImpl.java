package org.onlineexam.service;

import org.onlineexam.model.UserModel;
import org.onlineexam.repository.RegisterUserRepo;
import org.onlineexam.repository.RegisterUserRepoImpl;

public class RegisterUserServiceImpl implements RegisterUserService{
    RegisterUserRepo repo = new RegisterUserRepoImpl();
    @Override
    public boolean isRegisterUser(UserModel userModel) {
        // TODO Auto-generated method stub
        return repo.isRegisterUser(userModel);
    }
    @Override
    public String getUserName(String email) {
        // TODO Auto-generated method stub
        return repo.getUserName(email);
    }

}
