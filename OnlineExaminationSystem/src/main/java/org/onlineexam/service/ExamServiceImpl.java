package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.repository.ExamRepository;
import org.onlineexam.repository.ExamRepositoryImpl;

public class ExamServiceImpl implements ExamService {

    ExamRepository repo =
            new ExamRepositoryImpl();

    @Override
    public List<ExamModel> getStudentExams(String email) {
        // TODO Auto-generated method stub
        return repo.getStudentExams(email);
    }
    @Override
    public boolean isAddExam(ExamModel model) {

        return repo.isAddExam(model);
    }
    @Override
public List<ExamModel> getAllExams() {

    return repo.getAllExams();
}
    @Override
    public ExamModel getExamById(int examId) {
        // TODO Auto-generated method stub
        return repo.getExamById(examId);
    }
}