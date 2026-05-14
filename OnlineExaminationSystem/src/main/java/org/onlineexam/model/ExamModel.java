package org.onlineexam.model;

public class ExamModel {

    private int examId;
    private String examTitle;
    private int subjectId;
    private int totalQuestions;
    private int totalMarks;
    private int durationMinutes;
    private String examDate;
    private String startTime;
    private String endTime;
    private String examDateString;


private String startTimeString;

private String endTimeString;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamDateString() {
    return examDateString;
}

public void setExamDateString(String examDateString) {
    this.examDateString = examDateString;
}

public String getStartTimeString() {
    return startTimeString;
}

public void setStartTimeString(String startTimeString) {
    this.startTimeString = startTimeString;
}

public String getEndTimeString() {
    return endTimeString;
}

public void setEndTimeString(String endTimeString) {
    this.endTimeString = endTimeString;
}
}