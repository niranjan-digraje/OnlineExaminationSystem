package org.onlineexam.model;

public class UserModel {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userMobile;
    private String userGender;
    private int userCourseId;
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
        this.userCourseId = userCourseId;
    }
}
