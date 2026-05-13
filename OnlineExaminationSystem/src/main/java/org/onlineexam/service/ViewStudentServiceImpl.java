package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.UserModel;
import org.onlineexam.repository.ViewStudentRepo;
import org.onlineexam.repository.ViewStudentRepoImpl;

public class ViewStudentServiceImpl
implements ViewStudentService {

    ViewStudentRepo repo =
            new ViewStudentRepoImpl();

    @Override
    public List<UserModel> getAllStudents() {

        return repo.getAllStudents();
    }

    @Override
    public boolean isDeleteStudent(int userId) {

        return repo.isDeleteStudent(userId);
    }

    @Override
    public UserModel getStudentById(int id) {

        return repo.getStudentById(id);
    }

    @Override
    public boolean isUpdateStudent(UserModel model) {

        return repo.isUpdateStudent(model);
    }
}