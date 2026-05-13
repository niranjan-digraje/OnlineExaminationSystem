package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.repository.ExamRepository;
import org.onlineexam.repository.ExamRepositoryImpl;

public class ExamServiceImpl implements ExamService {

    ExamRepository repo =
            new ExamRepositoryImpl();

    @Override
    public boolean isAddExam(ExamModel model) {

        return repo.isAddExam(model);
    }
    @Override
public List<ExamModel> getAllExams() {

    return repo.getAllExams();
}
}