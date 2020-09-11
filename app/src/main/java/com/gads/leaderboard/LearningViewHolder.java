package com.gads.leaderboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearningViewHolder extends RecyclerView.ViewHolder {

    ImageView logo;
    TextView name;
    TextView hours;
    TextView country;

    public LearningViewHolder(@NonNull View itemView) {
        super(itemView);
       logo = itemView.findViewById(R.id.imageLogo);
       name = itemView.findViewById(R.id.textViewName);
       hours = itemView.findViewById(R.id.textViewAmount);
       country = itemView.findViewById(R.id.textViewCountry);
    }
}
