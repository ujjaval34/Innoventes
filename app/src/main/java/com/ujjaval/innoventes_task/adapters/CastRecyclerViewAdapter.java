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
import com.ujjaval.innoventes_task.models.Cast;

import java.util.List;


/**
 * Cast recyclerview adapter
 * Adapter that is used by the cast recyclerview.
 */
public class CastRecyclerViewAdapter extends RecyclerView.Adapter<CastRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<Cast> cast;

    public CastRecyclerViewAdapter(Context context, List<Cast> cast) {
        this.context = context;
        this.cast = cast;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.cast_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Assigns the results the the current item's components
        if (cast.get(position).getProfilePath() == "null") {
            Picasso.get().load(R.drawable.profile_placeholder).into(holder.ivProfile);
        } else {
            Picasso.get().load(cast.get(position).getProfileUrl()).into(holder.ivProfile);
        }
        holder.tvName.setText(cast.get(position).getName());
        holder.tvCharacter.setText(cast.get(position).getCharacter());
    }

    @Override
    public int getItemCount() {
        return cast.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clCastItem;
        ImageView ivProfile;
        TextView tvName;
        TextView tvCharacter;

        public MyViewHolder(View itemView) {
            super(itemView);
            // Binds the current view item's components
            clCastItem = itemView.findViewById(R.id.cl_cast_item);
            ivProfile = itemView.findViewById(R.id.iv_cast_profile);
            tvName = itemView.findViewById(R.id.tv_cast_name);
            tvCharacter = itemView.findViewById(R.id.tv_cast_character);

            // Set animation on imageview
            Animation fadeInAnimation = AnimationUtils.loadAnimation(clCastItem.getContext(), R.anim.fade_in);
            ivProfile.startAnimation(fadeInAnimation);
        }
    }
}
