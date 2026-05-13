package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.UserModel;
import org.onlineexam.repository.StudentRepository;
import org.onlineexam.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

    StudentRepository repo = new StudentRepositoryImpl();

    @Override
    public List<UserModel> getAllStudents() {

        return repo.getAllStudents();
    }

    @Override
    public boolean isDeleteStudent(int id) {

        return repo.isDeleteStudent(id);
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