package org.onlineexam.repository;

import java.util.List;

import org.onlineexam.model.CourseModel;
import org.onlineexam.model.SubjectModel;

public interface SubjectRepository {

    public boolean isAddSubject(SubjectModel model);

    public List<CourseModel> getAllCourses();

    public List<SubjectModel> getAllSubjects();

    public boolean isDeleteSubject(int subjectId);

    public SubjectModel getSubjectById(int subjectId);

    public SubjectModel fetchSubjectById(int subjectId);

    public boolean isUpdateSubject(SubjectModel model);
}