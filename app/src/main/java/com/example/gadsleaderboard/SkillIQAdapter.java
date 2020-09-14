package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.ViewHolder> {
    Context context;
    private View view;
    private List<ListSkillIQ> listSkillIQ;

    public SkillIQAdapter(Context ctx, List<ListSkillIQ> listSkillIQ) {
        this.context = ctx;
        this.listSkillIQ = listSkillIQ;
    }

    //@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learners_skilliq_list, parent, false);
        return new SkillIQAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.learnerName.setText(listSkillIQ.get(position).getLeanerName());
        viewHolder.learnerScore.setText(listSkillIQ.get(position).getLeanerScore());
        viewHolder.learnerCountry.setText(listSkillIQ.get(position).getLearnerCountry());
    }

    @Override
    public int getItemCount() {
        return listSkillIQ.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView learnerName, learnerScore, learnerCountry;


        public ViewHolder(View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.learner_iq_name);
            learnerScore = itemView.findViewById(R.id.learner_score);
            learnerCountry = itemView.findViewById(R.id.learner_iq_country);
        }
    }
}
