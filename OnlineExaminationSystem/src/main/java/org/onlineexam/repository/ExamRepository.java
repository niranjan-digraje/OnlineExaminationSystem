package org.onlineexam.repository;

import java.util.List;

import org.onlineexam.model.ExamModel;

public interface ExamRepository {

    public boolean isAddExam(ExamModel model);
    public List<ExamModel> getAllExams();
}