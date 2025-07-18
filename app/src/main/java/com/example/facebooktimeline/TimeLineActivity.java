package com.example.facebooktimeline;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class TimeLineActivity extends AppCompatActivity {
    PostAdapter postAdapter;
    RecyclerView postsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postAdapter = new PostAdapter(PostData.getPosts());
        postsRecyclerView.setAdapter(postAdapter);

        postAdapter.onLikeClickListener = (position, postData) -> {
            postData.setHasLikes(!postData.getHasLikes());
            postAdapter.updateData(postData, position);
        };
    }
}