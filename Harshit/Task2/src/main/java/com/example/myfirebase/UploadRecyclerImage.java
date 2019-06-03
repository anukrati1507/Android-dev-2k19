package com.example.myfirebase;

public class UploadRecyclerImage {

    String title,desc,image,likeDislike;

    public UploadRecyclerImage(){

    }

    public UploadRecyclerImage(String title, String desc, String image,String likeDislike) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.likeDislike = likeDislike;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(String likeDislike) {
        this.likeDislike = likeDislike;
    }
}
