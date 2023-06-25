/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Feedback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FeedbackDAO extends ConnectMySQL {

    public ArrayList<Feedback> getFeedbackListByProductId(String productID) {
        ArrayList<Feedback> data = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String sqlSelect = " select FeedbackID, FeedbackID_ProductID, feedbackID_userID, information, f.status, date, name \n"
                    + " from feedback f,user u \n"
                    + " where f.feedbackID_userID=u.userID and f.FeedbackID_ProductID=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String FeedbackID = String.valueOf(rs.getInt(1));
                String FeedbackID_ProductID = String.valueOf(rs.getInt(2));
                String feedbackID_userID = String.valueOf(rs.getInt(3));
                String information = String.valueOf(rs.getString(4));
                String status = String.valueOf(rs.getInt(5));
                String date = null;
                if (rs.getTimestamp(6) != null) {
                    date = String.valueOf(dateFormat.format(rs.getTimestamp(6)));
                }
                String username=rs.getString(7);
                Feedback f = new Feedback(FeedbackID, FeedbackID_ProductID, feedbackID_userID, information, status, date,username);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("getFeedbackListByProductId: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        FeedbackDAO aO = new FeedbackDAO();
        for (Feedback feedback : aO.getFeedbackListByProductId("1")) {
            System.out.println("FeedbackID: " + feedback.getFeedbackID());
            System.out.println("FeedbackID_ProductID: " + feedback.getFeedbackID_ProductID());
            System.out.println("feedbackID_userID: " + feedback.getFeedbackID_userID());
            System.out.println("FeedbackID: " + feedback.getFeedbackID());
            System.out.println("status: " + feedback.getStatus());
            System.out.println("date: " + feedback.getDate());
            System.out.println("username: " + feedback.getUsername());
        }
    }
}
