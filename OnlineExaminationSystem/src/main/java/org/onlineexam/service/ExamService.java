package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.ExamModel;

public interface ExamService {

    public boolean isAddExam(ExamModel model);
    public List<ExamModel> getAllExams();
}