package com.ujjaval.innoventes_task.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.ujjaval.innoventes_task.R;
import com.ujjaval.innoventes_task.activity.MovieDetailActivity;
import com.ujjaval.innoventes_task.models.Movie;

import java.util.ArrayList;
import java.util.List;


/**
 * Movie recyclerview adapter.
 * Adapter that is used by the movie recyclerview.
 */
public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Movie> movies=new ArrayList<>();

    public MovieRecyclerViewAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.cardview_item_movie, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Assigns the results the the current item's components
        System.out.println("////////////////////////////////"+movies.get(position).getPosterSmall());

      //  Picasso.get().load(movies.get(position).getPosterSmall()).into(holder.ivMoviePoster);
        Glide.with(context)
                .load(movies.get(position).getPosterSmall())
                .into(holder.ivMoviePoster);
        // Set click listener
        holder.cvMovieItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Init new intend and pass the movie ID data
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("MovieId", movies.get(position).getMovieId());

                // Start the new movie detail activity
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cvMovieItem;
        ImageView ivMoviePoster;

        public MyViewHolder(View itemView) {
            super(itemView);
            // Binds the current view item's components
            cvMovieItem = itemView.findViewById(R.id.cv_movie_item);
            cvMovieItem.setBackgroundColor(Color.parseColor("#000000"));
            ivMoviePoster = itemView.findViewById(R.id.iv_movie_poster);

            // Set animation on imageview
            Animation fadeInAnimation = AnimationUtils.loadAnimation(cvMovieItem.getContext(), R.anim.fade_in);
            ivMoviePoster.startAnimation(fadeInAnimation); //Set animation to your ImageView
        }
    }
}
