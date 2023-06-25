/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Feedback {

    private String FeedbackID, FeedbackID_ProductID, feedbackID_userID, information, status, date,username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Feedback(String FeedbackID, String FeedbackID_ProductID, String feedbackID_userID, String information, String status, String date,String username) {
        this.FeedbackID = FeedbackID;
        this.FeedbackID_ProductID = FeedbackID_ProductID;
        this.feedbackID_userID = feedbackID_userID;
        this.information = information;
        this.status = status;
        this.date = date;
        this.username=username;
    }

    public Feedback() {
    }

    public String getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(String FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public String getFeedbackID_ProductID() {
        return FeedbackID_ProductID;
    }

    public void setFeedbackID_ProductID(String FeedbackID_ProductID) {
        this.FeedbackID_ProductID = FeedbackID_ProductID;
    }

    public String getFeedbackID_userID() {
        return feedbackID_userID;
    }

    public void setFeedbackID_userID(String feedbackID_userID) {
        this.feedbackID_userID = feedbackID_userID;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
