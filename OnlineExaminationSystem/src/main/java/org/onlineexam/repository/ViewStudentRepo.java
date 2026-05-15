package org.onlineexam.repository;

import java.util.List;

import org.onlineexam.model.UserModel;

public interface ViewStudentRepo {

    public List<UserModel> getAllStudents();

    public boolean isDeleteStudent(int userId);

    public UserModel getStudentById(int id);

    public boolean isUpdateStudent(UserModel model);
}