package org.onlineexam.repository;

import java.util.List;
import org.onlineexam.model.CourseModel;

public interface CourseRepository {

    public List<CourseModel> getAllCourses();
}