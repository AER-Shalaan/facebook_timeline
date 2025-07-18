package com.example.facebooktimeline;
import java.util.ArrayList;

public class PostData {
    private String name;
    private String description;
    private String time;
    private  boolean hasLikes;
    public PostData(String name, String description, String time , boolean hasLikes) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.hasLikes = hasLikes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
    public boolean getHasLikes(){
        return hasLikes;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasLikes(boolean hasLikes){
        this.hasLikes = hasLikes;
    }

    public static ArrayList<PostData> getPosts() {
        ArrayList<PostData> posts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            posts.add(new PostData("user " + i, "Description" + i, i+" hours ago", i % 2 == 0));
        }
        return posts;
        }
    }

