package com.gads.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkillAdaptor extends RecyclerView.Adapter<LearningViewHolder>  {
    ArrayList<Skill>skills;


    public SkillAdaptor(){
        skills = new ArrayList<>();
    }

    public void setData(ArrayList<Skill>skills){
        this.skills = skills;
    }
    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View skillView = inflater.inflate(R.layout.item_leaderboard, parent,false);
        return new LearningViewHolder(skillView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        Skill skill = skills.get(position);
        Picasso.get()
                .load(skill.badgeUrl)
                .into(holder.logo);
        holder.name.setText(skill.name);
        holder.hours.setText(skill.score);
        holder.country.setText(skill.country);

    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}
