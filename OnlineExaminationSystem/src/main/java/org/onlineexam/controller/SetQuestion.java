package org.onlineexam.controller;

import java.io.IOException;
import java.util.List;

import org.onlineexam.model.ExamModel;
import org.onlineexam.model.QuestionModel;
import org.onlineexam.service.ExamService;
import org.onlineexam.service.ExamServiceImpl;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.QuestionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/setquestion")
public class SetQuestion extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // ================= GET ALL EXAMS =================

        ExamService examService =
                new ExamServiceImpl();

        List<ExamModel> examList =
                examService.getAllExams();

        // ================= GET ALL QUESTIONS =================

        QuestionService questionService =
                new QuestionServiceImpl();

        List<QuestionModel> questionList =
                questionService.getAllQuestions();

        // ================= SET ATTRIBUTES =================

        request.setAttribute("exams", examList);

        request.setAttribute("questions", questionList);

        // ================= FORWARD JSP =================

        request.getRequestDispatcher(
                "HTML/TEACHER/setexam.jsp")
                .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int examId =
                Integer.parseInt(
                        request.getParameter("examId"));

        String question =
                request.getParameter("question");

        String optionA =
                request.getParameter("optionA");

        String optionB =
                request.getParameter("optionB");

        String optionC =
                request.getParameter("optionC");

        String optionD =
                request.getParameter("optionD");

        String correctAnswer =
                request.getParameter("correctAnswer");

        QuestionModel model =
                new QuestionModel();

        model.setExamId(examId);

        model.setQuestionText(question);

        model.setOptionA(optionA);

        model.setOptionB(optionB);

        model.setOptionC(optionC);

        model.setOptionD(optionD);

        model.setCorrectAnswer(correctAnswer);

        QuestionService service =
                new QuestionServiceImpl();

        boolean result =
                service.isAddQuestion(model);

        if(result){

            response.sendRedirect("/OnlineExaminationSystem/getallquestions");

        }else{

            response.getWriter().println(
                    "Question Not Added");
        }
    }
}