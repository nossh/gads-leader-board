package com.example.gadsleaderboard;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<ListLearners> listLearners;

    public Adapter(Context ctx, List<ListLearners> listLearners) {
        this.inflater = LayoutInflater.from(ctx);
        this.listLearners = listLearners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.learnerName.setText(listLearners.get(position).getLeanerName());
        viewHolder.learnerHour.setText(listLearners.get(position).getLeanerHour());
        viewHolder.learnerCountry.setText(listLearners.get(position).getLearnerCountry());
    }

    @Override
    public int getItemCount() {
        return listLearners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView learnerName, learnerHour, learnerCountry;
        ImageView learnerBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.learner_name);
            learnerHour = itemView.findViewById(R.id.learner_hour);
            learnerCountry = itemView.findViewById(R.id.learner_country);
        }
    }
}
