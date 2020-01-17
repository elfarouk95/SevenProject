package com.app.sevenproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostHolder extends RecyclerView.ViewHolder {

    TextView Name;
    TextView PostDes;
    Button Comment;

    public PostHolder(@NonNull View itemView) {
        super(itemView);

        Name = itemView.findViewById(R.id.Name);
        PostDes = itemView.findViewById(R.id.PostDes);
        Comment = itemView.findViewById(R.id.Comment);

    }
}
