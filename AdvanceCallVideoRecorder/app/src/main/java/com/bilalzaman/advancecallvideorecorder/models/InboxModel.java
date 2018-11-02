package com.bilalzaman.advancecallvideorecorder.models;

/**
 * Created by BilalZaman on 02/11/2018.
 */
public class InboxModel {

    private String userImage;
    private String userName;
    private String userTimeDate;
    private String userCallMint;

    public InboxModel() {
    }

    public InboxModel(String userImage, String userName, String userTimeDate, String userCallMint) {
        this.userImage = userImage;
        this.userName = userName;
        this.userTimeDate = userTimeDate;
        this.userCallMint = userCallMint;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTimeDate() {
        return userTimeDate;
    }

    public void setUserTimeDate(String userTimeDate) {
        this.userTimeDate = userTimeDate;
    }

    public String getUserCallMint() {
        return userCallMint;
    }

    public void setUserCallMint(String userCallMint) {
        this.userCallMint = userCallMint;
    }
}
