package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.SubjectModel;
import org.onlineexam.model.UserModel;

public interface StudentService {

    public List<UserModel> getAllStudents();

    public boolean isDeleteStudent(int id);
    public UserModel getStudentById(int id);

    public boolean isUpdateStudent(UserModel model);

    
}