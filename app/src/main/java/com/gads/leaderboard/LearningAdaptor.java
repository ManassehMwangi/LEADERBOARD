package com.gads.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearningAdaptor extends RecyclerView.Adapter<LearningViewHolder>  {
    ArrayList<Learning>learns;
//    public LearningAdaptor(FragmentManager supportFragmentManager) {
//        learns = new ArrayList<>();
//    }
//
//    public LearningAdaptor(FragmentManager fm, Context context,ArrayList<Learning> learns) {
//        this.learns = learns;
//    }

    public LearningAdaptor() {
        learns = new ArrayList<>();

    }

    public void setData(ArrayList<Learning>learns) {
        this.learns = learns;
    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View learningView = inflater.inflate(R.layout.item_leaderboard, parent,false);
        return new LearningViewHolder(learningView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        Learning learning = learns.get(position);
        Picasso.get()
                .load(learning.badgeUrl)
                .into(holder.logo);
        holder.name.setText(learning.name);
        holder.hours.setText(learning.hours);
        holder.country.setText(learning.country);
    }



        @Override
    public int getItemCount() {
        return learns.size();
//            return 0;
    }
//    public Learning getItem(int i){
//        return learns.get(i);
//    }

}
