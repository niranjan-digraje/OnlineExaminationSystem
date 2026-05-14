package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.QuestionModel;

public interface QuestionService {

    public boolean isAddQuestion(QuestionModel model);

    public List<QuestionModel> getAllQuestions();

    public boolean isDeleteQuestion(int questionId);

public QuestionModel getQuestionById(int questionId);

public boolean isUpdateQuestion(QuestionModel model);
public List<QuestionModel> getQuestionsByExamId(int examId);

}