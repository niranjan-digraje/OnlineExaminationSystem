package org.onlineexam.repository;

import java.util.List;

import org.onlineexam.model.UserModel;

public interface StudentRepository {

    public List<UserModel> getAllStudents();

    public boolean isDeleteStudent(int id);

    public UserModel getStudentById(int id);

    public boolean isUpdateStudent(UserModel model);
}