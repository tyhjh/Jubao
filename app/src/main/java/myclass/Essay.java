package myclass;

import android.graphics.Bitmap;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by Tyhj on 2017/3/1.
 */

public class Essay implements Serializable{
    private String name;
    private String imageUrl;
    private String details;
    private int readed;
    private int likes;
    private boolean isLike;
    private String userHeadImageUrl;
    private String userName;
    private String signature;
    private int id;

    public Essay(String name, String imageUrl, String details, int readed, int likes, boolean isLike, String userHeadImageUrl, String userName, String signature) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.details = details;
        this.readed = readed;
        this.likes = likes;
        this.isLike = isLike;
        this.userHeadImageUrl = userHeadImageUrl;
        this.userName = userName;
        this.signature = signature;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }


    public String getUserHeadImageUrl() {
        return userHeadImageUrl;
    }

    public void setUserHeadImageUrl(String userHeadImageUrl) {
        this.userHeadImageUrl = userHeadImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
