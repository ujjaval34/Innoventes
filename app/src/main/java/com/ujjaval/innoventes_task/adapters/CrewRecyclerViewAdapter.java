package com.ujjaval.innoventes_task.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ujjaval.innoventes_task.R;
import com.ujjaval.innoventes_task.models.Crew;

import java.util.List;


/**
 * Crew recyclerview adapter.
 * Adapter that is used by the crew recyclerview.
 */
public class CrewRecyclerViewAdapter extends RecyclerView.Adapter<CrewRecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Crew> crew;

    public CrewRecyclerViewAdapter(Context context, List<Crew> crew) {
        this.context = context;
        this.crew = crew;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.crew_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Assigns the results the the current item's components
        if (crew.get(position).getProfilePath() == "null") {
            Picasso.get().load(R.drawable.profile_placeholder).into(holder.ivProfile);
        } else {
            Picasso.get().load(crew.get(position).getProfileUrl()).into(holder.ivProfile);
        }

        holder.tvName.setText(crew.get(position).getName());
        holder.tvJob.setText(crew.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return crew.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clCrewItem;
        ImageView ivProfile;
        TextView tvName;
        TextView tvJob;

        public MyViewHolder(View itemView) {
            super(itemView);
            // Binds the current view item's components
            clCrewItem = itemView.findViewById(R.id.cl_crew_item);
            ivProfile = itemView.findViewById(R.id.iv_crew_profile);
            tvName = itemView.findViewById(R.id.tv_crew_name);
            tvJob = itemView.findViewById(R.id.tv_crew_job);

            // Set animation on imageview
            Animation fadeInAnimation = AnimationUtils.loadAnimation(clCrewItem.getContext(), R.anim.fade_in);
            ivProfile.startAnimation(fadeInAnimation); //Set animation to your ImageView
        }
    }
}
