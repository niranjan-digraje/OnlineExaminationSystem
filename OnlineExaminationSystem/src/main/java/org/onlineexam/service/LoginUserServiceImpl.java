package org.onlineexam.service;

import org.onlineexam.repository.LoginUserRepo;
import org.onlineexam.repository.LoginUserRepoImpl;

public class LoginUserServiceImpl implements LoginUserService {
    LoginUserRepo loginUserRepo = new LoginUserRepoImpl();
    @Override
    public String getRole(String email, String password) {
        // TODO Auto-generated method stub
        return loginUserRepo.getRole(email, password);
    }

}
