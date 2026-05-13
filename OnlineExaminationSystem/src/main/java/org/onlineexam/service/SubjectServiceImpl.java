package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;
import org.onlineexam.repository.SubjectRepository;
import org.onlineexam.repository.SubjectRepositoryImpl;

public class SubjectServiceImpl implements SubjectService {

    SubjectRepository repo = new SubjectRepositoryImpl();

    @Override
    public boolean isAddSubject(SubjectModel model) {
        return repo.isAddSubject(model);
    }

    @Override
    public List<CourseModel> getAllCourses() {
        return repo.getAllCourses();
    }

    @Override
    public List<SubjectModel> getAllSubjects() {
        return repo.getAllSubjects();
    }

    @Override
    public boolean isDeleteSubject(int subjectId) {
        return repo.isDeleteSubject(subjectId);
    }

    @Override
    public SubjectModel getSubjectById(int subjectId) {
        return repo.getSubjectById(subjectId);
    }

    
    @Override
    public SubjectModel fetchSubjectById(int subjectId) {

        return repo.fetchSubjectById(subjectId);
    }

    @Override
    public boolean isUpdateSubject(SubjectModel model) {

        return repo.isUpdateSubject(model);
    }

    @Override
public List<SubjectModel> getExamAllSubjects() {

    return repo.getAllSubjects();
}
}