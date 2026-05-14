package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.QuestionModel;
import org.onlineexam.repository.QuestionRepository;
import org.onlineexam.repository.QuestionRepositoryImpl;

public class QuestionServiceImpl implements QuestionService {

    QuestionRepository repository =
            new QuestionRepositoryImpl();

    @Override
    public QuestionModel getQuestionById(int questionId) {
        // TODO Auto-generated method stub
        return repository.getQuestionById(questionId);
    }

    @Override
    public boolean isDeleteQuestion(int questionId) {
        // TODO Auto-generated method stub
        return repository.isDeleteQuestion(questionId);
    }

    @Override
    public boolean isUpdateQuestion(QuestionModel model) {
        // TODO Auto-generated method stub
        return repository.isUpdateQuestion(model);
    }

    @Override
    public boolean isAddQuestion(QuestionModel model) {

        return repository.isAddQuestion(model);
    }

    @Override
    public List<QuestionModel> getAllQuestions() {

        return repository.getAllQuestions();
    }

    @Override
    public List<QuestionModel> getQuestionsByExamId(int examId) {
        // TODO Auto-generated method stub
        return repository.getQuestionsByExamId(examId);
    }
}