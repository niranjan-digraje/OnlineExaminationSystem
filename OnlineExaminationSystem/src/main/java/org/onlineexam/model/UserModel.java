package org.onlineexam.model;

public class UserModel {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userMobile;
    private String userGender;
    private int userCourseId;
    private String courseName;
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserCourseId() {
        return userCourseId;
    }

    public void setUserCourseId(int userCourseId) {
        System.out.println("SETTING COURSE ID = " + userCourseId);
        this.userCourseId = userCourseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        System.out.println("Usermodel : "+courseName);
        this.courseName = courseName;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserModel [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
                + userPassword + ", userMobile=" + userMobile + ", userGender=" + userGender + ", userCourseId="
                + userCourseId + ", courseName=" + courseName + ", role=" + role + "]";
    }

}
