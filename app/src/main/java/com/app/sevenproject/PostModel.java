
package com.app.sevenproject;


import com.google.gson.annotations.SerializedName;


public class PostModel {

    @SerializedName("body")
    private String mBody;
    @SerializedName("id")
    private long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("userId")
    private long mUserId;

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

}
