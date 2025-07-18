package com.example.facebooktimeline;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postViewHolder> {
    private final ArrayList<PostData> posts;

    public PostAdapter(ArrayList<PostData> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new postViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        PostData postData = posts.get(position);
        holder.name.setText(postData.getName());
        holder.description.setText(postData.getDescription());
        holder.time.setText(postData.getTime());

        if (postData.getHasLikes()) {
            holder.likeButton.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.fb_bg_color));
            holder.likeButton.setIconTint(ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.getContext(), R.color.fb_bg_color)));
        }
        else{
            holder.likeButton.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.gray_color));
            holder.likeButton.setIconTint(ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.getContext(), R.color.gray_color)));
        }

        holder.likeButton.setOnClickListener(v -> {
            onLikeClickListener.onLikeClick(position, postData);
        });


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updateData(PostData posts , int position) {
        this.posts.set(position, posts);
        notifyItemChanged(position);
    }

    class postViewHolder extends RecyclerView.ViewHolder {
        TextView name = itemView.findViewById(R.id.tvUserName);
        TextView description =itemView.findViewById(R.id.tvPostContent);
        TextView time = itemView.findViewById(R.id.tvTime);
        MaterialButton likeButton = itemView.findViewById(R.id.likeButton);
        public postViewHolder(View itemView) {
            super(itemView);

        }

    }

    OnLikeClickListener onLikeClickListener;

    interface  OnLikeClickListener {
        void onLikeClick(int position, PostData postData);
    }

}
