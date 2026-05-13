package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.UserModel;

public interface ViewStudentService {
    public List<UserModel> getAllStudents();

    public boolean isDeleteStudent(int userId);

    public UserModel getStudentById(int id);

    public boolean isUpdateStudent(UserModel model);
}
